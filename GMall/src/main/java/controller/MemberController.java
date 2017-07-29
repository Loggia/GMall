package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.JooService;
import logic.KoService;
import logic.Member;
import logic.Product;
import logic.ShopService;
import logic.Trade;

@Controller
public class MemberController 
{
	@Autowired 
	public JooService jooService; // 주한울 서비스
	@Autowired
	public KoService koService;
	
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
			
			jooService.insertMember(member);
		}
		else if(member.getType() == 2)
		{
			if(jooService.cheakMember(member.getBis_no()))
			{
				List<String> bis_no = jooService.selectBis_no(); // 임의로 추가한 사업자 번호를 쿼리
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
				
				jooService.insertMember(member);
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
			Member login = jooService.getUserByIdAndPw(member.getId(), member.getPass());
			
			
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
		
		if(login == null)
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
		}
		
		if(login.getType() == 1) 
		{
			List<Member> bookmark = jooService.selectBookmark(login.getId());
			List<Product> newsfeed = jooService.selectNewsFeed(login.getId());
			
			if(bookmark != null)
			{
				mav.addObject("bookmark", bookmark);
				
				if(newsfeed != null)
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
			List<Product> myBis_list = koService.getProductList(login.getBis_no());//내아이디만
			mav.addObject("myBis_list",myBis_list);
		}
		/*else if(login.getType() == 3)
		{
			
		}*/
		
		mav.addObject("member", login);
		return mav;
	}
	
	/*
	 * 우동
	 * 고객센터폼
	 */
	@RequestMapping("member/cs")
	public ModelAndView cs(Member member, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		mav.addObject("member", login);
		return mav;
	}
	
	/*
	 * 주한울
	 * 회원 정보 상세보기 계정 검증폼으로 이동
	 */
	@RequestMapping("member/passConfirmForm")
	public ModelAndView passConfirmForm(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("member/passConfirm");
		
		return mav;
	}
	
	/*
	 * 주한울
	 * 회원 정보 상세보기 (입력 비밀번호와 로그인 비밀번호가 동일하면 infoForm으로 이동)
	 */
	@RequestMapping("member/passConfirm")
	public ModelAndView passConfirm(HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("member/mypage");
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		String pass = request.getParameter("pass");
		
		if(login.getPass().equals(pass))
		{
			mav.setViewName("member/infoForm");
		}
		else
		{
			mav.setViewName("alert");
			mav.addObject("url", "../member/passConfirmForm.mall");
			mav.addObject("msg", "잘못된 비밀번호입니다.");
		}
		
		mav.addObject("member", login);
		return mav;
	}
	
	/*
	 * 사나쨩
	 * 회원 인포폼
	 */
	@RequestMapping("member/infoForm")
	public ModelAndView infoForm(Member member, HttpSession session, String id) {
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		
		if(login == null)
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
		}
		// 구정연 관리자에서 회원수정
		mav.addObject("member", login);
		
		if(login.getId().equals("admin")){
			
			Member user = shopService.getUserById(id);
			mav.addObject("member" , user);
			
		}
		
		return mav;
	} 
	
	/*
	 * 주한울
	 * 회원 수정 기능
	 */
	@RequestMapping("member/update")
	public ModelAndView update(Member member, HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("member/mypage");
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		String passfirm = request.getParameter("passfirm");
		
		if(login.getId().equals(member.getId()))
		{
			if(member.getPass().equals(passfirm))
			{
				if(member.getPass().equals(""))
				{
					member.setPass(login.getPass());
				}
				
				jooService.updateMember(member, request);
				session.invalidate(); // 회원이 수정되면 세션 만료
				request.getSession().setAttribute("LOGIN_MEMBER", member); // 수정된 정보로 다시 세션 생성
			}
			else
			{
				mav.setViewName("alert");
				mav.addObject("url", "../member/mypage.mall");
				mav.addObject("msg", "입력한 비밀번호가 일치하지 않습니다.");
			}
		}
		//구정연 - 일반회원목록 수정
		else if(login.getId().equals("admin"))
		{
			if(member.getPass().equals(passfirm))
			{
				if(member.getPass().equals(""))
				{
					member.setPass(login.getPass());
				}
				
				jooService.updateMember(member, request);
			}
			else
			{
				mav.setViewName("alert");
				mav.addObject("url", "../trade/BSList.mall");
				mav.addObject("msg", "입력한 비밀번호가 일치하지 않습니다.");
			}
			 mav.setViewName("redirect:/trade/BSList.mall");
		}
		else
		{
			mav.setViewName("alert");
			mav.addObject("url", "../member/mypage.mall");
			mav.addObject("msg", "자신의 아이디만 수정 가능합니다.");
		}
		
		mav.addObject("member", member);
		return mav;
	}
	
	/*
	 * 주한울
	 * 회원 탈퇴
	 */
	@RequestMapping("member/delete")
	public ModelAndView delete(Member member, HttpSession session , String id)
	{
		ModelAndView mav = new ModelAndView("board/main");
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		Member user = shopService.getUserById(id);
		
		if(login == null)
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "회원만 탈퇴 가능합니다.");
			
			return mav;
		}
		
		if(login.getId().equals(member.getId()) || login.getId().equals("admin"))
		{
			if(login.getId().equals(member.getId()))
			{
				if(login.getPass().equals(member.getPass()))
				{
	
					jooService.deleteMember(member);
					session.invalidate();
					
				}
				else
				{
					mav.setViewName("alert");
					mav.addObject("url", "../member/mypage.mall");
					mav.addObject("msg", "비밀번호를 확인하세요.");
				}
				
			}
			else 
			{
				jooService.deleteMember(user);
			}
		}
		else
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "본인의 계정만 탈퇴 가능합니다.");
		}
		
		return mav;
	}
	
	/*
	 * 구정연 
	 * 일반회원관리
	 */
	
	@RequestMapping("member/nomalList")
	public ModelAndView nomalList (HttpSession session) {
		
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		ModelAndView mav = new ModelAndView() ;
		List<Member> nomalList = shopService.nomalList();
		mav.addObject ("nomalList" , nomalList) ;
		mav.addObject("member", login);
		return mav; 
		
	}
	/*
	 * 구정연 
	 * 사업자관리
	 */
	@RequestMapping("member/businessList")
	public ModelAndView businessList (HttpSession session) {
		
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		ModelAndView mav = new ModelAndView() ;
		List<Member> businessList = shopService.businessList();
		mav.addObject ("businessList" , businessList) ;
		mav.addObject("member", login);
		return mav; 
		
	}
	
	/*
	 * 구정연
	 * 보유금액 & 수익금관리
	 */
	@RequestMapping("member/moneypage")
	public ModelAndView moneypage(HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		List<Trade> tradeList = null; // shopService.tradeList();
		
		if(login.getType() == 3)
		{
			tradeList = shopService.tradeList();
		}
		else
		{
			tradeList = shopService.moneyChangeList(login);
		}
		
		mav.addObject("tradeList",tradeList);
		mav.addObject("member", login);
		return mav;
	}
	
	/*
	 * 구정연
	 * 프리미엄
	 */
	@RequestMapping("member/primlist")
	public ModelAndView prim() {
		ModelAndView mav = new ModelAndView();
		List<Member> primList = shopService.primList();
		mav.addObject("primList" , primList);
		return mav;
	}
	
	/*
	 * 구정연 
	 * 프리미엄 업데이트
	 * 구매 판매 리뷰시에 업데이트해주기
	 */
	@RequestMapping("member/primup")
	public ModelAndView primup() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	@RequestMapping("member/primupdate")
	public ModelAndView primupdate() {
		ModelAndView mav = new ModelAndView();
		shopService.primupdate();
		List<Member> primList = shopService.primList();
		mav.addObject("primList" , primList);
		return mav;
		
	}
}