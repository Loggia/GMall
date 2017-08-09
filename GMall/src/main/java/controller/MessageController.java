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
	public ModelAndView talkpage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		List<Message> reciveList =  hdService.reciveList(loginUserId);
		mav.addObject("member", loginUser);
		mav.addObject("reciveList", reciveList);
		return mav;
	}
	
	@RequestMapping("member/sendListForm")
	public ModelAndView sendListForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		List<Message> sendList = hdService.sendList(loginUserId);
		mav.addObject("member", loginUser);
		mav.addObject("sendList", sendList);
		return mav;
	}
	
	@RequestMapping("member/msgDetail")
	public ModelAndView msgDetail(HttpSession session, Integer msg_no) {
		Message message = hdService.msgDetail(msg_no);
		ModelAndView mav = new ModelAndView();
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
	public ModelAndView msgDelete(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/talkpage.mall");
		//hdService.msgDelete();
		return mav;
	}
	
}
