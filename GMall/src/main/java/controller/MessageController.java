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
		List<Message> sendList =  hdService.sendList(loginUserId);
		mav.addObject("member", loginUser);
		mav.addObject("sendList", sendList);
		return mav;
	}
	
	@RequestMapping("member/reciveListForm")
	public ModelAndView reciveListForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		List<Message> reciveList = hdService.reciveList(loginUserId);
		mav.addObject("reciveList", reciveList);
		return mav;
	}
	
	@RequestMapping("member/msgDetail")
	public ModelAndView msgDetail(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//hdService.msgDetail();
		return mav;
	}
	
	@RequestMapping("member/msgWriteForm")
	public ModelAndView msgWirteForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member loginUser = (Member)session.getAttribute("LOGIN_MEMBER");
		String loginUserId = loginUser.getId();
		//hdService.msgWriteForm();
		return mav;
	}
	
	@RequestMapping("member/msgSend")
	public ModelAndView msgWirte(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//hdService.msgSend();
		return mav;
	}
	
	@RequestMapping("member/msgDelete")
	public ModelAndView msgDelete(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//hdService.msgDelete();
		return mav;
	}
	
}
