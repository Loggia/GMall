package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.Product;
import logic.ShopService;
import logic.Trade;

@Controller
public class MemberController 
{
	@Autowired
	public ShopService shopService;
	
	/*
	 * 주한울
	 * 회원가입 
	 */
	@RequestMapping("member/join")
	public ModelAndView join(Member member) // id=resd  // 5자리 이상을 넣으면 
	{
		ModelAndView mav = new ModelAndView("board/main");
		mav.addObject("url", "../board/main.mall");
		
		if(member.getType() == 1)
		{
			member.setBis_no("");
			member.setBis_name("");
			
			shopService.insertMember(member);
		}
		else if(member.getType() == 2)
		{
			if(shopService.cheakMember(member.getBis_no()))
			{
				List<String> bis_no = shopService.selectBis_no(); // 임의로 추가한 사업자 번호를 쿼리
				boolean flag = false;
				
				for(String no : bis_no) // 입력한 사업자 번호가 추가되어 있는 사업자 번호와 일치하는지 비교
				{
					if(no.equals(member.getBis_no()))
					{
						flag = !flag; // bis_table에 일치하는 사업자 번호가 있다면 flag의 값을 true로 변경
					}
				}
				
				if(!flag)
				{
					mav.setViewName("alert");
					mav.addObject("msg", "중복되는 아이디나 사업자 번호입니다.");
				}
				
				shopService.insertMember(member);
			}
			else
			{
				mav.setViewName("alert");
				mav.addObject("msg", "회원가입이 실패하였습니다.");
			}
		}
		else
		{
			mav.setViewName("alert");
			mav.addObject("msg", "회원가입이 실패하였습니다.");
		}
		
		return mav;
	}
	
	/*
	 * 주한울
	 * 로그인 기능
	 */
	@RequestMapping("member/login")
	public ModelAndView login(Member member, HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("board/main");
		
		try
		{
			Member login = shopService.getUserByIdAndPw(member.getId(), member.getPass());
			
			
			if(login == null || !login.getId().equals(member.getId()) || !login.getPass().equals(member.getPass()))
			{
				mav.setViewName("alert");
				mav.addObject("url", "../board/main.mall");
				mav.addObject("msg", "아이디나 비밀번호를 잘못입력하셨습니다.");
				
				return mav;
			}
			
			request.getSession().setAttribute("LOGIN_MEMBER", login);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
			
		// 팝업창이 생기면 로그인이 안됬을 때 팝업창이 뜨게 설정
		
		return mav;
	}
	 
	/*
	 * 우동
	 * 로그아웃
	 */
	@RequestMapping("member/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("board/main");
		session.invalidate();
		System.out.println("로그아웃 성공");
		
		return mav;
	}
	
	/*
	 * 주한울
	 * 상세보기
	 */
	@RequestMapping("member/mypage")
	public ModelAndView mypage(HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		
		if(login.getType() == 1)
		{
			List<Member> bookmark = shopService.selectBookmark(login.getId());
			List<Product> newsfeed = shopService.selectNewsFeed(login.getId());
			
			if(!(bookmark == null))
			{
				mav.addObject("bookmark", bookmark);
				
				if(!(newsfeed == null))
				{
					mav.addObject("newsfeed", newsfeed);
				}
				else
				{
					mav.addObject("newsfeed", new Product());
				}
			}
			else
			{
				mav.addObject("bookmark", new Member());
			}
		}
		else if(login.getType() == 2)
		{
			// 사업자
		}
		
		mav.addObject("member", login);
		return mav;
	}
	
	@RequestMapping("member/cs.mall")
	public ModelAndView BSList(Member member, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		mav.addObject("member", login);
		return mav;
	}
	
	/*
	 * 주한울
	 * 회원 수정 기능
	 */
	@RequestMapping("member/update")
	public ModelAndView update(Member member, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		
		if(login.getId().equals(member.getId()) && login.getPass().equals(member.getPass()) ||
		   login.getId().equals("admin"))
		{
			shopService.updateMember(member);
		}
		
		return mav;
	}
	
	/*
	 * 주한울
	 * 회원 탈퇴
	 */
	@RequestMapping("member/delete")
	public ModelAndView delete(Member member, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		
		if(login.getId().equals(member.getId()) && login.getPass().equals(member.getPass()) ||
		   login.getId().equals("admin"))
		{
			try
			{
				shopService.deleteMember(member);
				session.invalidate();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		return mav;
	}
	
	@RequestMapping("member/adminForm")
	public ModelAndView admin()
	{
		ModelAndView mav = new ModelAndView();
		List<Trade> tradeList = shopService.tradeList();
		mav.addObject("tradeList",tradeList);
			
		return mav;
	}
	
	/*
	 * 구정연 
	 * 일반회원관리
	 */
	
	@RequestMapping("member/adminNomal")
	public ModelAndView adminNomal () {
		
		ModelAndView mav = new ModelAndView() ;
		List<Member> nomalList = shopService.nomalList();
		mav.addObject ("nomalList" , nomalList) ;
		return mav; 
		
	}
	/*
	 * 구정연 
	 * 사업자관리
	 */
	@RequestMapping("member/adminBusiness")
	public ModelAndView adminBusiness () {
		
		ModelAndView mav = new ModelAndView() ;
		List<Member> businessList = shopService.businessList();
		mav.addObject ("businessList" , businessList) ;
		return mav; 
		
	}
	/*
	 * 구정연
	 * 수익금관리
	 */
	@RequestMapping("member/adminFee")
	public ModelAndView adminFee () {
		
		ModelAndView mav = new ModelAndView();
		List<Trade> tradeList = shopService.tradeList();
		mav.addObject("tradeList",tradeList);
			
		return mav;
		
	}
}
