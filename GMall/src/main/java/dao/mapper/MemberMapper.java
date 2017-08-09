package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Member;

public interface MemberMapper 
{
	@Insert("insert into member (type,id,pass,name,nickname,gender,tel,address,interest,bis_no,bis_name) "
		  + "values(#{type},#{id},#{pass},#{name},#{nickname},#{gender},#{tel},#{address},#{interest},#{bis_no},#{bis_name})")
	void insert(Member member);
	
	@Update("update member set pass=#{pass},name=#{name},nickname=#{nickname},gender=#{gender},"
		  + "tel=#{tel},address=#{address},interest=#{interest},bis_no=#{bis_no},bis_name=#{bis_name}, picture=#{picture} "
		  + "where id=#{id}")	
	void update(Member member);

	@Delete("delete from member where id=#{id} and pass=#{pass}")
	void delete(Member member);

	@Select("select * from member where id=#{id} and pass=#{pass}")
	Member getUserByIdAndPw(Map<String, String> map);
	
	@Select("select * from bis_table")
	List<String> selectBis_no();
	
	@Select("select m.bis_name,m.tel,m.prim from member m,bookmark b where b.id=#{id} and m.bis_no=b.bis_no order by m.bis_no")
	List<Member> bookmark(String id);
	
	@Select("select id, bis_no from member where bis_no=#{bis_no}")
	Member cheakMember(String bis_no);
	
	@Select("select * from member where prim=1 ")
	List<Member> primList();

	@Update("update member m set m.prim = true where type = 2 and m.money > 500000 and "
			+ " (select m.score/count(*) from trade t where t.sell_id=m.id and t.rv_chk=2) > 7.5 order by money DESC limit 5")
	void primupdate();

	@Update("update member set prim = false")
	void primdelete();

	@Select("select * from member where id = #{id}")
	Member getUserById(String id);

	@Select("select count(*) from member where type = 1")
	int nomalCount();
	
	@Select("select * from member where type = 1 limit #{startrow}, 20")
	List<Member> nomalList(Map map);

	@Select("select count(*) from member where type = 2")
	int businessCount();

	@Select("select * from member where type = 2 limit #{startrow}, 20")
	List<Member> businessList(Map<String, Object> map);
}
