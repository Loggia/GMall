package dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;

public interface CouponMapper
{
	@Insert("insert into coupon (cop_no, bis_no, discount) values(#{cop_no}, #{bis_no}, #{discount})")
	void insert(Map map);

}
