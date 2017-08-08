package logic;

import java.util.List;

public interface HDService {

	List<Product> primList();

	List<Product> newList();

	List<Product> popuList();

	List<Product> interList(String inter);

	List<Message> sendList(String loginUserId);

	List<Message> reciveList(String loginUserId);

}
