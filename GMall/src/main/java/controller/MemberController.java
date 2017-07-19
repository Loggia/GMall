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
	@RequestMapping("member/join")
	public ModelAndView join(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("board/main");
		Member member = new Member();
			
		member.setType(Integer.parseInt(request.getParameter("type")));
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		member.setNickname(request.getParameter("nickname"));
		member.setGender(Integer.parseInt(request.getParameter("gender")));
		member.setTel(request.getParameter("tel"));
		member.setAddress(request.getParameter("address"));
		member.setInterest(request.getParameter("interest"));
		
		if(member.getType() == 2)
		{
			member.setBis_no(request.getParameter("bis_no"));
			member.setBis_name(request.getParameter("bis_name"));
		}
		
		shopService.insertMember(member);
		return mav;
	}
}
