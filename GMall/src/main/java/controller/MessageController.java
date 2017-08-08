package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.HDService;
import logic.Member;

@Controller
public class MessageController {
	
	@Autowired
	public HDService hdService;
	
	@RequestMapping("message/sendListForm")
	public ModelAndView sendListForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		//List<> sendList =  hdService.sendList(loginUserId);
		return mav;
	}
	
	@RequestMapping("message/reciveListForm")
	public ModelAndView reciveListForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		//hdService.reciveList(loginUserId);
		return mav;
	}
	
	@RequestMapping("message/msgDetail")
	public ModelAndView msgDetail(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//hdService.msgDetail();
		return mav;
	}
	
	@RequestMapping("message/msgWriteForm")
	public ModelAndView msgWirteForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		//hdService.msgWriteForm();
		return mav;
	}
	
	@RequestMapping("message/msgSend")
	public ModelAndView msgWirte(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//hdService.msgSend();
		return mav;
	}
	
	@RequestMapping("message/msgDelete")
	public ModelAndView msgDelete(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//hdService.msgDelete();
		return mav;
	}
	
}
