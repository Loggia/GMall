package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//배기수
public interface BaeService {
	List<Product> proList(String category, String group, String searchType, String searchContent, Integer pageNum, int limit); //배기수 - 상품리스트 가져옴
	int proCount(String searchType, String searchContent, String category); //배기수 - 해당 상품의 갯수를 가져옴
	List<Product> totalList(String searchType, String searchContent, Integer pageNum, int limit); //배기수 - 상품리스트 가져옴
	int totalCount(String searchType, String searchContent);//배기수 - 해당 상품의 갯수를 가져옴
	
	int centerCount(String searchType, String searchContent); //배기수 - 고객센터 검색된 내용 가져옴
	List<Board> centerList(String searchType, String searchContent, Integer pageNum, int limit); //배기수 - 고객센터 목록 가져옴
	void centerInsert(Board board, HttpServletRequest request); //배기수 - 고객센터 내용 입력
	Board passthrough(String num); //배기수 - 글번호에 해당하는 정보를 가져옴
	Board getBoard(int num); //배기수 - 번호에 해당하는 게시글을 가져옴 
	String getBoardPassword(int board_no); //배기수 - 번호에 해당하는 패스워드를 가져옴
	void boardUpdate(Board board, HttpServletRequest request); //배기수 - 글 업데이트 기능
	void boardDelete(int num);//배기수 - 글 삭제 기능
	void boardAnswer(Board board, HttpServletRequest request); //배기수 - 답변 기능
	
	int qnaCount(String searchType, String searchContent, String pro_no); //배기수 - qna에서 검색된 내용 가져옴
	List<Board> qnaList(String searchType, String searchContent, Integer pageNum, int limit, String pro_no); //배기수 - qna 목록 가져옴
	Board qnapassthrough(String num); //배기수 - 글번호에 해당하는 정보를 가져옴
	void qnaInsert(Board board, HttpServletRequest request); //배기수 - qna 글 작성 기능
	void qnaUpdate(Board board, HttpServletRequest request); //배기수 - qna 글 수정 기능
	
	int reCount(String pro_no); //배기수 - 해당번호의 리뷰 갯수를 가져옴
	List<Board> reList(Integer pageNum, int limit, String pro_no); //배기수 - 리뷰 목록을 가져옴
	void reviewInsert(Board board, String userid, String pro_no, HttpServletRequest request); //배기수 - 리뷰글 작성 기능
	Trade checkUser(String userid, String pro_no); //배기수 - 해당 상품 구매자인 경우만 리뷰가 작성 가능하게 하기 위해 상품 구매자인지를 확인
	void reviewUpdate(Board board, HttpServletRequest request); //배기수 - 리뷰글 수정 기능
	Product proInfo(String pro_no); //배기수 - 해당 상품번호의 상품정보를 가져옴
	List<Trade> sellInfo(String pro_no); //배기수 - 해당 상품의 판매자
	Member sellScore(String sellid); //배기수 - 판매자의 점수를 가져옴
	void memGrade(String sellid, int grade, int memberScore); //배기수 - 판매자에게 점수를 줌 
	List<Trade> protrInfo(String pro_no); //배기수 - 상품의 거래번호를 가져옴
	Member sessionType(String userid); //배기수 - 현재 로그인된 회원의 회원타입을 가져옴
	Product proBis(String bisname, String pro_no); //배기수 - 현재 로그인된 회원의 bis_name와 현재 상품의 상품번호를 비교하여 상품 등록자의 사업번호를 가져옴
	
	
	
	
	
	
}