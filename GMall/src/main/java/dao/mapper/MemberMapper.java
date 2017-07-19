package dao.mapper;

import org.apache.ibatis.annotations.Insert;

import logic.Member;

public interface MemberMapper 
{
	@Insert()
	boolean createMember(Member member);
}
