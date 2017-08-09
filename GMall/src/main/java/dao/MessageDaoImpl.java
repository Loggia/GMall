package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.MessageMapper;
import logic.Message;

@Repository
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

	@Override
	public int maxNum() {
		return sqlSession.getMapper(MessageMapper.class).maxNum();
	}

	@Override
	public void sendInsert(Message message) {
		sqlSession.getMapper(MessageMapper.class).sendInsert(message);
	}

	@Override
	public void reciveInsert(Message message) {
		sqlSession.getMapper(MessageMapper.class).reciveInsert(message);
	}

	@Override
	public Message msgDetail(Integer msg_no) {
		return sqlSession.getMapper(MessageMapper.class).msgDetail(msg_no);
	}
	

	
}
