package dao;

import java.util.List;

import logic.Member;

public interface MemberDao 
{
	boolean insert(Member member); // 회원가입 
	Member selectOne(String id); // 로그인에 이용될 메서드
	List<Member> nomalList(); //구정연 - 일반회원목록 
}
