package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@RequestMapping("board/centerList")
	public ModelAndView centerList(Integer pageNum, String searchType, String searchContent) {
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		ModelAndView mav = new ModelAndView();
		int limit = 20;
		int listcount = shopService.centerCount(searchType, searchContent);
		List<Board> centerlist = shopService.centerList(searchType, searchContent, pageNum, limit);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		/*String allsubject = "";
		for(int i=0; i<listcount; i++)
		{
			String[] subject = new String[listcount];
			Board a = centerlist.get(i);
			subject[i] = a.getSubject();
			allsubject += subject[i] + ",";
		}*/
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
	  고객센터 목록 나타내는 기능
	*/
	@RequestMapping("board/centerList2")
	public ModelAndView centerList2(Integer pageNum, String searchType, String searchContent, HttpServletRequest request) {
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		ModelAndView mav = new ModelAndView();
		String password = request.getParameter("password");
		String num = request.getParameter("num");	
		String pageNum2 = request.getParameter("pageNum2");
		Integer pageNum3 = null;
		if(pageNum2 == null)
		{
			pageNum2 = "";
		}
		else if(pageNum2 != null)
		{
			pageNum3 = Integer.parseInt(pageNum2);
		}
		String searchType2 = request.getParameter("searchType2");
		String searchContent2 = request.getParameter("searchContent2");
		System.out.println(num);
		System.out.println(password);
		System.out.println(pageNum3);
		System.out.println(searchType2);
		System.out.println(searchContent2);
		int limit = 20;
		if(pageNum3 == null || searchType2 == null || searchContent2 == null)
		{
			int listcount = shopService.centerCount(searchType, searchContent);
			List<Board> centerlist = shopService.centerList(searchType, searchContent, pageNum, limit);
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
			mav.addObject("centerlist", centerlist);
		}
		else if(pageNum3 != null || searchType2 != null && searchContent != null)
		{
			int listcount = shopService.centerCount(searchType2, searchContent2);
			List<Board> centerlist = shopService.centerList(searchType2, searchContent2, pageNum3, limit);
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
			mav.addObject("centerlist", centerlist);
			mav.addObject("searchType2", searchType2);
			mav.addObject("searchContent2", searchContent2);
		}
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdate.format(new Date());
		mav.addObject("today", today);
		mav.addObject("pageNum", pageNum);
		mav.addObject("num", num);
		mav.addObject("password", password);
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
		/*if(request.getSession().getAttribute("LOGIN_MEMBER") != null)
		{
			shopService.centerInsert(board, request);
		}
		else
		{
			mav.setViewName("redirect:/board/centerList.mall");
		}*/
		shopService.centerInsert(board, request);
		mav.setViewName("redirect:/board/main.mall");
		return mav;
	}
	
	@RequestMapping("board/filedown")
	public void filedown(String filename, HttpServletRequest request, HttpServletResponse response) {
		String filepath = request.getServletContext().getRealPath("/") + "/fileupload/" + filename;
		byte[] buf = new byte[4096];
		FileInputStream fis = null;
		OutputStream out = null;
		try
		{
			fis = new FileInputStream(filepath);
			out = response.getOutputStream(); 
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(filename.getBytes("euc-kr"),"8859_1"));
			int readcnt = 0;
			while((readcnt = fis.read(buf)) != -1)
			{
				out.write(buf, 0, readcnt);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(fis != null)
				{
					fis.close();
				}
				if(out != null)	
				{
					out.flush();
					out.close();
				}
			}
			catch(IOException e)
			{
				
			}
		}
	}
	
}