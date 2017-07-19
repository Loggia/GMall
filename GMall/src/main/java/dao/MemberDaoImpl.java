package dao;

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
	public boolean createMember(Member member) 
	{
		
		return sqlSession.getMapper(MemberMapper.class).createMember(member);
	}

}