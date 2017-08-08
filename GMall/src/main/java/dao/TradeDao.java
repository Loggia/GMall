package dao;

import java.util.List;

import logic.Member;
import logic.Trade;
import logic.Coupon_history;

public interface TradeDao {

	List<Trade> tradeList(); //구정연 - 회원거래목록
	List<Trade> moneyChangeList(String id, Integer type, Integer pageNum, Integer limit); // 정연이 - 보유금액(금액 변동) 

	List<Coupon_history> memberCoupon(String id); // 주한울 일반회원 쿠폰목록 (사용 안함)
	List<Coupon_history> couponList(String id, int type, String discount, Integer pageNum, int limit); // 주한울 - 쿠폰 목록 조회
	List<Trade> tradeList(String id, Integer type, Integer pageNum, Integer limit); // 주한울 - 거래 목록
	List<Trade> delvpageBuyList(String id); // 주한울 - 일반 회원 배송 조회 (사용하지 않음)
	int tradeCount(String id, int type); // 주한울 - 총 거래수 카운팅 메서드
	int delvpageCount(String id, int type); // 주한울 - 총 배송조회 카운팅 메서드
	int moneyChangeCount(String id, int type); // 주한울 - 총 보유금액(금액변동) 카운팅 메서드
	int couponCount(String id, int type); // 주한울 - 총 쿠폰 카운팅 메서드

	List<Trade> tradeList(String id);//고종환 사업자 거래목록
	List<Coupon_history> bisCoupon(String id);//고종환 사업자 쿠폰목록
	List<Coupon_history> memberDiscountCheck(String id, String discount); // 주한울 일반회원 쿠폰목록 카테고리 선택시
	List<Coupon_history> bisDiscountCheck(String id, String discount);//고종환 사업자 쿠폰목록 카테고리 선택시
	List<Trade> deliveryList(String id);//고종환 사업자 배송조회 (사용하지 않음)
	List<Trade> delvpageList(String id, int type, Integer pageNum, int limit); // 고종환 배송 조회
	String tradeCheck(String trd_no);//고종환 배송현황 변경위한 쿼리
	void deliveryControl(String trd_no, String tradeCheck); //고종환 사업자 배송현황 변경
}
