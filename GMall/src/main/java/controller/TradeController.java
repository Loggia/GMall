package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.JooService;
import logic.KoService;
import logic.KuService;
import logic.Member;
import logic.Product;
import logic.Trade;
import logic.Coupon_history;

@Controller
public class TradeController 
{
	@Autowired 
	public JooService jooService; // 주한울
	@Autowired
	public KoService koService; // 종환이꺼
	@Autowired 
	public KuService kuService; // 정연이껑
	
	/*
	 * 거래 목록
	 */
	@RequestMapping("trade/BSList")
	public ModelAndView BSList(Member member, Integer pageNum, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView("trade/BSList");
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		
		if(login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
		}
		
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		
		int limit = 10;
		int listcount = jooService.tradeCount(login.getId(), login.getType());
		List<Trade> trdList = jooService.tradeList(login.getId(), login.getType(), pageNum, limit);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("trdList", trdList);
		mav.addObject("pageNum", pageNum);
		mav.addObject("member", login);
		
		return mav;
	}
	
	@RequestMapping("trade/delvpage.mall")
	public ModelAndView delvpage(Member member, Integer pageNum, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		
		/*
		 * 변수명 공모전 합니다 ㅋㅋㅋ
		 */
		int pro_ready = 0; // 상품 준비중
		int del_ready = 0; // 배송 준비중
		int deliverying = 0; // 배송 중
		int del_complete = 0; // 배송 완료
		
		if(login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
			
		}
		
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		
		int limit = 10;
		int listcount = jooService.delvpageCount(login.getId(), login.getType());
		List<Trade> delivery = koService.delvpageList(login.getId(), login.getType(), pageNum, limit);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		
		/*
		 * 배송 상태 카운팅
		 */
		for(Trade t : delivery)
		{
			if(t.getDelivery().equals("상품준비중"))
			{
				pro_ready++;
			}
			else if(t.getDelivery().equals("배송준비중"))
			{
				del_ready++;
			}
			else if(t.getDelivery().equals("배송중"))
			{
				deliverying++;
			}
			else if(t.getDelivery().equals("배송완료"))
			{
				del_complete++;
			}
		}
			
		mav.addObject("pro_ready", pro_ready);
		mav.addObject("del_ready", del_ready);
		mav.addObject("deliverying", deliverying);
		mav.addObject("del_complete", del_complete);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("delivery", delivery);
		mav.addObject("pageNum", pageNum);
		mav.addObject("member", login);   
		
		return mav;
	}
	
	// 주한울 - 쿠폰 목록 조회
	@RequestMapping("trade/couppage.mall")
	public ModelAndView couppage(Member member, Integer pageNum, HttpSession session, HttpServletRequest request) 
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		String discount = request.getParameter("discount");
		
		if(login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
		}
		
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		
		if(discount == null || discount.equals(""))
		{
			discount = "0";
		}
		
		int limit = 10;
		int listcount = jooService.couponCount(login.getId(), login.getType(), discount);
		List<Coupon_history> couponList = jooService.couponList(login.getId(), login.getType(), discount, pageNum, limit);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("couponList", couponList);
		mav.addObject("pageNum", pageNum);
		mav.addObject("discount", discount);
		mav.addObject("member", login);
		
		return mav;
	}
	
	// 고종환 사업자 쿠폰목록 카테고리 선택시 ${path}/trade/bus_couponCheck.mall?category=10
	@RequestMapping("trade/couponDiscountCheck")
	public ModelAndView couponDiscountCheck(HttpSession session,HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView("trade/couppage");
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		String discount = request.getParameter("discount");
		List<Coupon_history> couponList = null;
				
		if(login.getType() == 1)
		{
			couponList = jooService.memberDiscountCheck(login.getId(), discount);
		}
		else if(login.getType() == 2)
		{
			couponList = koService.bisDiscountCheck(login.getId(), discount);
		}
				
		mav.addObject("couponList", couponList);
		mav.addObject("member",login);
		return mav;
	}
	
	//deliveryControl 사업자 배송 조절
	@RequestMapping("trade/deliveryControl")
	public ModelAndView deliveryControl(Member member, Integer pageNum, HttpSession session,HttpServletRequest request){
		ModelAndView mav=new ModelAndView("trade/delvpage");
		Member login=(Member) session.getAttribute("LOGIN_MEMBER");
		String trd_no=request.getParameter("trd_no");
		String tradeCheck= koService.tradeCheck(trd_no);
		if(tradeCheck.equals("상품준비중")){
			tradeCheck="배송준비중";
		}else if(tradeCheck.equals("배송준비중")){
			tradeCheck="배송중";
		}else if(tradeCheck.equals("배송중")){
			tradeCheck="배송완료";
		}
		
		koService.deliveryControl(trd_no,tradeCheck);
		int pro_ready = 0; // 상품 준비중
		int del_ready = 0; // 배송 준비중
		int deliverying = 0; // 배송 중
		int del_complete = 0; // 배송 완료
		
		if(login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
			
		}
		
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		
		int limit = 10;
		int listcount = jooService.delvpageCount(login.getId(), login.getType());
		List<Trade> delivery = koService.delvpageList(login.getId(), login.getType(), pageNum, limit);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		
		/*
		 * 배송 상태 카운팅
		 */
		for(Trade t : delivery)
		{
			if(t.getDelivery().equals("상품준비중"))
			{
				pro_ready++;
			}
			else if(t.getDelivery().equals("배송준비중"))
			{
				del_ready++;
			}
			else if(t.getDelivery().equals("배송중"))
			{
				deliverying++;
			}
			else if(t.getDelivery().equals("배송완료"))
			{
				del_complete++;
			}
		}
			
		mav.addObject("pro_ready", pro_ready);
		mav.addObject("del_ready", del_ready);
		mav.addObject("deliverying", deliverying);
		mav.addObject("del_complete", del_complete);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("delivery", delivery);
		mav.addObject("pageNum", pageNum);
		mav.addObject("member", login);   
		
		return mav;
		}
}