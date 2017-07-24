package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
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
	public ModelAndView join(Member member)
	{
		ModelAndView mav = new ModelAndView("board/main");
		
		if(member.getType() == 1)
		{
			member.setBis_no("");
			member.setBis_name("");
		}
		
		shopService.insertMember(member);
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
		Member login = shopService.selectMember(member.getId());
		if(login.getId().equals(member.getId()) && login.getPass().equals(member.getPass()))
		{
			request.getSession().setAttribute("LOGIN_MEMBER", login);
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
		mav.addObject("member", login);
		
		/* 
		 * form 만들어지면 추가
		 */
		
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
