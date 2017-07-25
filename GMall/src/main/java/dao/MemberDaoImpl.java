package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.MemberMapper;
import logic.Member;

@Repository
public class MemberDaoImpl implements MemberDao
{
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession; 
	private final String NS = "dao.mapper.MemberMapper."; 
	
	/*
	 * 주한울
	 * 회원 가입
	 */
	@Override
	public boolean insert(Member member) 
	{
		try
		{
			sqlSession.getMapper(MemberMapper.class).insert(member);
			
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	/*
	 * 주한울	
	 * 하나의 레코드만 쿼리해옴
	 *  - 로그인
	 */
	@Override
	public Member getUserByIdAndPw(String id, String pass) 
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		
		return sqlSession.getMapper(MemberMapper.class).getUserByIdAndPw(map);
	}
	
	/*
	 * 주한울
	 * 회원 수정
	 */
	@Override
	public void update(Member member) 
	{
		try
		{
			sqlSession.getMapper(MemberMapper.class).update(member);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * 주한울
	 * 회원 탈퇴
	 */
	@Override
	public void delete(Member member) 
	{
		try
		{
			sqlSession.getMapper(MemberMapper.class).delete(member);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * 주한울
	 * 사업자 번호 확인
	 */
	@Override
	public List<String> selectBis_no() 
	{
		try
		{
			return sqlSession.getMapper(MemberMapper.class).selectBis_no();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
			return null;
		}
	}

	/*
	 * 구정연
	 * 일반회원목록
	 */
	
	@Override
	public List<Member> nomalList() {
		
		Map<String, Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("type", 1);
		
		return sqlSession.selectList(NS + "list" , paramMap);
	}
	/*
	 * 구정연
	 * 사업자 관리
	 */
	@Override
	public List<Member> businessList() {
		
		Map<String, Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("type", 2);
		
		return sqlSession.selectList(NS + "list" , paramMap);
	}
	
}
