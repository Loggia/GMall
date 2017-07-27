package dao;

import java.util.List;

import logic.Trade;

public interface TradeDao {

	List<Trade> tradeList(); //구정연 - 회원거래목록

	List<Trade> tradeBuyList(String id); // 주한울 - 일반 회원 구매 목록

	List<Trade> deliveryList(String id);//고종환 사업자 거래목록

}
