package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Cart;
import logic.Coupon;
import logic.Coupon_history;
import logic.KuService;
import logic.Member;
import logic.Product;
import logic.ProductSet;
import logic.Trade;

@Controller
public class CheckoutController 
{
	@Autowired 
	public KuService kuService;
	
	@RequestMapping("board/checkout")
	public ModelAndView checkout (HttpServletRequest request, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		String selectCoupon = request.getParameter("selectCoupon");
		
		if (login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/proList.mall");
			mav.addObject("msg","물건을 사려면 로그인부터!");
			
			return mav;
		}
		
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		List<Coupon_history> coupon_history = kuService.selectCoupon(login.getId()); //쿠폰
		
		if(selectCoupon != null)
		{
			/*
			 * history 배열에는 순서대로
			 * 0번지: his_no
			 * 1번지: bis_no
			 * 2번지: discount
			 */
			
			String history[] = selectCoupon.split("/");
			
			for(ProductSet p : cart.getProductList())
			{
				p.setProduct(kuService.getproductByNo(p.getProduct().getPro_no()));
				
				if(p.getProduct().getBis_no().equals(history[1]))
				{
					double discount = Double.parseDouble(history[2])*0.01; 
					int discountPrice = (int)(p.getProduct().getPrice()*discount); // 할인금액 구하기
					p.getProduct().setPrice(p.getProduct().getPrice()-discountPrice); // 원래 값에서 할인 금액을 -
				}
			}
			
			mav.addObject("selectCoupon", selectCoupon);
		}
		else
		{
			mav.addObject("selectCoupon", "할인 쿠폰");
		}
		
		Integer totalAmount = kuService.totalAmount(cart.getProductList());
		
		mav.addObject("member", login);
		mav.addObject("proList", cart.getProductList());
		mav.addObject("totalAmount", totalAmount);
		mav.addObject("coupon_history", coupon_history); 
		
		return mav;
	}
	
	@RequestMapping("board/end")
	public ModelAndView end (HttpSession session, String trd_address) 
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		
		if (login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/proList.mall");
			mav.addObject("msg","물건을 사려면 로그인부터!");
			return mav;
		}
		
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		Trade trade = kuService.checkEnd(login.getId(), trd_address, cart);
		Integer totalAmount = kuService.totalAmount(cart.getProductList());
		
		mav.addObject("loginMember" , login);
		mav.addObject("trade",trade);
		mav.addObject("totalAmount" , totalAmount);
		
		return mav;
	}
}
