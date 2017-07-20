package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.ShopService;

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
		System.out.println(member.getId());
		
		if(login.getId().equals(member.getId()) && login.getPass().equals(member.getPass()))
		{
			request.getSession().setAttribute("LOGIN_MEMBER", login);
		}
		
		// 팝업창이 생기면 로그인이 안됬을 때 팝업창이 뜨게 설정
		
		return mav;
	}
}
