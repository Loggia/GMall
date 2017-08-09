package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Coupon;

public interface CouponMapper
{
	@Insert("insert into coupon (cop_no, bis_no, discount) values(#{cop_no}, #{bis_no}, #{discount})")
	void insert(Map map);
	
	//고종환 사업자 쿠폰주기
	@Insert("insert into coupon_history (his_no, cop_no, bis_no, discount, id, chk) values(#{his_no}, #{cop_no}, #{bis_no}, #{discount}, #{id}, #{chk})")
	void insertCoupon(Map<String, Object> coupon_history);

	@Select("select * from coupon_history where id = #{id}")
	List<Coupon> selectcoupon(String id);


}
