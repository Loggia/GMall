package controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Cart;
import logic.Coupon;
import logic.KuService;
import logic.Member;
import logic.Trade;

@Controller
public class CheckoutController {

	@Autowired 
	public KuService kuService;
	
	@RequestMapping("board/checkout")
		public ModelAndView checkout (HttpSession session) {
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		if (login == null){
			ModelAndView mav = new ModelAndView("board/proList");
			mav.setViewName("alert");
			mav.addObject("msg","물건을 사려면 로그인부터!");
			return mav;
		}
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		ModelAndView mav = new ModelAndView();
		Integer totalAmount = kuService.totalAmount(cart.getProductList());
		String id = login.getId();
		
		List<Coupon> coupon = kuService.selectcoupon(id); //쿠폰
		
		mav.addObject("loginMember" , login);
		mav.addObject("proList",cart.getProductList());
		mav.addObject("totalAmount" , totalAmount);
		mav.addObject("coupon" , coupon); 
			return mav;
	}
	
		@RequestMapping("board/end")
		public ModelAndView end (HttpSession session, String trd_address) {
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		if (login == null){
			ModelAndView mav = new ModelAndView("board/proList");
			mav.setViewName("alert");
			mav.addObject("msg","물건을 사려면 로그인부터!");
			return mav;
		}
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		String id = login.getId();
		
		Trade trade = kuService.checkEnd(id,trd_address,cart);
		
		ModelAndView mav = new ModelAndView();
		Integer totalAmount = kuService.totalAmount(cart.getProductList());
		mav.addObject("loginMember" , login);
		mav.addObject("trade",trade);
		mav.addObject("totalAmount" , totalAmount);
		return mav;
	}
}
