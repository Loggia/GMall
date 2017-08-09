package dao;

import java.util.Map;

public interface CouponDao 
{
	void insert(String bis_no, String id); // 사업자 회원가입시 쿠폰 자동 생성
	
	void insertCoupon(Map<String, Object> coupon_history);//고종환 사업자 쿠폰주기
}
