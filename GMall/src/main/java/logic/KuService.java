package logic;

import java.util.List;

public interface KuService 
{
	List<Trade> tradeList(); //구정연 - 회원거래목록
	int nomalCount(); // 구정연 - 일반회원 카운팅
	List<Member> nomalList(Integer pageNum, Integer limit); //구정연 - 일반회원관리
	int businessCount(); // 구정연 - 사업자 카운팅
	List<Member> businessList(Integer pageNum, Integer limit);//구정연 - 사업자관리
	List<Member> primList(); //구정연 - 프리미엄 리스트출력
	void primupdate(); //구정연 - 프리미엄 업데이트
	Member getUserById(String id); //구정연 - 일반회원목록 아이디로 가져오기
	Product getproductByNo(Integer pro_no); //구정연 - 상품리스트 전부 가져오기
	List<Trade> moneyChangeList(String id, Integer type, Integer pageNum, Integer limit); // 정연이 - 보유금액(금액 변동) 
	Cart getCart(); // 구정연 장바구니 
	Integer totalAmount(List<ProductSet> productList); //구정연 구매확인(총가격)
	Trade checkEnd(String id, String trd_address, Cart cart); //구정연 구매기능
	List<Coupon> selectcoupon(String id);//구정연 구매기능 쿠폰 
}
