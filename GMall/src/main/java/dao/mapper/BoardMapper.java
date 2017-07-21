package dao.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Board;

public interface BoardMapper {

	@Select("SELECT IFNULL(MAX(board_no),0) FROM board WHERE board_type = #{value}")
	int getMaxNum(int typenum);

	@Insert("insert into board (board_no, id, pass, subject, content, board_type, regdate, readcnt, ans_chk, "
			+ "img1, img2, img3) values(#{board_no}, #{id}, #{pass}, #{subject}, #{content}, #{board_type}, "
			+ "now(), #{readcnt}, #{ans_chk}, #{fileurl}, #{fileurl2}, #{fileurl3})")
	void centerInsert(Board board);
	
	
}