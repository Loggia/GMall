package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.CouponMapper;
import logic.Coupon;
import logic.Coupon_history;

@Repository
public class CouponDaoImpl implements CouponDao
{
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession; 
	private final String NS = "dao.mapper.CouponMapper."; 
	
	/*
	 * 주한울
	 * 사업자 회원가입시 쿠폰 자동 생성
	 */
	@Override
	public void insert(String bis_no, String id) 
	{
		for(int i=5; i<=15; i+=5)
		{
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("cop_no", i+"%"+id);
			map.put("bis_no", bis_no);
			map.put("discount", i);
			
			sqlSession.getMapper(CouponMapper.class).insert(map);
		}
	}
	
	//고종환 사업자 쿠폰주기
	@Override
	public void insertCoupon(Map<String, Object> coupon_history) 
	{
		sqlSession.getMapper(CouponMapper.class).insertCoupon(coupon_history);
	}
	
	//구정연 구매기능 쿠폰
	@Override
	public List<Coupon_history> selectCoupon(String id) 
	{
		return sqlSession.getMapper(CouponMapper.class).selectCoupon(id);
	}

	// 쿠폰 사용시 삭제
	@Override
	public void deleteCoupon(String his_no) 
	{
		sqlSession.getMapper(CouponMapper.class).deleteCoupon(his_no);
	}
}
