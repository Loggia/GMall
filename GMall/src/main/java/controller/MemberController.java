package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;

@Controller
public class MemberController 
{
	/*
	 * 주한울
	 * 회원가입 폼(joinForm) 이동 메서드
	 */
	@RequestMapping("member/joinForm")
	public ModelAndView moveJoinForm()
	{
		ModelAndView mav = new ModelAndView();
		Member member = new Member();
		
		member.setType(1); // 회원 구분 - 디폴트를 일반 회원으로
		mav.addObject("member", member);
		
		return mav;
	}
}
