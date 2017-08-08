package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import logic.Message;

public interface MessageMapper {
	
	@Select("select * from message where send_id=#{loginUserId } and have_id=#{loginUserId }")
	List<Message> sendList(String loginUserId);
	
	@Select("select * from message where rec_id=#{loginUserId } and have_id=#{loginUserId }")
	List<Message> reciveList(String loginUserId);

}
