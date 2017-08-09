package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

// 한울이꺼!
public interface JooService 
{
	void insertMember(Member member); // 주한울 - 회원가입
	void insertCoupon(String bis_no, String id); // 주한울 - 사업자 회원가입시 쿠폰 자동생성
	boolean cheakMember(String bis_no); // 주한울 - 회원가입시 중복된 사업자 번호를 사용했는지를 판별
	Member getUserByIdAndPw(String id, String pass); // 주한울 - 로그인을 위한 메서드
	void updateMember(Member member, HttpServletRequest request); // 주한울 - 회원 수정
	void deleteMember(Member member); // 주한울 - 회원 탈퇴
	List<String> selectCheck_Id(); // 주한울 - 아이디 중복 확인
	List<String> selectBis_no(); // 주한울 - 사업자 번호 확인
	List<Member> selectBookmark(String id); // 주한울 - 관심 사업자 조회
	List<Product> selectNewsFeed(String id); // 주한울 - 관심 사업자 최근 등록 목록 조회
	List<Trade> tradeList(String id, Integer type, Integer pageNum, Integer limit); // 주한울 - 거래목록 조회
	List<Coupon_history> memberCoupon(String id); // 주한울 일반회원 쿠폰목록 (사용 안함)
	List<Coupon_history> couponList(String id, int type, String discount, Integer pageNum, int limit); // 주한울 - 쿠폰 목록
	List<Coupon_history> memberDiscountCheck(String id, String discount); // 주한울 일반회원 쿠폰 관리 선택시
	Member getUserById(String id); // 주한울 - id로 멤버 조회
	int tradeCount(String id, int type); // 주한울 - 총 거래수 카운팅 메서드
	int delvpageCount(String id, int type); // 주한울 - 총 배송 카운팅 메서드
	int moneyChangeCount(String id, int type); // 주한울 - 총 보유금액(금액변동) 카운팅 메서드
	int couponCount(String id, int type, String discount); // 주한울 - 총 쿠폰 카운팅 메서드
	
	List<Trade> delvpageBuyList(String id); // 주한울 - 일반 회원 배송 조회 (사용하지 않음)
}