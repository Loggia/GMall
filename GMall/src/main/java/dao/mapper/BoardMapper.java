package dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;
import logic.Product;

public interface BoardMapper {

	@Select("SELECT IFNULL(MAX(board_no),0) FROM board")
	int getMaxNum();

	@Insert("insert into board (board_no, id, pass, subject, content, board_type, regdate, readcnt, ans_chk, "
			+ "img1, img2, img3) values(#{board_no}, #{id}, #{pass}, #{subject}, #{content}, #{board_type}, "
			+ "now(), #{readcnt}, #{ans_chk}, #{fileurl}, #{fileurl2}, #{fileurl3})")
	void centerInsert(Board board);
	
	@Select("select * from board where board_no = #{board_no} and board_type = 1")
	Board passthrough(String num);

	@Select("select board_no, id, pass, subject, content, board_type, regdate, readcnt, ans_chk, pro_no, img1 fileurl, "
			+ " img2 fileurl2, img3 fileurl3 from board where board_no = #{board_no}")
	Board getBoard(int num);

	@Select("select pass from board where board_no = #{board_no}")
	String getBoardPassword(int board_no);

	@Update("update board set subject=#{subject}, content=#{content}, img1=#{fileurl}, img2=#{fileurl2}, img3=#{fileurl3} where board_no=#{board_no} and board_type = 1")
	void boardUpdate(Board board);

	@Delete("delete from board where board_no = #{board_no}")
	void boardDelete(int num);

	@Update("update board set subject=#{subject}, content=#{content}, ans_chk=#{ans_chk} where board_no=#{board_no}")
	void boardAnswer(Board board);
	
	@Select("select * from board where board_no = #{board_no} and board_type = 2")
	Board qnapassthrough(String num);

	@Insert("insert into board (board_no, id, pass, subject, content, board_type, regdate, readcnt, ans_chk, "
			+ "pro_no, img1, img2, img3) values(#{board_no}, #{id}, #{pass}, #{subject}, #{content}, #{board_type}, "
			+ "now(), #{readcnt}, #{ans_chk}, #{pro_no}, #{fileurl}, #{fileurl2}, #{fileurl3})")
	void qnaInsert(Board board);
	
	@Update("update board set subject=#{subject}, content=#{content}, img1=#{fileurl}, img2=#{fileurl2}, img3=#{fileurl3} where board_no=#{board_no} and board_type = 2")
	void qnaUpdate(Board board);

	@Insert("insert into board (board_no, id, pass, subject, content, board_type, regdate, readcnt, "
			+ "pro_no) values(#{board_no}, #{id}, #{pass}, #{subject}, #{content}, #{board_type}, "
			+ "now(), #{readcnt}, #{pro_no})")
	void reviewInsert(Board board);

	@Update("update board set subject=#{subject}, content=#{content} where board_no=#{board_no} and board_type = 3")
	void reviewUpdate(Board board);

	@Select("select pro_no, bis_no, bis_name, date, pro_name, price, cnt, category, favorite, pro_content, main_img fileurl, "
			+ " sub_img1 fileurl1, sub_img2 fileurl2, sub_img3 fileurl3 from product where pro_no = #{pro_no}")
	Product proInfo(String pro_no);
	
	@Select("select main_img fileurl from product where category=#{inter } ORDER by date LIMIT 4;")
	List<Product> interList(String inter);
	
	
	
	
}