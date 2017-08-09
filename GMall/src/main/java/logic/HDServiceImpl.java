package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import dao.MessageDao;

@Service
public class HDServiceImpl implements HDService{
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	MessageDao messageDao;
	
	@Override
	public List<Product> primList() {
		return boardDao.primList();
	}

	@Override
	public List<Product> newList() {
		return boardDao.newList();
	}

	@Override
	public List<Product> popuList() {
		return boardDao.popuList();
	}

	@Override
	public List<Product> interList(String inter) {
		return boardDao.interList(inter);
	}

	@Override
	public List<Message> sendList(String loginUserId) {
		return messageDao.sendList(loginUserId);
	}

	@Override
	public List<Message> reciveList(String loginUserId) {
		return messageDao.reciveList(loginUserId);
	}

	@Override
	public void msgSend(Message message) {
		int msg_no = messageDao.maxNum();
		message.setMsg_no(++msg_no);
		messageDao.sendInsert(message);
		msg_no = msg_no+1;
		message.setMsg_no(msg_no);
		messageDao.reciveInsert(message);
		
		
	}

	@Override
	public Message msgDetail(Integer msg_no) {
		return messageDao.msgDetail(msg_no);
	}
	
	

}
