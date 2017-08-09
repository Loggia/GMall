package logic;

import java.util.List;

public interface HDService {

	List<Product> primList();

	List<Product> newList();

	List<Product> popuList();

	List<Product> interList(String inter);

	List<Message> sendList(String loginUserId);

	List<Message> reciveList(String loginUserId);

	void msgSend(Message message);

	Message msgDetail(Integer msg_no);

	void msgDelete(Integer msg_no);

}
