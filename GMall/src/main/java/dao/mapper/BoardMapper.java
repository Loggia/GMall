package dao.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;

public interface BoardMapper {

	@Select("SELECT IFNULL(MAX(board_no),0) FROM board WHERE board_type = #{value}")
	int getMaxNum(int typenum);

	@Insert("insert into board (board_no, id, pass, subject, content, board_type, regdate, readcnt, ans_chk, "
			+ "img1, img2, img3) values(#{board_no}, #{id}, #{pass}, #{subject}, #{content}, #{board_type}, "
			+ "now(), #{readcnt}, #{ans_chk}, #{fileurl}, #{fileurl2}, #{fileurl3})")
	void centerInsert(Board board);
	
	@Select("select * from board where board_no = #{board_no}")
	Board passthrough(String num);

	@Select("select board_no, id, pass, subject, content, board_type, regdate, readcnt, ans_chk, img1 fileurl, "
			+ " img2 fileurl2, img3 fileurl3 from board where board_no = #{board_no}")
	Board getBoard(int num);

	@Select("select pass from board where board_no = #{board_no}")
	String getBoardPassword(int board_no);

	@Update("update board set subject=#{subject}, content=#{content}, img1=#{fileurl}, img2=#{fileurl2}, img3=#{fileurl3} where board_no=#{board_no}")
	void boardUpdate(Board board);
	
	
}