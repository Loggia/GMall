package logic;

import java.util.List;

public interface KuService 
{
	List<Trade> tradeList(); //구정연 - 회원거래목록
	List<Member> nomalList(); //구정연 - 일반회원관리
	List<Member> businessList();//구정연 - 사업자관리
	List<Member> primList(); //구정연 - 프리미엄 리스트출력
	void primupdate(); //구정연 - 프리미엄 업데이트
	Member getUserById(String id); //구정연 - 일반회원목록 아이디로 가져오기
	Product getproductByNo(Integer pro_no); //구정연 - 상품리스트 전부 가져오기
	Cart getCart(); // 구정연 장바구니 
}
