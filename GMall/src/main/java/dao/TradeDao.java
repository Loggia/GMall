package dao;

import java.util.List;

import logic.Trade;
import logic.coupon_history;

public interface TradeDao {

	List<Trade> tradeList(); //구정연 - 회원거래목록

	List<Trade> tradeBuyList(String id); // 주한울 - 일반 회원 구매 목록
	List<Trade> delvpageBuyList(String id); // 주한울 - 일반 회원 배송 조회

	List<Trade> tradeList(String id);//고종환 사업자 거래목록

	List<coupon_history> memberCoupon(String id); // 주한울 일반회원 쿠폰목록
	List<coupon_history> bisCoupon(String id);//고종환 사업자 쿠폰목록
	List<coupon_history> memberDiscountCheck(String id, String discount); // 주한울 일반회원 쿠폰목록 카테고리 선택시
	List<coupon_history> bisDiscountCheck(String id, String discount);//고종환 사업자 쿠폰목록 카테고리 선택시

	List<Trade> deliveryList(String id);//고종환 사업자 배송조회

}
