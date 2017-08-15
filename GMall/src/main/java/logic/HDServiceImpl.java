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
	public List<Message> sendList(String loginUserId, Integer pageNum, Integer limit) {
		return messageDao.sendList(loginUserId,pageNum,limit);
	}

	@Override
	public List<Message> reciveList(String loginUserId, Integer pageNum, Integer limit) {
		return messageDao.reciveList(loginUserId,pageNum,limit);
	}

	@Override
	public void msgSend(Message message) {
		int msg_no = messageDao.maxNum();
		if(msg_no==0) {
			
		}
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

	@Override
	public void msgDelete(Integer msg_no) {
		messageDao.msgDelete(msg_no);
	}

	@Override
	public void deleteAllSendMsg(String id) {
		messageDao.deleteAllSendMsg(id);
	}

	@Override
	public void deleteAllReciveMsg(String id) {
		messageDao.deleteAllReciveMsg(id);
	}

	@Override
	public int reciveListCount(String loginUserId) {
		return messageDao.reciveListCount(loginUserId);
	}

	@Override
	public int sendListCount(String loginUserId) {
		return messageDao.sendListCount(loginUserId);
	}

	@Override
	public List<Product> primList1() {
		String id = boardDao.primGetId1();
		return boardDao.primList(id);
	}

	@Override
	public List<Product> primList2() {
		String id = boardDao.primGetId2();
		return boardDao.primList(id);
	}

	@Override
	public List<Product> primList3() {
		String id = boardDao.primGetId3();
		return boardDao.primList(id);
	}

	@Override
	public List<Product> primList4() {
		String id = boardDao.primGetId4();
		return boardDao.primList(id);
	}

	@Override
	public Product prim1() {
		String id = boardDao.primGetId1();
		return boardDao.prim(id);
	}

	@Override
	public Product prim2() {
		String id = boardDao.primGetId2();
		return boardDao.prim(id);
	}

	@Override
	public Product prim3() {
		String id = boardDao.primGetId3();
		return boardDao.prim(id);
	}

	@Override
	public Product prim4() {
		String id = boardDao.primGetId4();
		return boardDao.prim(id);
	}
	
	

}
