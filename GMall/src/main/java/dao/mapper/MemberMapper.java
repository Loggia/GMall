package dao.mapper;

import java.util.List;

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
		  + "tel=#{tel},address=#{address},interest=#{interest},bis_no=#{bis_no},bis_name=#{bis_name} "
		  + "where id=#{id}")	
	void update(Member member);

	@Delete("delete from member where id=#{id} and pass=#{pass}")
	void delete(Member member);

	@Select("select * from member where id=#{id}")
	Member selectOne(String id);
}
