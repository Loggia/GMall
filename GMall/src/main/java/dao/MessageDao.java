package dao;

import java.util.List;

import logic.Message;

public interface MessageDao {

	List<Message> sendList(String loginUserId);

	List<Message> reciveList(String loginUserId);

	int maxNum();

	void sendInsert(Message message);

	void reciveInsert(Message message);

	Message msgDetail(Integer msg_no);

}
