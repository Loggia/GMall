package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import logic.Trade;

public interface TradeMapper {
	
	/*
	 * 구정연
	 * 회원거래목록
	 */
	@Select("select a.trd_money , a.sell_id , a.buy_id , a.delivery , a.trd_date, b.pro_name from trade a , product b  where a.pro_no = b.pro_no")
	List<Trade> tradeList();

	/*
	 * 일반 회원 구매 목록
	 */
	@Select("select t.trd_code,p.pro_name,t.trd_money,p.bis_name,t.trd_date from trade t,product p where t.buy_id=#{id} and t.pro_no=p.pro_no and p.bis_no=(select bis_no from member m where m.id=t.sell_id);")
	List<Trade> tradeBuyList(String id);
}
