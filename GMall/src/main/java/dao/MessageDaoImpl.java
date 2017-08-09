package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Message> sendList(String loginUserId, Integer pageNum, Integer limit) {
		
		int startrow = (pageNum - 1) * limit;
    	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("loginUserId", loginUserId);
		
		return sqlSession.getMapper(MessageMapper.class).sendList(map);
	}

	@Override
	public List<Message> reciveList(String loginUserId, Integer pageNum, Integer limit) {
		
		int startrow = (pageNum - 1) * limit;
    	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("loginUserId", loginUserId);
		
		return sqlSession.getMapper(MessageMapper.class).reciveList(map);
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

	@Override
	public void msgDelete(Integer msg_no) {
		sqlSession.getMapper(MessageMapper.class).msgDelete(msg_no);
	}

	@Override
	public void deleteAllSendMsg(String id) {
		sqlSession.getMapper(MessageMapper.class).deleteAllSendMsg(id);
	}
	
	@Override
	public void deleteAllReciveMsg(String id) {
		sqlSession.getMapper(MessageMapper.class).deleteAllReciveMsg(id);
	}

	@Override
	public int reciveListCount(String loginUserId) {
		return sqlSession.getMapper(MessageMapper.class).reciveListCount(loginUserId);
	}

	@Override
	public int sendListCount(String loginUserId) {
		return sqlSession.getMapper(MessageMapper.class).sendListCount(loginUserId);
	}
	
}
