package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.Product;
import logic.ShopService;
import logic.Trade;
import logic.coupon_history;

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
		
		if(login.getType() == 1){
			//한울이 쿠폰
		}else if(login.getType() == 2){// 고종환 사업자 쿠폰관리
			    String id=login.getId();
			    List<coupon_history> bus_coupon=shopService.bus_coupon(id);
		     	mav.addObject("bus_coupon",bus_coupon);
		}
		
		
		mav.addObject("member", login);   
		return mav;
	}
	//고종환 사업자 쿠폰관리 카테고리 ${path}/trade/bus_couponCheck.mall?category=10
	@RequestMapping("trade/bus_couponCheck")
	public ModelAndView bus_couponCheck(HttpSession session,HttpServletRequest request){
			String discount=request.getParameter("discount");
			Member login=(Member)session.getAttribute("LOGIN_MEMBER");
			String id=login.getId();
			
			List<coupon_history> bus_coupon=shopService.bus_couponCheck(id,discount);
			ModelAndView mav=new ModelAndView("trade/couppage");
			mav.addObject("bus_coupon",bus_coupon);
			mav.addObject("member",login);
			return mav;
		}
}
