package dao.mapper;

import org.apache.ibatis.annotations.Insert;

import logic.Member;

public interface MemberMapper 
{
	@Insert("insert into member (type,id,pass,name,nickname,gender,tel,address,interest,bis_no,bis_name) "
		  + "values(#{type},#{id},#{pass},#{name},#{nickname},#{gender},#{tel},#{address},#{interest},#{bis_no},#{bis_name}")
	boolean createMember(Member member);
}
