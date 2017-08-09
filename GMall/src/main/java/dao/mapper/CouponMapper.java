package dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;

public interface CouponMapper
{
	@Insert("insert into coupon (cop_no, bis_no, discount) values(#{cop_no}, #{bis_no}, #{discount})")
	void insert(Map map);
	
	//고종환 사업자 쿠폰주기
	@Insert("insert into coupon_history (his_no, cop_no, bis_no, discount, id, chk) values(#{his_no}, #{cop_no}, #{bis_no}, #{discount}, #{id}, #{chk})")
	void insertCoupon(Map<String, Object> coupon_history);


}
