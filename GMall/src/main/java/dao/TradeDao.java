package dao;

import java.util.List;

import logic.Trade;
import logic.coupon_history;

public interface TradeDao {

	List<Trade> tradeList(); //구정연 - 회원거래목록

	List<Trade> tradeBuyList(String id); // 주한울 - 일반 회원 구매 목록
	List<Trade> delvpageBuyList(String id); // 주한울 - 일반 회원 배송 조회

	List<Trade> tradeList(String id);//고종환 사업자 거래목록

	List<coupon_history> bus_coupon(String id);//고종환 사업자 쿠폰관리

	List<coupon_history> bus_couponCheck(String id, String discount);//고종환 사업자 쿠폰관리 선택시

}
