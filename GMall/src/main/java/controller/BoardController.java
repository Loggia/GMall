package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import logic.Board;
import logic.Member;
import logic.ShopService;

@Controller
public class BoardController 
{
	@Autowired
	public ShopService shopService;
	
	@RequestMapping("board/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(new Member());
		return mav;
	}
	
	/*
	 무한스크롤 아래목록 불러오는 기능 
	*/
	@RequestMapping(value="board/infiniteScrollDown", method=RequestMethod.POST)
	public @ResponseBody List<Board> infiniteScrollDownPOST(@RequestBody Board board) {
		int numToStart = board.getBoard_no()-1;
		return shopService.infiniteScrollDown(numToStart);		
	}
	
	/*
	 무한스크롤 위목록 불러오는 기능 
	*/
	@RequestMapping(value="board/infiniteScrollUp", method=RequestMethod.POST)
	public @ResponseBody List<Board> infiniteScrollUpPOST(@RequestBody Board board) {
		int numToEnd = board.getBoard_no()+1;
		return shopService.infiniteScrollUp(numToEnd);	 	
	}	
	
	/*
	 상품 리스트 불러오는 기능 
	*/
	@RequestMapping(value="board/proList", method = RequestMethod.GET)
	public ModelAndView proList() {
		ModelAndView mav = new ModelAndView();
		List<Board> prolist = shopService.proList();
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdate.format(new Date());
		mav.addObject("today", today);
		mav.addObject("prolist", prolist);
		return mav;
	}
	
	/*
	 고객센터 리스트 불러오는 기능 
	*/
	@RequestMapping("board/centerlist")
	public ModelAndView list(Integer pageNum) {
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		ModelAndView mav = new ModelAndView();
		int limit = 10;
		int listcount = shopService.centerCount();
		List<Board> centerlist = shopService.centerList(pageNum, limit);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdate.format(new Date());
		mav.addObject("today", today);
		mav.addObject("pageNum", pageNum);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("centerlist", centerlist);
		return mav;
	}
	
	/*
	  고객센터 글 추가 기능
	*/
	@RequestMapping("board/centerAdd")
	public ModelAndView centerAdd() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(new Board());
		return mav;
	}
	
	/*
	 고객센터 글 작성 기능
	*/
	@RequestMapping("board/centerwrite")
	public ModelAndView centerwrite(Board board, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		shopService.centerInsert(board, request);
		mav.setViewName("redirect:/board/main.mall");
		return mav;
	}
	
}