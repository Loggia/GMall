package dao;

import org.apache.ibatis.session.SqlSessionException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import dao.mapper.MemberMapper;
import logic.Member;

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

}
