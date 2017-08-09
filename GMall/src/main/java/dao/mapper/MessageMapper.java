package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Message;

public interface MessageMapper {
	
	@Select("select * from message where send_id=#{loginUserId } and have_id=#{loginUserId } order by msg_date desc")
	List<Message> sendList(String loginUserId);
	
	@Select("select * from message where rec_id=#{loginUserId } and have_id=#{loginUserId } order by msg_date desc")
	List<Message> reciveList(String loginUserId);
	
	@Select("select IFNULL(MAX(msg_no),0) from message")
	int maxNum();
	
	@Insert("insert into message (msg_no, msg_date, msg_content, send_id, rec_id, have_id, read_chk)" + 
			"values(#{msg_no}, now(), #{msg_content}, #{send_id}, #{rec_id}, #{send_id}, 0);")
	void sendInsert(Message message);

	@Insert("insert into message (msg_no, msg_date, msg_content, send_id, rec_id, have_id, read_chk)" + 
			"values(#{msg_no}, now(), #{msg_content}, #{send_id}, #{rec_id}, #{rec_id}, 0);")
	void reciveInsert(Message message);
	
	@Select("select * from message where msg_no=#{msg_no}")
	Message msgDetail(Integer msg_no);
	
	@Delete("delete from message where msg_no=#{msg_no}")
	void msgDelete(Integer msg_no);
	
	@Delete("delete from message where send_id=#{id}")
	void deleteAllSendMsg(String id);
	
	@Delete("delete from message where rec_id=#{id}") 
	void deleteAllReciveMsg(String id);

}
