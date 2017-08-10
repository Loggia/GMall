package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.HDService;
import logic.JooService;
import logic.KoService;
import logic.KuService;
import logic.Member;
import logic.Product;
import logic.Trade;

@Controller
public class MemberController {
	@Autowired
	public JooService jooService; // 주한울 서비스
	@Autowired
	public KoService koService; // 종환이꺼
	@Autowired
	public KuService kuService; // 정연이껑
	@Autowired
	public HDService hdService; // 사나가짱이다!

	/*
	 * 주한울 회원가입
	 */
	@RequestMapping("member/join")
	public ModelAndView join(Member member) // id=resd // 5자리 이상을 넣으면
	{
		ModelAndView mav = new ModelAndView("board/main");
		List<String> checkId = jooService.selectCheck_Id();
		mav.addObject("url", "../board/main.mall");
		
		for(String id : checkId)
		{
			if(id.equals(member.getId()))
			{
				mav.setViewName("error");
				mav.addObject("msg", "중복되는 아이디 번호입니다.");
			}
		}

		if (member.getType() == 1) 
		{
			member.setBis_no("");
			member.setBis_name("");
			
			mav.setViewName("success");
			mav.addObject("msg", "정상적으로 가입되었습니다.");

			jooService.insertMember(member);
		} 
		else if (member.getType() == 2) 
		{
			if (jooService.cheakMember(member.getBis_no())) 
			{
				List<String> bis_no = jooService.selectBis_no(); // 임의로 추가한 사업자
																 // 번호를 쿼리

				for (String no : bis_no) // 입력한 사업자 번호가 추가되어 있는 사업자 번호와 일치하는지 비교
				{
					if (no.equals(member.getBis_no())) 
					{
						mav.setViewName("error");
						mav.addObject("msg", "중복되거나 존재하지 않는 사업자 번호입니다.");
					}
				}
				
				mav.setViewName("success");
				mav.addObject("msg", "정상적으로 사업자 등록되었습니다.");
				
				jooService.insertMember(member);
				jooService.insertCoupon(member.getBis_no(), member.getId());
			} 
			else 
			{
				mav.setViewName("error");
				mav.addObject("msg", "회원가입이 실패하였습니다.");
			}
		}
		else 
		{
			mav.setViewName("error");
			mav.addObject("msg", "회원가입이 실패하였습니다.");
		}

		return mav;
	}

	/*
	 * 주한울 로그인 기능
	 */
	@RequestMapping("member/login")
	public ModelAndView login(Member member, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("board/main");
		
		try 
		{
			Member login = jooService.getUserByIdAndPw(member.getId(), member.getPass());

			if (login == null || !login.getId().equals(member.getId()) || !login.getPass().equals(member.getPass())) 
			{
				mav.setViewName("error");
				mav.addObject("url", "../board/main.mall");
				mav.addObject("msg", "아이디나 비밀번호를 잘못입력하셨습니다.");

				return mav;
			}

			request.getSession().setAttribute("LOGIN_MEMBER", login);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		// 팝업창이 생기면 로그인이 안됬을 때 팝업창이 뜨게 설정
		mav.setViewName("redirect:/board/main.mall");
		return mav;
	}

	/*
	 * 우동 로그아웃
	 */
	@RequestMapping("member/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("board/main");
		session.invalidate();
		System.out.println("로그아웃 성공");

		mav.setViewName("redirect:/board/main.mall");
		return mav;
	}

	/*
	 * 주한울
	 * 상세보기
	 */
	@RequestMapping("member/mypage")
	public ModelAndView mypage(HttpServletRequest request, Integer pageNum, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member)session.getAttribute("LOGIN_MEMBER");
		String category = request.getParameter("category");
		
		if(login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			
			return mav;
		}
		
		if(pageNum == null || pageNum.toString().equals(""))
		{
			pageNum = 1;
		}
		
		if(category == null || category.equals("0"))
		{
			category = null;
		}
		
		if(login.getType() == 1) 
		{
			List<Member> bookmark = jooService.selectBookmark(login.getId());
			List<Product> newsfeed = jooService.selectNewsFeed(login.getId());
			
			mav.addObject("bookmark", bookmark);
			mav.addObject("newsfeed", newsfeed);
		}
		else if(login.getType() == 2)
		{
			int limit = 10;
			int listcount = koService.productCount(login.getBis_no(), category);
			List<Product> myBis_list = koService.productList(login.getBis_no(), category, pageNum, limit);
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
			mav.addObject("myBis_list",myBis_list);
			mav.addObject("pageNum", pageNum);
			
			if(category == null) category = "0";
			mav.addObject("category", category);
		}
		
		mav.addObject("member", login);
		return mav;
	}

	/*
	 * 주한울 회원 정보 상세보기 계정 검증폼으로 이동
	 */
	@RequestMapping("member/passConfirmForm")
	public ModelAndView passConfirmForm(HttpSession session) {
		ModelAndView mav = new ModelAndView("member/passConfirm");

		return mav;
	}

	/*
	 * 주한울 회원 정보 상세보기 (입력 비밀번호와 로그인 비밀번호가 동일하면 infoForm으로 이동)
	 */
	@RequestMapping("member/passConfirm")
	public ModelAndView passConfirm(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("member/mypage");
		Member login = (Member) session.getAttribute("LOGIN_MEMBER");
		String pass = request.getParameter("pass");

		if (login.getPass().equals(pass)) {
			mav.setViewName("member/infoForm");
		} else {
			mav.setViewName("error");
			mav.addObject("url", "../member/passConfirmForm.mall");
			mav.addObject("msg", "잘못된 비밀번호입니다.");
		}

		mav.addObject("member", login);
		return mav;
	}

	/*
	 * 사나쨩 회원 인포폼
	 */
	@RequestMapping("member/infoForm")
	public ModelAndView infoForm(Member member, HttpSession session, String id) {
		ModelAndView mav = new ModelAndView();
		Member login = (Member) session.getAttribute("LOGIN_MEMBER");

		if (login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");

			return mav;
		}

		// 구정연 관리자에서 회원수정
		if (login.getId().equals("admin")) 
		{
			if(login.getId().equals(member.getId()))
			{
				mav.addObject("member", login);
			}
			else
			{
				Member user = kuService.getUserById(member.getId());
				mav.addObject("member", user);
			}
		}
		else
		{
			mav.addObject("member", login);
		}
		
		return mav;
	}

	/*
	 * 주한울 회원 수정 기능
	 */
	@RequestMapping("member/update")
	public ModelAndView update(Member member, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("member/mypage");
		Member login = (Member) session.getAttribute("LOGIN_MEMBER");
		String passfirm = request.getParameter("passfirm");

		if (login.getId().equals(member.getId())) 
		{
			if (member.getPass().equals(passfirm)) 
			{
				if (member.getPass().equals("")) 
				{
					member.setPass(login.getPass());
				}

				jooService.updateMember(member, request);
				session.invalidate(); // 회원이 수정되면 세션 만료
				request.getSession().setAttribute("LOGIN_MEMBER", member);

				/*
				 * 주한울 회원이 수정된 후 mypage에서 관심사업장, 사업장관리에 값이 뿌려지지 않는 문제가 있어 추가한 코드
				 */
				if (login.getType() == 1) 
				{
					List<Member> bookmark = jooService.selectBookmark(member.getId());
					List<Product> newsfeed = jooService.selectNewsFeed(member.getId());

					mav.addObject("bookmark", bookmark);
					mav.addObject("newsfeed", newsfeed);
				} 
				else if (login.getType() == 2) 
				{
					List<Product> myBis_list = koService.getProductList(login.getBis_no());// 내아이디만
					mav.addObject("myBis_list", myBis_list);
				}
			} 
			else 
			{
				mav.setViewName("error");
				mav.addObject("url", "../member/mypage.mall");
				mav.addObject("msg", "입력한 비밀번호가 일치하지 않습니다.");
			}
		}
		// 구정연 - 일반회원목록 수정
		else if (login.getId().equals("admin")) 
		{
			if (member.getPass().equals(passfirm)) 
			{
				jooService.updateMember(member, request);
				
				mav.setViewName("success");
				if(member.getType() == 1) mav.addObject("url", "../member/nomalList.mall");
				else mav.addObject("url", "../member/businessList.mall");
				mav.addObject("msg", "정상적으로 수정되었습니다.");
			}
		} 
		else 
		{
			mav.setViewName("error");
			mav.addObject("url", "../member/mypage.mall");
			mav.addObject("msg", "자신의 아이디만 수정 가능합니다.");
		}

		mav.addObject("member", login);
		return mav;
	}

	/*
	 * 주한울 회원 탈퇴
	 */
	@RequestMapping("member/delete")
	public ModelAndView delete(Member member, HttpSession session, String id) {
		ModelAndView mav = new ModelAndView("board/main");
		Member login = (Member) session.getAttribute("LOGIN_MEMBER");

		if (login == null) 
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "회원만 탈퇴 가능합니다.");

			return mav;
		}

		if (login.getId().equals(member.getId()) || login.getId().equals("admin")) 
		{
			if (login.getId().equals(member.getId())) 
			{
				if (login.getPass().equals(member.getPass())) 
				{
					jooService.deleteMember(member);
					String msgdelId = member.getId();
					hdService.deleteAllSendMsg(msgdelId);
					hdService.deleteAllReciveMsg(msgdelId);
					session.invalidate();
					
					mav.setViewName("success");
					mav.addObject("url", "../board/main.mall");
					mav.addObject("msg", "정상적으로 탈퇴되었습니다.");
				} 
				else 
				{
					mav.setViewName("error");
					mav.addObject("url", "../member/mypage.mall");
					mav.addObject("msg", "비밀번호를 확인하세요.");
				}

			}
			else // 관리자 회원 강제탈퇴
			{
				Member user = kuService.getUserById(member.getId());
				jooService.deleteMember(user);
				String PowermsgdelId = user.getId();
				hdService.deleteAllSendMsg(PowermsgdelId);
				hdService.deleteAllReciveMsg(PowermsgdelId);
				
				
				mav.setViewName("success");
				if(member.getType() == 1) mav.addObject("url", "../member/nomalList.mall");
				else mav.addObject("url", "../member/businessList.mall");
				mav.addObject("msg", user.getId() + " 회원을 강제 탈퇴시켰습니다.");
			}
		} 
		else 
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "본인의 계정만 탈퇴 가능합니다.");
		}

		return mav;
	}

	/*
	 * 구정연 일반회원관리
	 */

	@RequestMapping("member/nomalList")
	public ModelAndView nomalList(Integer pageNum, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member) session.getAttribute("LOGIN_MEMBER");
		
		if (login == null || !login.getId().equals("admin")) 
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "관리자만 사용 가능한 기능입니다.");

			return mav;
		}
		
		if (pageNum == null || pageNum.toString().equals("")) 
		{
			pageNum = 1;
		}
		
		int limit = 20;
		int listcount = kuService.nomalCount();
		List<Member> nomalList = kuService.nomalList(pageNum, limit);
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
		mav.addObject("nomalList", nomalList);
		mav.addObject("pageNum", pageNum);
		mav.addObject("member", login);
		
		return mav;

	}

	/*
	 * 구정연 사업자관리
	 */
	@RequestMapping("member/businessList")
	public ModelAndView businessList(Integer pageNum, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		Member login = (Member) session.getAttribute("LOGIN_MEMBER");
		
		if (login == null || !login.getId().equals("admin")) 
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "관리자만 사용 가능한 기능입니다.");

			return mav;
		}
		
		if (pageNum == null || pageNum.toString().equals("")) 
		{
			pageNum = 1;
		}
		
		int limit = 20;
		int listcount = kuService.businessCount();
		List<Member> businessList = kuService.businessList(pageNum, limit);
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
		mav.addObject("businessList", businessList);
		mav.addObject("pageNum", pageNum);
		mav.addObject("member", login);
		
		return mav;
	}

	/*
	 * 구정연 보유금액 & 수익금관리
	 */
	@RequestMapping("member/moneypage")
	public ModelAndView moneypage(Integer pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member login = (Member) session.getAttribute("LOGIN_MEMBER");

		if (login == null) {
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");

			return mav;
		}

		if (pageNum == null || pageNum.toString().equals("")) {
			pageNum = 1;
		}

		int limit = 10;
		int listcount = jooService.moneyChangeCount(login.getId(), login.getType());
		List<Trade> tradeList = kuService.moneyChangeList(login.getId(), login.getType(), pageNum, limit);
		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = (((int) ((double) pageNum / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = startpage + 9;

		if (endpage > maxpage) {
			endpage = maxpage;
		}

		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("tradeList", tradeList);
		mav.addObject("pageNum", pageNum);
		mav.addObject("member", login);

		return mav;
	}

	/*
	 * 구정연 프리미엄
	 */
	@RequestMapping("member/primlist")
	public ModelAndView prim() {
		ModelAndView mav = new ModelAndView();
		List<Member> primList = kuService.primList();
		mav.addObject("primList", primList);
		return mav;
	}

	/*
	 * 구정연 프리미엄 업데이트 구매 판매 리뷰시에 업데이트해주기
	 */
	@RequestMapping("member/primup")
	public ModelAndView primup() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping("member/primupdate")
	public ModelAndView primupdate() {
		ModelAndView mav = new ModelAndView();
		kuService.primupdate();
		List<Member> primList = kuService.primList();
		mav.addObject("primList", primList);
		return mav;
	}
	
	@RequestMapping("member/deleteBookmark")
	public ModelAndView deleteBookmark(HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("member/mypage");
		Member login = (Member) session.getAttribute("LOGIN_MEMBER");
		String mark_no = request.getParameter("mark_no");
		
		if (login == null) 
		{
			mav.setViewName("error");
			mav.addObject("url", "../board/main.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");

			return mav;
		}
		
		if(jooService.deleteBookmark(mark_no))
		{
			mav.setViewName("success");
			mav.addObject("url", "../member/mypage.mall");
			mav.addObject("msg", "사업자가 즐겨찾기가 해제되었습니다..");
		}
		else
		{
			mav.setViewName("error");
			mav.addObject("url", "../member/mypage.mall");
			mav.addObject("msg", "사업자 즐겨찾기 해제가 실패하였습니다.");
		}
		
		return mav;
	}
}