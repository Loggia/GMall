package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.ShopService;

@Controller
public class TradeController 
{
	
	@Autowired
	public ShopService shopService;
	
	@RequestMapping("trade/BSList.mall")
	public ModelAndView BSList(Member member, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		mav.addObject("member", login);
		return mav;
	}
}
