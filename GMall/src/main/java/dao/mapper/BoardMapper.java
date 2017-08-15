package dao.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;
import logic.Member;
import logic.Product;
import logic.Trade;

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
			+ "pro_no, grade) values(#{board_no}, #{id}, #{pass}, #{subject}, #{content}, #{board_type}, "
			+ "now(), #{readcnt}, #{pro_no}, #{grade})")
	void reviewInsert(Board board); 

	@Update("update board set subject=#{subject}, content=#{content} where board_no=#{board_no} and board_type = 3")
	void reviewUpdate(Board board);

	@Select("select pro_no, bis_no, bis_name, date, pro_name, price, cnt, category, favorite, pro_content, main_img fileurl, "
			+ " sub_img1 fileurl1, sub_img2 fileurl2, sub_img3 fileurl3 from product where pro_no = #{pro_no}")
	Product proInfo(String pro_no);
	
	@Update("update trade set rv_chk=2 where buy_id='${userid}' and pro_no=${pro_no}")
	void rvchkUpdate(Map<String, Object> paramMap);
	
	@Select("select * from trade where pro_no=#{pro_no}")
	List<Trade> sellInfo(String pro_no);
	
	@Select("select score from member where id='${value}'")
	Member sellScore(String sellid);
	
	@Update("update member set score=${realGrade} where id='${sellid}'")
	void memGrade(Map<String, Object> paramMap);
	
	@Select("select trd_code from trade where pro_no='${value}'")
	List<Trade> protrInfo(String pro_no);
	
	@Select("select type, bis_name from member where id='${value}'")
	Member sessionType(String userid);
	
	@Select("select count(p.pro_no) cnt, p.pro_no, p.main_img fileurl from trade t, product p where p.pro_no=t.pro_no group by t.pro_no order by cnt desc, date desc LIMIT 4;")
	List<Product> popuList();
	   
	@Select("select main_img fileurl from product ORDER by date desc LIMIT 4;")
	List<Product> newList();
	   
	/*@Select("select *, p.main_img fileurl from member m, product p where m.bis_no=p.bis_no and prim=1 ORDER by date desc LIMIT 4;")
	List<Product> primList();*/

	@Select("select price from product where favorite='${value}'")
	List<Product> favorPrice(String favor);
	
	@Select("select * ,p.main_img fileurl from member m, product p where m.bis_no=p.bis_no and m.id=#{id} order by date limit 3;")
	List<Product> primList(String id);
	
	@Select("select * from member m where type = 2 and m.money > 500000 and m.prim = true and\r\n" + 
			"(select m.score/count(*) from trade t where t.sell_id=m.id and t.rv_chk=2) > 7.5 order by money DESC limit 0,1;")
	String primGetId1();
	
	@Select("select * from member m where type = 2 and m.money > 500000 and m.prim = true and\r\n" + 
			"(select m.score/count(*) from trade t where t.sell_id=m.id and t.rv_chk=2) > 7.5 order by money DESC limit 1,1;")
	String primGetId2();
	
	@Select("select * from member m where type = 2 and m.money > 500000 and m.prim = true and\r\n" + 
			"(select m.score/count(*) from trade t where t.sell_id=m.id and t.rv_chk=2) > 7.5 order by money DESC limit 2,1;")
	String primGetId3();
	
	@Select("select * from member m where type = 2 and m.money > 500000 and m.prim = true and\r\n" + 
			"(select m.score/count(*) from trade t where t.sell_id=m.id and t.rv_chk=2) > 7.5 order by money DESC limit 3,1;")
	String primGetId4();
	
	
	
	
}