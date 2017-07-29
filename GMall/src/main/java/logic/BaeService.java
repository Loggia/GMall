package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//배기수
public interface BaeService {
	List<Board> infiniteScrollDown(int numToStart); //배기수 - 무한스크롤 아래목록 가져옴
	List<Board> infiniteScrollUp(int numToEnd); //배기수 - 무한스크롤 위목록 가져옴
	List<Board> proList(); //배기수 - 상품리스트 가져옴
	int centerCount(String searchType, String searchContent); //배기수 - 고객센터 검색된 내용 가져옴
	List<Board> centerList(String searchType, String searchContent, Integer pageNum, int limit); //배기수 - 고객센터 목록 가져옴
	void centerInsert(Board board, HttpServletRequest request); //배기수 - 고객센터 내용 입력
	Board passthrough(String num); //배기수 - 글번호에 해당하는 정보를 가져옴
	Board getBoard(int num); //배기수 - 번호에 해당하는 게시글을 가져옴 
	String getBoardPassword(int board_no); //배기수 - 번호에 해당하는 패스워드를 가져옴
	void boardUpdate(Board board, HttpServletRequest request); //배기수 - 글 업데이트 기능
	
}