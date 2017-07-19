package dao.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Board;

public interface BoardMapper {

	@Select("SELECT IFNULL(MAX(num),0) FROM board")
	int getMaxNum();

	@Insert("insert into board (num, id, pass, subject, content, regdate, board_type, readcnt, ref, reflevel, refstep, img1, img2, img3) values(#{num}, #{id}, #{pass}, #{subject}, #{content}, sysdate, #{board_type}, #{readcnt}, #{ref}, #{reflevel}, #{refstep}, #{img1}, #{img2}, #{img3})")
	void centerInsert(Board board);
	
	
	
}