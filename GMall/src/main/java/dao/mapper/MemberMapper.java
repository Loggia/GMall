package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Member;

public interface MemberMapper 
{
	@Insert("insert into member (type,id,pass,name,nickname,gender,tel,address,interest,bis_no,bis_name) "
		  + "values(#{type},#{id},#{pass},#{name},#{nickname},#{gender},#{tel},#{address},#{interest},#{bis_no},#{bis_name})")
	void insert(Member member);
	
	@Select("select * from member where id=#{id}")
	Member selectOne(String id);

}
