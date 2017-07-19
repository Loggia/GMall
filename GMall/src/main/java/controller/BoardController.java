package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController 
{
	@RequestMapping("board/main")
	public ModelAndView main() {
		System.out.println("board");
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
