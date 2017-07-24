package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import logic.Trade;

public interface TradeMapper {
	
	/*
	 * 구정연
	 * 회원거래목록
	 */
	@Select("select a.trd_money , a.sell_id , a.buy_id , a.delivery , b.pro_name from trade a , product b  where a.pro_no = b.pro_no")
	List<Trade> tradeList();

}
