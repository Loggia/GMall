package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.HDService;
import logic.Member;
import logic.Message;

@Controller
public class MessageController {
	
	@Autowired
	public HDService hdService;
	
	@RequestMapping("member/talkpage")
	public ModelAndView talkpage(HttpSession session, Integer pageNum) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		
		if (pageNum == null || pageNum.toString().equals("")) 
		{
			pageNum = 1;
		}
		
		int limit = 8;
		int listcount = hdService.reciveListCount(loginUserId);
		List<Message> reciveList = hdService.reciveList(loginUserId,pageNum, limit);
		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = (((int) ((double) pageNum / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = startpage + 9;

		if (endpage > maxpage) 
		{
			endpage = maxpage;
		}

		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("reciveList", reciveList);
		mav.addObject("pageNum", pageNum);
		mav.addObject("member", loginUser);
		
		return mav;
	}
	
	@RequestMapping("member/sendListForm")
	public ModelAndView sendListForm(HttpSession session, Integer pageNum) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		
		if (pageNum == null || pageNum.toString().equals("")) 
		{
			pageNum = 1;
		}
		
		int limit = 8;
		int listcount = hdService.sendListCount(loginUserId);
		System.out.println("listcount: "+listcount);
		List<Message> sendList = hdService.sendList(loginUserId,pageNum, limit);
		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = (((int) ((double) pageNum / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = startpage + 9;
		System.out.println("endpage :"+endpage);
		System.out.println("maxpage :"+maxpage);
		if (endpage > maxpage) 
		{
			endpage = maxpage;
		}
		System.out.println("startpage :"+startpage);
		System.out.println("endpage :"+endpage);
		System.out.println("maxpage :"+maxpage);
		System.out.println("pageNum :"+pageNum);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("sendList", sendList);
		mav.addObject("pageNum", pageNum);
		
		mav.addObject("member", loginUser);
		return mav;
	}
	
	@RequestMapping("member/msgDetail")
	public ModelAndView msgDetail(HttpSession session, Integer msg_no) {
		Message message = hdService.msgDetail(msg_no);
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		mav.addObject("member", loginUser);
		mav.addObject("message", message);
		return mav;
	}
	
	@RequestMapping("member/msgWriteForm")
	public ModelAndView msgWirteForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		mav.addObject("member", loginUser);
		mav.addObject(new Message());
		return mav;
	}
	
	@RequestMapping("member/msgSend")
	public ModelAndView msgWirte(HttpSession session, Message message, HttpServletRequest request) {
		//String send_id = request.getParameter("send_id");
		hdService.msgSend(message);
		System.out.println(message);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/talkpage.mall");
		return mav;
	}
	
	@RequestMapping("member/msgDelete")
	public ModelAndView msgDelete(HttpSession session, Integer msg_no) {
		hdService.msgDelete(msg_no);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/talkpage.mall");
		return mav;
	}
	
}
