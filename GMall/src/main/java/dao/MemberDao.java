package dao;

import java.util.List;

import logic.Member;

public interface MemberDao 
{
	boolean insert(Member member); // 주한울 - 회원가입 
	boolean cheakMember(String bis_no); // 주한울 - 회원가입시 중복된 사업자 번호를 사용했는지를 판별
	Member getUserByIdAndPw(String id, String pass); // 주한울 - 로그인에 이용될 메서드
	void update(Member member); // 주한울 - 회원 수정
	void delete(Member member); // 주한울 - 회원 탈퇴
	List<String> selectBis_no(); // 주한울 - 사업자 번호 확인
	List<Member> selectBookmark(String id); // 주한울 - 관심 사업자 조회
	
	List<Member> nomalList(); //구정연 - 일반회원목록 
	List<Member> businessList(); //구정연 -사업자목록
}
