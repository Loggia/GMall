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
	public void insert(Member member) 
	{
		try
		{
			sqlSession.getMapper(MemberMapper.class).insert(member);
		}
		catch (Exception e) 
		{
			return;
		}
	}
	
	/*
	 * 주한울
	 * 회원가입시 중복된 사업자 번호를 사용했는지를 판별
	 */
	@Override
	public boolean cheakMember(String bis_no) 
	{
		try
		{
			Member member = sqlSession.getMapper(MemberMapper.class).cheakMember(bis_no);
			
			if(member == null || member.getId().equals(""))
			{
				return true;
			}
			
			return false;
		}
		catch (Exception e) 
		{
			return true;
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
	 * 주한울
	 * 관심 사업자 조회
	 */
	@Override
	public List<Member> selectBookmark(String id) 
	{
		try
		{
			return sqlSession.getMapper(MemberMapper.class).bookmark(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			return null;
		}
	}

	@Override
	public int nomalCount() 
	{
		return sqlSession.getMapper(MemberMapper.class).nomalCount();
	}
	
	/*
	 * 구정연
	 * 일반회원목록
	 */
	@Override
	public List<Member> nomalList(Integer pageNum, Integer limit) 
	{
		int startrow = (pageNum - 1) * limit;
    	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		
		return sqlSession.getMapper(MemberMapper.class).nomalList(map);
	}
	
	@Override
	public int businessCount() 
	{
		return sqlSession.getMapper(MemberMapper.class).businessCount();
	}
	
	/*
	 * 구정연
	 * 사업자 관리
	 */
	@Override
	public List<Member> businessList(Integer pageNum, Integer limit) 
	{
		int startrow = (pageNum - 1) * limit;
    	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		
		return sqlSession.getMapper(MemberMapper.class).businessList(map);
	}

	/*
	 * 구정연 
	 * 프리미엄 리스트
	 */
	@Override
	public List<Member> primList() {
		
		return sqlSession.getMapper(MemberMapper.class).primList();
	}

	/*
	 * 구정연
	 * 프리미엄 업데이트
	 */
	@Override
	public void primupdate() {
		
		sqlSession.getMapper(MemberMapper.class).primdelete();
		sqlSession.getMapper(MemberMapper.class).primupdate();
	}

	/*
	 * 구정연
	 * 일반회원목록 아이디로 가져오기
	 */
	@Override
	public Member getUserById(String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		
		return sqlSession.getMapper(MemberMapper.class).getUserById(id);
	}
}
