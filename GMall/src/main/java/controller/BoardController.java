package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import logic.BaeService;
import logic.Board;
import logic.HDService;
import logic.Member;
import logic.Product;
import logic.Trade;

@Controller
public class BoardController 
{
	@Autowired
	public BaeService baeService;
	@Autowired
	public HDService hdService;
	
	@RequestMapping("board/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		List<Product> primList = hdService.primList();
		List<Product> newList = hdService.newList();
		List<Product> popuList = hdService.popuList();
		List<Product> interList = hdService.interList();
		mav.addObject(new Member());
		return mav;
	}
	
	/*
	 상품 리스트 무한스크롤 아래목록 불러오는 기능 
	*/
	@RequestMapping(value="board/infiniteScrollDown", method=RequestMethod.POST)
	public @ResponseBody List<Product> infiniteScrollDownPOST(@RequestBody Product product, HttpServletRequest request) {
		int numToStart = product.getPro_no()-1;
		System.out.println("product1 : " + product);
		String category = product.getCategory();
		return baeService.infiniteScrollDown(numToStart, category);		
	}
	
	/*
	 상품 리스트 무한스크롤 위목록 불러오는 기능 
	*/
	@RequestMapping(value="board/infiniteScrollUp", method=RequestMethod.POST)
	public @ResponseBody List<Product> infiniteScrollUpPOST(@RequestBody Product product, HttpServletRequest request) {
		int numToEnd = product.getPro_no()+1;
		System.out.println("product2 : " + product);
		String category = product.getCategory();
		return baeService.infiniteScrollUp(numToEnd, category);	 	
	}
	
	/*
	 프리미엄 리스트 무한스크롤 아래목록 불러오는 기능 
	*/
	@RequestMapping(value="board/priminfiniteScrollDown", method=RequestMethod.POST)
	public @ResponseBody List<Product> priminfiniteScrollDownPOST(@RequestBody Product product, HttpServletRequest request) {
		int numToStart = product.getPro_no()-1;
		System.out.println("product1 : " + product);
		String category = product.getCategory();
		return baeService.priminfiniteScrollDown(numToStart, category);		
	}
	
	/*
	 프리미엄 리스트 무한스크롤 위목록 불러오는 기능 
	*/
	@RequestMapping(value="board/priminfiniteScrollUp", method=RequestMethod.POST)
	public @ResponseBody List<Product> priminfiniteScrollUpPOST(@RequestBody Product product, HttpServletRequest request) {
		int numToEnd = product.getPro_no()+1;
		System.out.println("product2 : " + product);
		String category = product.getCategory();
		return baeService.priminfiniteScrollUp(numToEnd, category);	 	
	}
	
	/*
	 높은가격 리스트 무한스크롤 아래목록 불러오는 기능 
	*/
	@RequestMapping(value="board/highinfiniteScrollDown", method=RequestMethod.POST)
	public @ResponseBody List<Product> highinfiniteScrollDownPOST(@RequestBody Product product, HttpServletRequest request) {
		int priceStart = product.getPrice();
		System.out.println("product1 : " + product);
		String category = product.getCategory();
		return baeService.highinfiniteScrollDown(priceStart, category);		
	}
	
	/*
	 높은가격 리스트 무한스크롤 위목록 불러오는 기능 
	*/
	@RequestMapping(value="board/highinfiniteScrollUp", method=RequestMethod.POST)
	public @ResponseBody List<Product> highinfiniteScrollUpPOST(@RequestBody Product product, HttpServletRequest request) {
		int priceEnd = product.getPrice();
		System.out.println("product2 : " + product);
		String category = product.getCategory();
		return baeService.highinfiniteScrollUp(priceEnd, category);	 	
	}
	
	/*
	 낮은가격 리스트 무한스크롤 아래목록 불러오는 기능 
	*/
	@RequestMapping(value="board/lowinfiniteScrollDown", method=RequestMethod.POST)
	public @ResponseBody List<Product> lowinfiniteScrollDownPOST(@RequestBody Product product, HttpServletRequest request) {
		int priceStart = product.getPrice();
		System.out.println("product1 : " + product);
		String category = product.getCategory();
		return baeService.lowinfiniteScrollDown(priceStart, category);		
	}
	
	/*
	 낮은가격 리스트 무한스크롤 위목록 불러오는 기능 
	*/
	@RequestMapping(value="board/lowinfiniteScrollUp", method=RequestMethod.POST)
	public @ResponseBody List<Product> lowinfiniteScrollUpPOST(@RequestBody Product product, HttpServletRequest request) {
		int priceEnd = product.getPrice();
		System.out.println("product2 : " + product);
		String category = product.getCategory();
		return baeService.lowinfiniteScrollUp(priceEnd, category);	 	
	}
	
	/*
	 상품 리스트 불러오는 기능 
	*/
	@RequestMapping(value="board/proList", method = RequestMethod.GET)
	public ModelAndView proList(HttpServletRequest request) {
		String category = request.getParameter("category");
		ModelAndView mav = new ModelAndView();
		List<Product> productlist = baeService.proList(category);
		mav.addObject("productlist", productlist);
		return mav;
	}
	
	/*
	 프리미엄 리스트 불러오는 기능 
	*/
	@RequestMapping(value="board/premiumList", method = RequestMethod.GET)
	public ModelAndView premiumList(HttpServletRequest request) {
		String category = request.getParameter("category");
		ModelAndView mav = new ModelAndView();
		List<Product> productlist = baeService.premiumList(category);
		mav.addObject("productlist", productlist);
		return mav;
	}
	
	/*
	 높은가격 리스트 불러오는 기능 
	*/
	@RequestMapping(value="board/highPriceList", method = RequestMethod.GET)
	public ModelAndView highPriceList(HttpServletRequest request) {
		String category = request.getParameter("category");
		ModelAndView mav = new ModelAndView();
		List<Product> productlist = baeService.highPriceList(category);
		mav.addObject("productlist", productlist);
		return mav;
	}
	
	/*
	 낮은가격 리스트 불러오는 기능 
	*/
	@RequestMapping(value="board/lowPriceList", method = RequestMethod.GET)
	public ModelAndView lowPriceList(HttpServletRequest request) {
		String category = request.getParameter("category");
		ModelAndView mav = new ModelAndView();
		List<Product> productlist = baeService.lowPriceList(category);
		mav.addObject("productlist", productlist);
		return mav;
	}
	
	/*
	  고객센터 목록 기능
	  String allsubject = "";
		for(int i=0; i<listcount; i++)
		{
			String[] subject = new String[listcount];
			Board a = centerlist.get(i);
			subject[i] = a.getSubject();
			allsubject += subject[i] + ",";
		}
	*/
	@RequestMapping("board/centerList")
	public ModelAndView centerList(Board board, Integer pageNum, String searchType, String searchContent, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		Member member = null;
		
		if(login == null)
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
		}
		
		if(request.getSession().getAttribute("LOGIN_MEMBER") == null)
		{
			member = new Member();
		}
		
		if(request.getSession().getAttribute("LOGIN_MEMBER") != null)
		{
			member = (Member)request.getSession().getAttribute("LOGIN_MEMBER");
		}
		
		String userid = "";
		
		if(member.getId() == null)
		{
			userid = "guest";
		}
		
		if(member.getId() != null)
		{
			userid = member.getId();
		}
		
		String password = request.getParameter("password");
		String num = request.getParameter("num");	
		
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		
		int limit = 10;
		int listcount = baeService.centerCount(searchType, searchContent);
		List<Board> centerlist = baeService.centerList(searchType, searchContent, pageNum, limit);
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
		mav.addObject("pageNum", pageNum);
		mav.addObject("num", num);
		mav.addObject("password", password);
		mav.addObject("userid", userid);
		mav.addObject("member", login);
			
		Board board1 =  baeService.passthrough(num);
		
	    if(searchType != null && searchContent != null && board1 != null && !board1.getPass().equals(password))
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/centerList.mall?pageNum=" + pageNum + "&searchType=" + searchType + "&searchContent=" + searchContent);
			mav.addObject("msg", "비밀번호를 잘못입력하셨습니다.");
			return mav;
		}
	    else if(pageNum!=null && searchType == null && searchContent == null && board1 != null && !board1.getPass().equals(password))
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/centerList.mall?pageNum=" + pageNum);
			mav.addObject("msg", "비밀번호를 잘못입력하셨습니다.");
			return mav;
		}
	    else if(searchType == null && searchContent == null && board1 != null && !board1.getPass().equals(password))
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/centerList.mall");
			mav.addObject("msg", "비밀번호를 잘못입력하셨습니다.");
			return mav;
		}
	  
		return mav;
	}
	
	/*
	  고객센터 글 추가 기능
	*/
	@RequestMapping("board/centerAdd")
	public ModelAndView centerAdd(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member)request.getSession().getAttribute("LOGIN_MEMBER");
		String userid = member.getId();
		mav.addObject(new Board());
		mav.addObject("userid", userid);
		return mav;
	}
	
	/*
	 고객센터 글 작성 기능
	*/
	@RequestMapping("board/centerwrite")
	public ModelAndView centerwrite(@Valid Board board, BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("board/centerAdd");
		/*if(request.getSession().getAttribute("LOGIN_MEMBER") != null)
		{
			baeService.centerInsert(board, request);
		}
		else
		{
			mav.setViewName("redirect:/board/centerList.mall");
		}*/
		if(bindingResult.hasErrors())
		{
			bindingResult.reject("error.input.user");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		baeService.centerInsert(board, request);
		mav.setViewName("redirect:/board/main.mall");
		return mav;
	}
	
	/*
	  파일다운 기능 
	*/
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
	
	/*
	  글 업데이트폼
	*/
	@RequestMapping("board/centerupdateForm")
	public ModelAndView centerupdateForm(int num, Integer pageNum) {
		ModelAndView mav = new ModelAndView();
		Board board = baeService.getBoard(num);
		mav.addObject("board", board);
		mav.addObject("pageNum", pageNum);	
		return mav;
	}
	
	/*
	  글 업데이트 기능 
	*/
	@RequestMapping("board/centerupdate")
	public ModelAndView centerupdate(@Valid Board board, BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String pass = baeService.getBoardPassword(board.getBoard_no());
		System.out.println("pass:"+pass);
		if(!pass.equals(board.getPass()))
		{
			mav.setViewName("board/centerupdateForm");
			if(!board.getPass().equals(""))
			{
				bindingResult.rejectValue("pass", "error.board.password");
			}
			return mav;
		}
		if(board.getImg1() == null)
		{
			board.setFileurl(request.getParameter("filep"));
		}
		else 
		{
			board.setFileurl(board.getImg1().getOriginalFilename());
		}
		if(board.getImg2() == null)
		{
			board.setFileurl2(request.getParameter("filep2"));
		}
		else 
		{
			board.setFileurl2(board.getImg2().getOriginalFilename());
		}
		if(board.getImg3() == null)
		{
			board.setFileurl3(request.getParameter("filep3"));
		}
		else 
		{
			board.setFileurl3(board.getImg3().getOriginalFilename());
		}
		baeService.boardUpdate(board, request);
		mav.addObject("board", board);
		mav.setViewName("redirect:/board/centerList.mall?pageNum=" + request.getParameter("pageNum"));
		return mav;
	}
	
	/*
	  삭제 폼 
	*/
	@RequestMapping("board/centerdeleteForm")
	public String centerdeleteForm() {
		return "board/centerdeleteForm";
	}
	
	/*
	  글 삭제 기능 
	*/
	@RequestMapping("board/centerdelete")
	public ModelAndView centerdelete(int num, int pageNum, String pass) {
		ModelAndView mav = new ModelAndView();
		String dbpass = baeService.getBoardPassword(num);
		if(pass == null && dbpass == null)
		{
			baeService.boardDelete(num);
			mav.setViewName("redirect:/board/centerList.mall?pageNum=" + pageNum);
			return mav;
		}
		if(!pass.equals(dbpass))
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/centerList.mall?pageNum=" + pageNum);
			mav.addObject("msg", "비밀번호를 잘못입력하셨습니다.");
			return mav;
		}
		baeService.boardDelete(num);
		mav.setViewName("redirect:/board/centerList.mall?pageNum=" + pageNum);
		return mav;
	}
	
	/*
	  답변 업데이트 폼
	*/
	@RequestMapping("board/centeranswerForm")	                     
	public ModelAndView centeranswerForm(int num, Integer pageNum) {
		ModelAndView mav = new ModelAndView();
		Board board = baeService.getBoard(num);
		mav.addObject("board", board);
		mav.addObject("pageNum", pageNum);	
		return mav;
	}
	
	/*
	  답변 기능 
	*/
	@RequestMapping("board/centeranswer")
	public ModelAndView centeranswer(Board board, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		baeService.boardAnswer(board, request);
		mav.addObject("board", board);
		mav.setViewName("redirect:/board/centerList.mall?pageNum=" + request.getParameter("pageNum"));
		return mav;
	}
	
	/*
	  고객센터 관리자 글 삭제 폼 
	*/
	@RequestMapping("board/centeraddeForm")
	public String centeraddeForm() {
		return "board/centeraddeForm";
	}
	
	/*
	  고객센터 관리자 글 삭제
	*/
	@RequestMapping("board/centeradde")
	public ModelAndView centeradde(int num, int pageNum) {
		ModelAndView mav = new ModelAndView();
		baeService.boardDelete(num);
		mav.setViewName("redirect:/board/centerList.mall?pageNum=" + pageNum);
		return mav;
	}	
	
	/*
	 상품 상세페이지 
	*/
	@RequestMapping("board/productDetail")
	public ModelAndView productDetail(Board board, Integer pageNum, String searchType, String searchContent, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member member = null;
		if(request.getSession().getAttribute("LOGIN_MEMBER") == null)
		{
			member = new Member();
		}
		if(request.getSession().getAttribute("LOGIN_MEMBER") != null)
		{
			member = (Member)request.getSession().getAttribute("LOGIN_MEMBER");
		}
		String userid = "";
		if(member.getId() == null)
		{
			userid = "guest";
		}
		if(member.getId() != null)
		{
			userid = member.getId();
		}
		String password = request.getParameter("password");
		String num = request.getParameter("num");
		String pro_no = request.getParameter("pro_no");
		String category = request.getParameter("category");
		Trade trade = new Trade();
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		int limit = 20;
		int listcount = baeService.qnaCount(searchType, searchContent, pro_no);
		int relistcount = baeService.reCount(pro_no);
		Product proinfo = baeService.proInfo(pro_no);
		List<Board> qnalist = baeService.qnaList(searchType, searchContent, pageNum, limit, pro_no);
		List<Board> reviewlist = baeService.reList(pageNum, limit, pro_no);
		Trade userinfo = baeService.checkUser(userid, pro_no);
		System.out.println(userinfo);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		int maxpage2 = (int)((double)relistcount/limit + 0.95);
		int startpage2 = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage2 = startpage2 + 9;
		if(endpage2 > maxpage2)
		{
			endpage2 = maxpage2;
		}
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("maxpage2", maxpage2);
		mav.addObject("startpage2", startpage2);
		mav.addObject("endpage2", endpage2);
		mav.addObject("listcount", listcount);
		mav.addObject("relistcount", relistcount);
		mav.addObject("qnalist", qnalist);
		mav.addObject("reviewlist", reviewlist);
		mav.addObject("pageNum", pageNum);
		mav.addObject("num", num);
		mav.addObject("password", password);
		mav.addObject("userid", userid);
		mav.addObject("pro_no", pro_no);
		mav.addObject("userinfo", userinfo);
		mav.addObject("proinfo", proinfo);
		mav.addObject("category", category);
		mav.addObject(trade);
		
		Board board1 =  baeService.qnapassthrough(num);
	    if(searchType != null && searchContent != null && board1 != null && !board1.getPass().equals(password))
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/productDetail.mall?pro_no=" + pro_no + "&pageNum=" + pageNum + "&searchType=" + searchType + "&searchContent=" + searchContent);
			mav.addObject("msg", "비밀번호를 잘못입력하셨습니다.");
			return mav;
		}
	    else if(pageNum!=null && searchType == null && searchContent == null && board1 != null && !board1.getPass().equals(password))
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/productDetail.mall?pro_no=" + pro_no + "&pageNum=" + pageNum);
			mav.addObject("msg", "비밀번호를 잘못입력하셨습니다.");
			return mav;
		}
	    else if(searchType == null && searchContent == null && board1 != null && !board1.getPass().equals(password))
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/productDetail.mall?pro_no=" + pro_no);
			mav.addObject("msg", "비밀번호를 잘못입력하셨습니다.");
			return mav;
		}
		return mav;	
	}
	
	/*
	  qna 글 추가 기능
	*/
	@RequestMapping("board/qnaAdd")
	public ModelAndView qnaAdd(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member)request.getSession().getAttribute("LOGIN_MEMBER");
		String pro_no = request.getParameter("pro_no");
		String userid = member.getId();
		mav.addObject(new Board());
		mav.addObject("userid", userid);
		mav.addObject("pro_no", pro_no);
		return mav;
	}
	
	/*
	 qna 글 작성 기능
	*/
	@RequestMapping("board/qnawrite")
	public ModelAndView qnawrite(@Valid Board board, BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("board/qnaAdd");
		if(bindingResult.hasErrors())
		{
			bindingResult.reject("error.input.user");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		baeService.qnaInsert(board, request);
		mav.setViewName("redirect:/board/productDetail.mall?pro_no=" + board.getPro_no());
		return mav;
	}
	
	/*
	 qna 업데이트폼
	*/
	@RequestMapping("board/qnaupdateForm")
	public ModelAndView qnaupdateForm(int num, Integer pageNum, int pro_no) {
		ModelAndView mav = new ModelAndView();
		Board board = baeService.getBoard(num);
		mav.addObject("board", board);
		mav.addObject("pageNum", pageNum);	
		mav.addObject("pro_no", pro_no);			
		return mav;
	}
	
	/*
	 qna 업데이트 기능 
	*/
	@RequestMapping("board/qnaupdate")
	public ModelAndView qnaupdate(@Valid Board board, BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("board : " + board);
		String pass = baeService.getBoardPassword(board.getBoard_no());
		System.out.println("pass:"+pass);
		if(!pass.equals(board.getPass()))
		{
			mav.setViewName("board/qnaupdateForm");
			if(!board.getPass().equals(""))
			{
				bindingResult.rejectValue("pass", "error.board.password");
			}
			return mav;
		}
		if(board.getImg1() == null)
		{
			board.setFileurl(request.getParameter("filep"));
		}
		else 
		{
			board.setFileurl(board.getImg1().getOriginalFilename());
		}
		if(board.getImg2() == null)
		{
			board.setFileurl2(request.getParameter("filep2"));
		}
		else 
		{
			board.setFileurl2(board.getImg2().getOriginalFilename());
		}
		if(board.getImg3() == null)
		{
			board.setFileurl3(request.getParameter("filep3"));
		}
		else 
		{
			board.setFileurl3(board.getImg3().getOriginalFilename());
		}
		baeService.qnaUpdate(board, request);
		mav.addObject("board", board);
		mav.setViewName("redirect:/board/productDetail.mall?pro_no="+ request.getParameter("pro_no") + "&pageNum=" + request.getParameter("pageNum"));
		return mav;
	}

	/*
	 qna 삭제 폼 
	*/
	@RequestMapping("board/qnadeleteForm")
	public String qnadeleteForm() {
		return "board/qnadeleteForm";
	}
	
	/*
	  qna 글 삭제 기능 
	*/
	@RequestMapping("board/qnadelete")
	public ModelAndView qnadelete(int num, int pageNum, int pro_no, String pass) {
		ModelAndView mav = new ModelAndView();
		String dbpass = baeService.getBoardPassword(num);
		if(pass == null && dbpass == null)
		{
			baeService.boardDelete(num);
			mav.setViewName("redirect:/board/productDetail.mall?pro_no=" + pro_no + "&pageNum=" + pageNum);
			return mav;
		}
		if(!pass.equals(dbpass))
		{
			mav.setViewName("alert");
			mav.addObject("url", "../board/productDetail.mall?pro_no=" + pro_no + "&pageNum=" + pageNum);
			mav.addObject("msg", "비밀번호를 잘못입력하셨습니다.");
			return mav;
		}
		baeService.boardDelete(num);
		mav.setViewName("redirect:/board/productDetail.mall?pro_no=" + pro_no + "&pageNum=" + pageNum);
		return mav;
	}
	
	/*
	 qna 답변 업데이트 폼
	*/
	@RequestMapping("board/qnaanswerForm")	                     
	public ModelAndView qnaanswerForm(int num, Integer pageNum, int pro_no) {
		ModelAndView mav = new ModelAndView();
		Board board = baeService.getBoard(num);
		mav.addObject("board", board);
		mav.addObject("num", num);	
		mav.addObject("pro_no", pro_no);	
		mav.addObject("pageNum", pageNum);	
		return mav;
	}
	
	/*
	 qna 답변 기능 
	*/
	@RequestMapping("board/qnaanswer")
	public ModelAndView qnaanswer(Board board, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		baeService.boardAnswer(board, request);
		mav.addObject("board", board);
		mav.setViewName("redirect:/board/productDetail.mall?pro_no=" + request.getParameter("pro_no") + "&pageNum=" + request.getParameter("pageNum"));
		return mav;
	}
	
	/*
	 qna 관리자 글 삭제 폼 
	*/
	@RequestMapping("board/qnaaddeForm")
	public String qnaaddeForm() {
		return "board/qnaaddeForm";
	}
	
	/*
	 qna 관리자 글 삭제
	*/
	@RequestMapping("board/qnaadde")
	public ModelAndView qnaadde(int num, int pageNum, int pro_no) {
		ModelAndView mav = new ModelAndView();
		baeService.boardDelete(num);
		mav.setViewName("redirect:/board/productDetail.mall?pro_no=" + pro_no + "&pageNum=" + pageNum);
		return mav;
	}
	
	/*
	  리뷰 글 추가 기능
	*/
	@RequestMapping("board/reviewAdd")
	public ModelAndView reviewAdd(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member)request.getSession().getAttribute("LOGIN_MEMBER");
		String pro_no = request.getParameter("pro_no");
		String userid = member.getId();
		mav.addObject(new Board());
		mav.addObject("userid", userid);
		mav.addObject("pro_no", pro_no);
		return mav;
	}
	
	/*
	 리뷰 글 작성 기능
	*/
	@RequestMapping("board/reviewwrite")
	public ModelAndView reviewwrite(@Valid Board board, BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("board/reviewAdd");
		if(bindingResult.hasErrors())
		{
			bindingResult.reject("error.input.user");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		baeService.reviewInsert(board, request);
		mav.setViewName("redirect:/board/productDetail.mall?pro_no=" + board.getPro_no());
		return mav;
	}
	
	/*
	 리뷰 업데이트폼
	*/
	@RequestMapping("board/reviewupdateForm")
	public ModelAndView reviewupdateForm(int num, Integer pageNum, int pro_no) {
		ModelAndView mav = new ModelAndView();
		Board board = baeService.getBoard(num);
		mav.addObject("board", board);
		mav.addObject("pageNum", pageNum);	
		mav.addObject("pro_no", pro_no);			
		return mav;
	}
	
	/*
	 리뷰 업데이트 기능 
	*/
	@RequestMapping("board/reviewupdate")
	public ModelAndView reviewupdate(@Valid Board board, BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("board : " + board);
		baeService.reviewUpdate(board, request);
		mav.addObject("board", board);
		mav.setViewName("redirect:/board/productDetail.mall?pro_no="+ request.getParameter("pro_no") + "&pageNum=" + request.getParameter("pageNum"));
		return mav;
	}
	
	/*
	 리뷰 삭제 폼 
	*/
	@RequestMapping("board/reviewdeleteForm")
	public String reviewdeleteForm() {
		return "board/reviewdeleteForm";
	}
	
	/*
	  리뷰글 삭제 기능 
	*/
	@RequestMapping("board/reviewdelete")
	public ModelAndView reviewdelete(int num, int pageNum, int pro_no) {
		ModelAndView mav = new ModelAndView();
		baeService.boardDelete(num);
		mav.setViewName("redirect:/board/productDetail.mall?pro_no=" + pro_no + "&pageNum=" + pageNum);
		return mav;
	}
	
	
	
	
		
}