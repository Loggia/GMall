package dao;

import java.util.List;

import logic.Message;

public interface MessageDao {

	List<Message> sendList(String loginUserId, Integer pageNum, Integer limit);

	List<Message> reciveList(String loginUserId, Integer pageNum, Integer limit);

	int maxNum();

	void sendInsert(Message message);

	void reciveInsert(Message message);

	Message msgDetail(Integer msg_no);

	void msgDelete(Integer msg_no);

	void deleteAllSendMsg(String id);

	void deleteAllReciveMsg(String id);

	int reciveListCount(String loginUserId);

	int sendListCount(String loginUserId);

}
