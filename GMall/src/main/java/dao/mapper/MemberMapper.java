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
}
