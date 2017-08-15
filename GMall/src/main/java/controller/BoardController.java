package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSliderUI;
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
import logic.JooService;
import logic.KuService;
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
	@Autowired
	public KuService kuService;
	@Autowired
	public JooService jooService; // 주한울 서비스
	
	@RequestMapping("board/main")
	public ModelAndView main(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if((Member)session.getAttribute("LOGIN_MEMBER") == null) {
			List<Product> interList = hdService.interList("");
			mav.addObject("interList",interList);
			
		} else if((Member)session.getAttribute("LOGIN_MEMBER") != null) {
			Member login = (Member)session.getAttribute("LOGIN_MEMBER");
			String inter = login.getInterest();
			List<Product> interList = hdService.interList(inter);
			mav.addObject("interList",interList);
		}
		
		List<Product> primList1 = hdService.primList1();
		List<Product> primList2 = hdService.primList2();
		List<Product> primList3 = hdService.primList3();
		List<Product> primList4 = hdService.primList4();
		List<Product> newList = hdService.newList();
		List<Product> popuList = hdService.popuList();
		mav.addObject("primList1", primList1);
		System.out.println(primList1);
		mav.addObject("primList1", primList2);
		mav.addObject("primList1", primList3);
		mav.addObject("primList1", primList4);
		mav.addObject("newList", newList);
		mav.addObject("popuList", popuList);
		return mav;
		
	}
	
	/*
	 상품 리스트 불러오는 기능 
	*/
	@RequestMapping("board/proList")
	public ModelAndView proList(Integer pageNum, String searchType, String searchContent, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String category = request.getParameter("category");
		String group = request.getParameter("group");
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		int limit = 20;
		int listcount = baeService.proCount(searchType, searchContent, category);
		List<Product> productlist = baeService.proList(category, group, searchType, searchContent, pageNum, limit);
		
		for(int i=0; i<productlist.size() ; i++)
		{
			int averprice = 0;
			int totalprice = 0;
			String favor = productlist.get(i).getFavorite();
			List<Product> favorprice = baeService.favorPrice(favor);
			for(int j=0; j<favorprice.size() ; j++)
			{
				totalprice += favorprice.get(j).getPrice();
				averprice = totalprice / favorprice.size();
				productlist.get(i).setAverfavorprice(averprice);
			}
		} 		
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		mav.addObject("productlist", productlist);
		mav.addObject("listcount", listcount);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("pageNum", pageNum);
		return mav;
	}
	
	@RequestMapping("board/totalList")
	public ModelAndView totalList(Integer pageNum, String searchType, String searchContent, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		int limit = 20;
		int listcount = baeService.totalCount(searchType, searchContent);
		List<Product> totallist = baeService.totalList(searchType, searchContent, pageNum, limit);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)((double)pageNum/10 + 0.9)) -1) * 10 + 1;
		int endpage = startpage + 9;
		if(endpage > maxpage)
		{
			endpage = maxpage;
		}
		for(int i=0; i<totallist.size() ; i++)
		{
			int averprice = 0;
			int totalprice = 0;
			String favor = totallist.get(i).getFavorite();
			List<Product> favorprice = baeService.favorPrice(favor);
			for(int j=0; j<favorprice.size() ; j++)
			{
				totalprice += favorprice.get(j).getPrice();
				averprice = totalprice / favorprice.size();
				totallist.get(i).setAverfavorprice(averprice);
			}
		}
		mav.addObject("totallist", totallist);
		mav.addObject("listcount", listcount);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("pageNum", pageNum);
		return mav;
	}
	
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
		mav.setViewName("redirect:/board/centerList.mall");
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
		List<Trade> userinfolist = baeService.checkUser(userid, pro_no);
		Trade userinfo = new Trade();
		if(userinfolist.size() == 0)
		{  
			userinfolist = new ArrayList<Trade>();
			userinfolist.add(new Trade());
			userinfo = userinfolist.get(0);
		}
		if(userinfolist.size() != 0)
		{
		    userinfo = userinfolist.get(0);
		}
		List<Trade> protrinfo = baeService.protrInfo(pro_no);
		Member sessiontype = baeService.sessionType(userid);
		if(sessiontype == null)
		{
			sessiontype = new Member();
		}
		int usertype = sessiontype.getType();
		String bisname = sessiontype.getBis_name();
		Product probis = baeService.proBis(bisname, pro_no);
		if(userinfo == null)
		{
			userinfo = new Trade();
		}
		int codeequal = 0;
		for(Trade protrdcode : protrinfo)
		{
			if(protrdcode.getTrd_code().equals(userinfo.getTrd_code()))
			{
				codeequal = 1;
			}
		}
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
		mav.addObject("codeequal", codeequal);
		mav.addObject("usertype", usertype);
		mav.addObject("probis", probis);
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
		String pass = baeService.getBoardPassword(board.getBoard_no());
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
		List<Trade> sellinfolist = baeService.sellInfo(pro_no);
		Trade sellinfo =  sellinfolist.get(0);
		mav.addObject(new Board());
		mav.addObject("userid", userid);
		mav.addObject("pro_no", pro_no);
		mav.addObject("sellinfo", sellinfo);
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
		String userid = request.getParameter("id");
		String pro_no = request.getParameter("pro_no");
		String sellid = request.getParameter("sellid");
		int grade = board.getGrade();
		Member member = baeService.sellScore(sellid);
		int memberScore = (int)member.getScore();
		baeService.memGrade(sellid, grade, memberScore);
		baeService.reviewInsert(board, userid, pro_no, request);
		kuService.primupdate();
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
	
	// 즐겨찾기 추가
	@RequestMapping("board/addBookmark")
	public ModelAndView addBookmark(HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("");
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		String pro_no = request.getParameter("pro_no");
		
		if(login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
		}
		
		if(jooService.bookmarkCount(login.getId()) >= 3)
		{
			mav.setViewName("error");
			mav.addObject("url", "../member/mypage.mall");
			mav.addObject("msg", "즐겨찾기는 최대 3개까지 가능합니다.");
		}
		else
		{
			if(jooService.addBookmark(login.getId(), jooService.getBis_no(pro_no)))
			{
				mav.setViewName("success");
				mav.addObject("url", "../member/mypage.mall");
				mav.addObject("msg", "사업자가 즐겨찾기 되었습니다.");
			}
			else
			{
				mav.setViewName("error");
				mav.addObject("url", "../member/mypage.mall");
				mav.addObject("msg", "사업자 등록에 실패하였습니다.");
			}
		}
		
		mav.addObject("member", login);
		return mav;
	}
}