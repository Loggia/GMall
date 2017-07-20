package dao;

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

	@Override
	public Member selectOne(String id) 
	{
		try
		{
			return sqlSession.getMapper(MemberMapper.class).selectOne(id);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
			return null;
		}
	}
}
