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
		
		if(login == null)
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
		}
		
		if(login.getType() == 1) // 일반회원 (주한울)
		{
			trdList = shopService.tradeBuyList(login.getId());
			
			if(trdList != null)
			{
				mav.addObject("trdList", trdList);
			}
			else
			{
				mav.addObject("trdList", new Trade());
			}
		}
		else if(login.getType() == 2) // 사업자
		{
			String id=login.getId();
			
			List<Trade> tradeList=shopService.tradeList(id);
			mav.addObject("tradeList",tradeList);
			
		}
		else if(login.getType() == 3) // 관리자
 		{
			List<Trade> tradeList = shopService.tradeList();
			mav.addObject("tradeList",tradeList);
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
	
	@RequestMapping("trade/couppage.mall")
	public ModelAndView couppage(Member member, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		mav.addObject("member", login);   
		return mav;
	}
	
}
