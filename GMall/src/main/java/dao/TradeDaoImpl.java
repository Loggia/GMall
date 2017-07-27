package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.TradeMapper;
import logic.Trade;

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
		public List<Trade> deliveryList(String id) {
			return sqlSession.getMapper(TradeMapper.class).deliveryList(id);
		}
	}

