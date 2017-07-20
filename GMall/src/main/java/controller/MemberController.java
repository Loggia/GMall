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
}
