package dao;

import logic.Member;

public interface MemberDao 
{
	boolean insert(Member member); // 회원가입 
	Member selectOne(String id); // 로그인에 이용될 메서드
}
