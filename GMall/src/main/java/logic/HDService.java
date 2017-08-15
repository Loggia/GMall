package logic;

import java.util.List;

public interface HDService {

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

	List<Product> primList1();

	List<Product> primList2();

	List<Product> primList3();

	List<Product> primList4();

	Product prim1();

	Product prim2();

	Product prim3();

	Product prim4();

}
