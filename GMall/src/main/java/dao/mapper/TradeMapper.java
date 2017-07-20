package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import logic.Trade;

public interface TradeMapper {
	
	/*
	 * 구정연
	 * 회원거래목록
	 */
	@Select("select * from trade")
	List<Trade> tradeList();

}
