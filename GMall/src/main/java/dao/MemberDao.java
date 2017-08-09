package dao;

import java.util.List;

import logic.Member;

public interface MemberDao 
{
	void insert(Member member); // 주한울 - 회원가입 
	boolean cheakMember(String bis_no); // 주한울 - 회원가입시 중복된 사업자 번호를 사용했는지를 판별
	Member getUserByIdAndPw(String id, String pass); // 주한울 - 로그인에 이용될 메서드
	void update(Member member); // 주한울 - 회원 수정
	void delete(Member member); // 주한울 - 회원 탈퇴
	List<String> selectBis_no(); // 주한울 - 사업자 번호 확인
	List<Member> selectBookmark(String id); // 주한울 - 관심 사업자 조회
	
	int nomalCount(); // 일반회원 카운팅
	List<Member> nomalList(Integer pageNum, Integer limit); //구정연 - 일반회원목록 
	int businessCount(); // 구정연 - 사업자 카운팅
	List<Member> businessList(Integer pageNum, Integer limit); //구정연 -사업자목록
	List<Member> primList();// 구정연 - 프리미엄 리스트
	void primupdate(); // 구정연 - 프리미엄 업데이트
	Member getUserById(String id); //구정연 - 일반회원목록 아이디로 가져오기
}
