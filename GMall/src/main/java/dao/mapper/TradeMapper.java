package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import logic.Trade;
import logic.coupon_history;

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

	//고종환 사업자 거래목록
	@Select("select t.trd_code, p.pro_name, (t.trd_money - t.trd_fee) trd_money, t.buy_id, t.trd_date from product p, trade t where p.pro_no = t.pro_no and sell_id=#{id}")
	List<Trade> deliveryList(String id);

	//고종환 사업자 쿠폰관리
	@Select("select c.discount, c.id, c.chk  from member m, coupon_history c where m.bis_no=c.bis_no and m.id=#{id}")
	List<coupon_history> bus_coupon(String id);
}
