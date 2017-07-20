package controller;

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
}
