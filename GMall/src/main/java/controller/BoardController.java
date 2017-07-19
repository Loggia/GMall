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
import logic.ShopService;

@Controller
public class BoardController 
{
	@Autowired
	public ShopService shopService;
	
	@RequestMapping("board/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="board/infiniteScrollDown", method=RequestMethod.POST)
	public @ResponseBody List<Board> infiniteScrollDownPOST(@RequestBody Board board) {
		int numToStart = board.getNum()-1;
		return shopService.infiniteScrollDown(numToStart);		
	}
	
	@RequestMapping(value="board/infiniteScrollUp", method=RequestMethod.POST)
	public @ResponseBody List<Board> infiniteScrollUpPOST(@RequestBody Board board) {
		int numToEnd = board.getNum()+1;
		return shopService.infiniteScrollUp(numToEnd);	 	
	}	
	
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
	
	@RequestMapping("board/centerlist")
	public ModelAndView list(Integer pageNum, String searchType, String searchContent) {
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		ModelAndView mav = new ModelAndView();
		int limit = 10;
		int listcount = shopService.centerCount(searchType, searchContent);
		List<Board> centerlist = shopService.centerList(searchType, searchContent, pageNum, limit);
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
	
	@RequestMapping("board/centerAdd")
	public ModelAndView customerAdd() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(new Board());
		return mav;
	}
	
	@RequestMapping("board/centerwrite")
	public ModelAndView write(Board board, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		shopService.centerInsert(board, request);
		mav.setViewName("redirect:/board/centerlist.shop");
		return mav;
	}
}
