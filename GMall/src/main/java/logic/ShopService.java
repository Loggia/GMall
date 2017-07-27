package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ShopService {
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
	
	boolean insertMember(Member member); // 주한울 - 회원가입
	boolean cheakMember(String bis_no); // 주한울 - 회원가입시 중복된 사업자 번호를 사용했는지를 판별
	Member getUserByIdAndPw(String id, String pass); // 주한울 - 로그인을 위한 메서드
	void updateMember(Member member); // 주한울 - 회원 수정
	void deleteMember(Member member); // 주한울 - 회원 탈퇴
	List<String> selectBis_no(); // 주한울 - 사업자 번호 확인
	List<Member> selectBookmark(String id); // 주한울 - 관심 사업자 조회
	List<Product> selectNewsFeed(String id); // 주한울 - 관심 사업자 최근 등록 목록 조회
	List<Trade> tradeBuyList(String id); // 주한울 - 일반 회원 구매 목록 확인
	
	List<Trade> tradeList(); //구정연 - 회원거래목록
	List<Member> nomalList(); //구정연 - 일반회원관리
	List<Member> businessList();//구정연 - 사업자관리
	void ProductAdd(Product product, HttpServletRequest request);//고종환 사업자 물품등록
	int prono();//고종환 -물품번호
	List<Product> getProductList(String Bis_no);//고종환 내 사업장 관리
	List<Product> categoryCheck(String bis_name, String category);//고종환 내사업장 카테고리분류
	List<Trade> tradeList(String id);//고종환 사업자 거래목록
	List<coupon_history> bus_coupon(String id);//고종환 사업자 쿠폰관리
	
}