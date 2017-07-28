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
import logic.coupon_history;

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
			
			return sqlSession.getMapper(TradeMapper.class).tradeList();
		}

		/*
		 * 주한울
		 * 일반 회원 구매 목록
		 */
		@Override
		public List<Trade> tradeBuyList(String id) 
		{
			try
			{
				return sqlSession.getMapper(TradeMapper.class).tradeBuyList(id);
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
		public List<coupon_history> memberCoupon(String id) 
		{
			return sqlSession.getMapper(TradeMapper.class).memberCoupon(id);
		}
		
		
		/*
		 * 고종환
		 * 사업자 쿠폰목록
		 */
		@Override
		public List<coupon_history> bisCoupon(String id) {
			return sqlSession.getMapper(TradeMapper.class).bisCoupon(id);
		}
		
		/*
		 * 주한울
		 * 일반회원 쿠폰목록 카테고리 선택시
		 */
		@Override
		public List<coupon_history> memberDiscountCheck(String id, String discount) 
		{
			Map<String,String> map=new HashMap<String,String>();
			map.put("id",id);
			map.put("discount", discount);

			return sqlSession.getMapper(TradeMapper.class).memberDiscountCheck(map);
		}

		//고종환 사업자 쿠폰목록 카테고리 선택시
		@Override
		public List<coupon_history> bisDiscountCheck(String id, String discount) {
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
}

