package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.TradeMapper;
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
			
			return sqlSession.getMapper(TradeMapper.class).tradeBuyList(id);
		}
		//고종환 사업자 거래목록
		@Override
		public List<Trade> tradeList(String id) {
			return sqlSession.getMapper(TradeMapper.class).tradeList2(id);
		}

		@Override
		public List<coupon_history> bus_coupon(String id) {
			return sqlSession.getMapper(TradeMapper.class).bus_coupon(id);
		}

		//고종환 사업자 쿠폰관리 선택시
		@Override
		public List<coupon_history> bus_couponCheck(String id, String discount) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("id",id);
			map.put("discount", discount);
			

			return sqlSession.getMapper(TradeMapper.class).bus_couponCheck(map);
		}
		
	}

