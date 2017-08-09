package logic;

import java.util.List;

public interface HDService {

	List<Product> primList();

	List<Product> newList();

	List<Product> popuList();

	List<Product> interList(String inter);

	List<Message> sendList(String loginUserId, Integer pageNum, Integer limit);

	List<Message> reciveList(String loginUserId, Integer pageNum, Integer limit);

	void msgSend(Message message);

	Message msgDetail(Integer msg_no);

	void msgDelete(Integer msg_no);

	void deleteAllSendMsg(String id);

	void deleteAllReciveMsg(String id);

	int reciveListCount(String loginUserId);

	int sendListCount(String loginUserId);

}
