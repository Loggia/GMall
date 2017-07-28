package dao.mapper;

import java.util.List;
import java.util.Map;

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
	List<Trade> tradeList2(String id);

	// 주한울 일반회원 쿠폰목록
	@Select("select c.discount,m.bis_name,c.chk from coupon_history c,member m where c.id=#{id} and c.bis_no=m.bis_no")
	List<coupon_history> memberCoupon(String id);
			
	//고종환 사업자 쿠폰목록
	@Select("select c.discount, (select nickname from member where c.id = id) nickname, c.chk  from member m, coupon_history c where m.id=#{id} and m.bis_no=c.bis_no")
	List<coupon_history> bisCoupon(String id);

	// 주한울 일반회원 쿠폰목록 카테고리 선택시
	@Select("select c.discount,m.bis_name,c.chk from member m,coupon_history c where c.id=#{id} and m.bis_no=c.bis_no and discount=#{discount}")
	List<coupon_history> memberDiscountCheck(Map<String, String> map);
		
	//고종환 사업자 쿠폰목록 카테고리 선택시
	@Select("select c.discount, (select nickname from member where c.id = id) nickname, c.chk from member m, coupon_history c where m.bis_no=c.bis_no and m.id=#{id} and discount=#{discount}")
	List<coupon_history> bisDiscountCheck(Map<String, String> map);

	// 주한울 일반 회원 배송 조회
	@Select("select t.trd_code,p.pro_name,t.trd_money,p.bis_name,t.trd_date,t.delivery from trade t,product p where t.buy_id=#{id} and t.pro_no=p.pro_no order by trd_no")
	List<Trade> delvpageBuyList(String id);

	//고종환 사업자 배송조회
	@Select("select p.pro_name, t.buy_id, t.trd_money, t.trd_code, t.trd_date, t.delivery   from trade t, product p  where t.pro_no=p.pro_no and sell_id=#{id}")
	List<Trade> deliveryList(String id);
}
