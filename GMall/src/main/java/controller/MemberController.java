package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;

@Controller
public class MemberController 
{
	/*
	 * 주한울
	 * 회원가입 폼으로 이동
	 */
	@RequestMapping("member/joinForm")
	public ModelAndView moveJoinForm(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView();
		Member member = new Member();
		
		member.setType(1); 
		mav.addObject("member", member);
		
		return mav;
	}
}
