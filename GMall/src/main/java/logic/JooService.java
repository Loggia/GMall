package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

// 한울이꺼!
public interface JooService 
{
	boolean insertMember(Member member); // 주한울 - 회원가입
	boolean cheakMember(String bis_no); // 주한울 - 회원가입시 중복된 사업자 번호를 사용했는지를 판별
	Member getUserByIdAndPw(String id, String pass); // 주한울 - 로그인을 위한 메서드
	void updateMember(Member member, HttpServletRequest request); // 주한울 - 회원 수정
	void deleteMember(Member member); // 주한울 - 회원 탈퇴
	List<String> selectBis_no(); // 주한울 - 사업자 번호 확인
	List<Member> selectBookmark(String id); // 주한울 - 관심 사업자 조회
	List<Product> selectNewsFeed(String id); // 주한울 - 관심 사업자 최근 등록 목록 조회
	List<Trade> tradeBuyList(String id); // 주한울 - 일반 회원 구매 목록 확인
	List<Trade> delvpageBuyList(String id); // 주한울 - 일반 회원 배송 조회
	List<Coupon_history> memberCoupon(String id); // 주한울 일반회원 쿠폰목록
	List<Coupon_history> memberDiscountCheck(String id, String discount); // 주한울 일반회원 쿠폰 관리 선택시
	List<Trade> moneyChangeList(Member member); // 주한울 일반회원, 사업자 보유금액(금액 변동) 
}