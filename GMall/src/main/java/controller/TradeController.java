package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.ShopService;
import logic.Trade;

@Controller
public class TradeController 
{
	
	@Autowired
	public ShopService shopService;
	
	/*
	 * 거래 목록
	 */
	@RequestMapping("trade/BSList.mall")
	public ModelAndView BSList(Member member, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		List<Trade> trdList = null;
		
		if(login.getType() == 1) // 일반회원 (주한울)
		{
			trdList = shopService.tradeBuyList(login.getId());
		}
		else if(login.getType() == 2) // 사업자
		{
			
		}
		else if(login.getType() == 3) // 관리자
 		{
			
		}
		
		mav.addObject("member", login);   
		
		return mav;
	}
	
	@RequestMapping("trade/delvpage.mall")
	public ModelAndView delvpage(Member member, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		mav.addObject("member", login);   
		return mav;
	}
	
}
