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
	Member getUserByIdAndPw(String id, String pass); // 주한울 - 로그인을 위한 메서드
	void updateMember(Member member); // 주한울 - 회원 수정
	void deleteMember(Member member); // 주한울 - 회원 탈퇴
	List<String> selectBis_no(); // 주한울 - 사업자 번호 확인
	
	List<Trade> tradeList(); //구정연 - 회원거래목록
	List<Member> nomalList(); //구정연 - 일반회원관리
	List<Member> businessList();//구정연 - 사업자관리
	void ProductAdd(Product product, HttpServletRequest request);//고종환 사업자 물품등록
	int prono();//고종환 -물품번호
	List<Product> getProductList(String id);//고종환 내 사업장 관리
	List<Product> categoryCheck(String id, String category);//고종환 내사업장 카테고리분류
}