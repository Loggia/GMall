package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import dao.mapper.BoardMapper;
import dao.mapper.MessageMapper;
import logic.Message;

public class MessageDaoImpl implements MessageDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession; 
	private final String NS = "dao.mapper.MessageMapper."; 
	
	@Override
	public List<Message> sendList(String loginUserId) {
		return sqlSession.getMapper(MessageMapper.class).sendList(loginUserId);
	}

	@Override
	public List<Message> reciveList(String loginUserId) {
		return sqlSession.getMapper(MessageMapper.class).reciveList(loginUserId);
	}
	
}
