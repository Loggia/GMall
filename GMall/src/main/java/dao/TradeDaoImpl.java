package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.TradeMapper;
import logic.Member;
import logic.Trade;
import logic.Coupon_history;

@Repository
public class TradeDaoImpl implements TradeDao{

		@Autowired
		private SqlSessionTemplate sqlSession; 
		private final String NS = "dao.mapper.TradeMapper."; 
		
		/*
		 * 구정연
		 * 회원거래목록
		 */
		@Override
		public List<Trade> tradeList() {
			
			// return sqlSession.getMapper(TradeMapper.class).tradeList();
			return null;
		}

		/*
		 * 주한울
		 * 일반 회원 구매 목록
		 */
		@Override
		public List<Trade> tradeList(String id, Integer type, Integer pageNum, Integer limit) 
		{
			try
			{
				int startrow = (pageNum - 1) * limit;
		    	int endrow = startrow + limit;  	
		    	
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	
		    	map.put("id", id);
		    	map.put("type", type);
		    	map.put("startrow", startrow);
		    	map.put("endrow", endrow);
		    	
		    	return sqlSession.selectList(NS+"tradeList", map);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
				return null;
			}
		}
		
		/*
		 * 주한울
		 * 일반 회원 배송 조회
		 */
		@Override
		public List<Trade> delvpageBuyList(String id) 
		{
			try
			{
				return sqlSession.getMapper(TradeMapper.class).delvpageBuyList(id);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
				return null;
			}
		}
		
		//고종환 사업자 거래목록
		@Override
		public List<Trade> tradeList(String id) {
			return sqlSession.getMapper(TradeMapper.class).tradeList2(id);
		}

		/*
		 * 주한울
		 * 일반회원 쿠폰목록
		 */
		@Override
		public List<Coupon_history> memberCoupon(String id) 
		{
			return sqlSession.getMapper(TradeMapper.class).memberCoupon(id);
		}
		
		
		/*
		 * 고종환
		 * 사업자 쿠폰목록
		 */
		@Override
		public List<Coupon_history> bisCoupon(String id) {
			return sqlSession.getMapper(TradeMapper.class).bisCoupon(id);
		}
		
		/*
		 * 주한울
		 * 일반회원 쿠폰목록 카테고리 선택시
		 */
		@Override
		public List<Coupon_history> memberDiscountCheck(String id, String discount) 
		{
			Map<String,String> map=new HashMap<String,String>();
			map.put("id",id);
			map.put("discount", discount);

			return sqlSession.getMapper(TradeMapper.class).memberDiscountCheck(map);
		}

		//고종환 사업자 쿠폰목록 카테고리 선택시
		@Override
		public List<Coupon_history> bisDiscountCheck(String id, String discount) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("id",id);
			map.put("discount", discount);

			return sqlSession.getMapper(TradeMapper.class).bisDiscountCheck(map);
		}

		//고종환 사업자 배송조회
		@Override
		public List<Trade> deliveryList(String id) {
			return sqlSession.getMapper(TradeMapper.class).deliveryList(id);
		}
		
		@Override
		public List<Trade> moneyChangeList(Member member) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", member.getId());
			map.put("type", member.getType());
			
			return sqlSession.selectList("dao.mapper.TradeMapper.moneyChangeList", map);
		}
		//고종환 사업자 배송현황 변경위한 쿼리
		@Override
		public String tradeCheck(String trd_no) {
			return sqlSession.getMapper(TradeMapper.class).tradeCheck(trd_no);
		}

		//고종환 사업자 배송현황 변경
		@Override
		public void deliveryControl(String trd_no, String tradeCheck) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("trd_no",trd_no);
			map.put("tradeCheck", tradeCheck);
			
			sqlSession.getMapper(TradeMapper.class).deliveryControl(map);
			
		}
		
		@Override
		public int tradeCount(String id, int type) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("id", id);
	    	map.put("type", type);
	    	
			return sqlSession.selectOne(NS+"tradeCount", map);
		}
}

