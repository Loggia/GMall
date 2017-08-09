package dao;

import java.util.List;
import java.util.Map;

import logic.Coupon;

public interface CouponDao 
{
	void insert(String bis_no, String id); // 사업자 회원가입시 쿠폰 자동 생성
	
	void insertCoupon(Map<String, Object> coupon_history);//고종환 사업자 쿠폰주기
	
	List<Coupon> selectcoupon(String id);//구정연 구매기능 쿠폰 
}
