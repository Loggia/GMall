package dao;

import java.util.List;

import logic.Member;

public interface MemberDao 
{
	boolean insert(Member member); // 주한울 - 회원가입 
	Member selectOne(String id); // 주한울 - 로그인에 이용될 메서드
	void update(Member member); // 주한울 - 회원 수정
	void delete(Member member); // 주한울 - 회원 탈퇴
	
	List<Member> nomalList(); //구정연 - 일반회원목록 
	List<Member> businessList(); //구정연 -사업자목록
}
