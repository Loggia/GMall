package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Trade;
import logic.Coupon_history;

public interface TradeMapper {
	
	/*
	 * 구정연
	 * 회원거래목록
	 */
	// @Select("select a.trd_money , a.sell_id , a.buy_id , a.delivery , a.trd_date, b.pro_name from trade a , product b  where a.pro_no = b.pro_no")
	// List<Trade> tradeList();

	/*
	 * 일반 회원 구매 목록
	 */
	@Select("select t.trd_code,p.pro_name,t.trd_money,p.bis_name,t.trd_date from trade t,product p where t.buy_id=#{id} and t.pro_no=p.pro_no and p.bis_no=(select bis_no from member m where m.id=t.sell_id);")
	List<Trade> tradeBuyList(String id);

	//고종환 사업자 거래목록
	@Select("select t.trd_code, p.pro_name, (t.trd_money - t.trd_fee) trd_money, m.nickname, t.trd_date from product p, trade t, member m where p.pro_no = t.pro_no  and m.id=t.buy_id and sell_id=#{id}")
	List<Trade> tradeList2(String id);

	// 주한울 일반회원 쿠폰목록
	@Select("select c.discount,m.bis_name,c.chk from coupon_history c,member m where c.id=#{id} and c.bis_no=m.bis_no")
	List<Coupon_history> memberCoupon(String id);
			
	//고종환 사업자 쿠폰목록
	@Select("select c.discount, (select nickname from member where c.id = id) nickname, c.chk  from member m, coupon_history c where m.id=#{id} and m.bis_no=c.bis_no")
	List<Coupon_history> bisCoupon(String id);

	// 주한울 일반회원 쿠폰목록 카테고리 선택시
	@Select("select c.discount,m.bis_name,c.chk from member m,coupon_history c where c.id=#{id} and m.bis_no=c.bis_no and discount=#{discount}")
	List<Coupon_history> memberDiscountCheck(Map<String, String> map);
		
	//고종환 사업자 쿠폰목록 카테고리 선택시
	@Select("select c.discount, (select nickname from member where c.id = id) nickname, c.chk from member m, coupon_history c where m.bis_no=c.bis_no and m.id=#{id} and discount=#{discount}")
	List<Coupon_history> bisDiscountCheck(Map<String, String> map);

	// 주한울 일반 회원 배송 조회 (사용하지 않음)
	@Select("select t.trd_code,p.pro_name,t.trd_money,p.bis_name,t.trd_date,t.delivery from trade t,product p where t.buy_id=#{id} and t.pro_no=p.pro_no order by trd_no")
	List<Trade> delvpageBuyList(String id);

	//고종환 사업자 배송조회 (사용하지 않음)
	@Select("select p.pro_name, m.nickname, t.trd_money, t.trd_code, t.trd_date, t.delivery, t.trd_no  from trade t, product p,member m  where t.pro_no=p.pro_no and m.id=t.buy_id and sell_id=#{id}")
	List<Trade> deliveryList(String id);
	
	//고종환 사업자 배송현황 변경위한 쿼리
	@Select("select delivery from trade where trd_no=#{trd_no}")
	String tradeCheck(String trd_no);
	
	//고종환 사업자 배송현황변경
	@Update("update trade set delivery=#{tradeCheck} where trd_no=#{trd_no}")
	void deliveryControl(Map<String, String> map);
	
	//고종환 쿠폰사용내역번호
	@Select("select max(his_no) from coupon_history")
	int his_no();
	
	//구정연 구매기능
		@Insert("insert into trade ( trd_no , trd_code , trd_cnt , trd_money , trd_fee , trd_date , pro_no"
				+ " ,buy_id , sell_id , cop_no , address , delivery , rv_chk) values ( #{trd_no}, #{trd_code} , "
				+ " #{trd_cnt} , #{trd_money} , #{trd_fee} , now() , #{pro_no} , #{buy_id} , #{sell_id} , null , #{address} , #{delivery} , #{rv_chk})")
		void createtrade(Trade trade);

	//구정연 거래넘버
	@Select("select max(trd_no)+1 from trade ")
	int getMaxtrd_no();
	//구정연 구매기능 판매자
	@Select("select id from member where bis_name = #{bis_name}")
	String sell_id(String bis_name);
	//구정연 구매기능에서 프리미엄 확인여부 
	@Select("select m.prim from product p , member m where p.bis_name = m.bis_name and pro_name = #{pro_name}")
	String prim(String pro_name);
	//구정연 프리미엄인 수수료
	@Select("select TRUNCATE(p.price*0.08,0) from product p, member m where p.bis_name = m.bis_name and pro_name = #{pro_name}")
	int yesprim(String pro_name);
	//구정연 프리미엄 아닌 수수료
	@Select("select TRUNCATE(p.price*0.1,0) from product p, member m where p.bis_name = m.bis_name and pro_name = #{pro_name}")
	int Noprim(String pro_name);
}
