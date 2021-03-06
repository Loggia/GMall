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
		
				//구정연 거래넘버
				@Override
				public int getMaxtrd_no() {
					
					return sqlSession.getMapper(TradeMapper.class).getMaxtrd_no();
				}
				
				//구정연 구매기능
				@Override
				public void createtrade(Trade trade) {
					
					sqlSession.getMapper(TradeMapper.class).createtrade(trade);
				}

				//구정연 구매기능에서 프리미엄 확인여부 
				@Override
				public String prim(String pro_name) {
					
					return sqlSession.getMapper(TradeMapper.class).prim(pro_name);
					
				}
				//구정연 프리미엄인 수수료 
				@Override 
				public int yesprim(String pro_name) {
					
					return sqlSession.getMapper(TradeMapper.class).yesprim(pro_name);
				}
				//구정연 프리미엄아닌 수수료 
				@Override
				public int Noprim(String pro_name) {
					
					return sqlSession.getMapper(TradeMapper.class).Noprim(pro_name);
				}
				//구정연 구매기능 판매자
				@Override
				public String sell_id(String bis_name) {
					
					return sqlSession.getMapper(TradeMapper.class).sell_id(bis_name);
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
		    	
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	
		    	map.put("id", id);
		    	map.put("type", type);
		    	map.put("startrow", startrow);
		    	
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
		 * 일반회원 쿠폰목록 (사용 안함)
		 */
		@Override
		public List<Coupon_history> memberCoupon(String id) 
		{
			return sqlSession.getMapper(TradeMapper.class).memberCoupon(id);
		}
		
		// 쿠폰 목록 조회
		@Override
		public List<Coupon_history> couponList(String id, int type, String discount, Integer pageNum, int limit) 
		{
			try
			{
				int startrow = (pageNum - 1) * limit;
		    	
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	
		    	map.put("id", id);
		    	map.put("type", type);
		    	map.put("discount", discount);
		    	map.put("startrow", startrow);
		    	
		    	return sqlSession.selectList(NS+"couponList", map);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
				return null;
			}
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

		//고종환 사업자 배송조회 (사용하지 않음)
		@Override
		public List<Trade> deliveryList(String id) {
			return sqlSession.getMapper(TradeMapper.class).deliveryList(id);
		}
		
		@Override
		public List<Trade> delvpageList(String id, int type, Integer pageNum, int limit) 
		{
			try
			{
				int startrow = (pageNum - 1) * limit;	
		    	
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	
		    	map.put("id", id);
		    	map.put("type", type);
		    	map.put("startrow", startrow);
		    	
		    	return sqlSession.selectList(NS+"delvpageList", map);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
				return null;
			}
		}
		
		@Override
		public List<Trade> moneyChangeList(String id, Integer type, Integer pageNum, Integer limit)
		{
			try
			{
				int startrow = (pageNum - 1) * limit;
		    	
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	
		    	map.put("id", id);
		    	map.put("type", type);
		    	map.put("startrow", startrow);
		    	
		    	return sqlSession.selectList(NS+"moneyChangeList", map);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
				return null;
			}
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
		
		// 거래 목록 카운팅
		@Override
		public int tradeCount(String id, int type) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("id", id);
	    	map.put("type", type);
	    	
			return sqlSession.selectOne(NS+"tradeCount", map);
		}
 
		// 배송 목록 카운팅
		@Override
		public int delvpageCount(String id, int type) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("id", id);
	    	map.put("type", type);
	    	
			return sqlSession.selectOne(NS+"delvpageCount", map);
		}

		// 보유금액 카운팅
		@Override
		public int moneyChangeCount(String id, int type) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("id", id);
	    	map.put("type", type);
	    	
			return sqlSession.selectOne(NS+"moneyChangeCount", map);
		}

		@Override
		public int couponCount(String id, int type, String discount) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("id", id);
	    	map.put("type", type);
	    	map.put("discount", discount);
	    	
			return sqlSession.selectOne(NS+"couponCount", map);
		}
		
		//고종환 쿠폰내역번호
		@Override
		public int his_no() {
			return sqlSession.getMapper(TradeMapper.class).his_no();
		}
}

