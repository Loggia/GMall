package dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Trade;

public interface BookmarkMapper 
{
	// 즐겨찾기 수 카운팅
	@Select("select count(*) from bookmark where id = #{id}")
	int bookmarkCount(String id);
	
	@Select("select count(*) from bookmark")
	int maxCount();

	
	@Insert("insert into trade ( trd_no , trd_code , trd_cnt , trd_money , trd_fee , trd_date , pro_no"
			+ " ,buy_id , sell_id , cop_no , address , delivery , rv_chk) values ( #{trd_no}, #{trd_code} , "
			+ " #{trd_cnt} , #{trd_money} , #{trd_fee} , now() , #{pro_no} , #{buy_id} , #{sell_id} , null , #{address} , #{delivery} , #{rv_chk})")
	void createtrade(Trade trade);
	
	@Insert("insert into bookmark (mark_no, id, bis_no) values(#{maxCount}, #{id}, #{bis_no}")
	void addBookmark(Map<Object, Object> map);
}
