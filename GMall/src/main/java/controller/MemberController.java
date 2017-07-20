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
	@RequestMapping("board/join")
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
	@RequestMapping("board/login")
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
	@RequestMapping("board/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("board/main");
		session.invalidate();
		System.out.println("로그아웃 성공");
		return mav;
		
	}
	
	/*
	 * 우동
	 * 인포폼
	 */
	
	@RequestMapping("member/infoForm")
	public ModelAndView infoForm(HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping("member/adminMain")
	public ModelAndView admin(){
			
			ModelAndView mav = new ModelAndView();
			List<Trade> tradeList = shopService.tradeList();
			mav.addObject("tradeList",tradeList);
			return mav;
		
	}
}
