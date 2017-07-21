package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ShopService {
	List<Board> infiniteScrollDown(int numToStart); //배기수 - 무한스크롤 아래목록 가져옴
	List<Board> infiniteScrollUp(int numToEnd); //배기수 - 무한스크롤 위목록 가져옴
	List<Board> proList(); //배기수 - 상품리스트 가져옴
	int centerCount(); //배기수 - 고객센터 검색된 내용 가져옴
	List<Board> centerList(Integer pageNum, int limit); //배기수 - 고객센터 목록 가져옴
	void centerInsert(Board board, HttpServletRequest request); //배기수 - 고객센터 내용 입력
	
	boolean insertMember(Member member); // 주한울 - 회원가입
	Member selectMember(String id); // 주한울 - 로그인을 위한 메서드
	List<Trade> tradeList(); //구정연 - 회원거래목록
	List<Member> nomalList(); //구정연 - 일반회원관리
}