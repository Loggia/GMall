package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Message 
{
	@NotEmpty
	private int msg_no;
	
	@NotEmpty
	private String msg_subject;
	
	@NotEmpty
	private Date msg_date;
	
	@NotEmpty
	private String msg_content;
	
	@NotEmpty
	private String send_id;
	
	@NotEmpty
	private String rec_id;

	public int getMsg_no() 
	{
		return msg_no;
	}

	public void setMsg_no(int msg_no) 
	{
		this.msg_no = msg_no;
	}

	public String getMsg_subject() 
	{
		return msg_subject;
	}

	public void setMsg_subject(String msg_subject) 
	{
		this.msg_subject = msg_subject;
	}

	public Date getMsg_date() 
	{
		return msg_date;
	}

	public void setMsg_date(Date msg_date) 
	{
		this.msg_date = msg_date;
	}

	public String getMsg_content() 
	{
		return msg_content;
	}

	public void setMsg_content(String msg_content) 
	{
		this.msg_content = msg_content;
	}

	public String getSend_id()
	{
		return send_id;
	}

	public void setSend_id(String send_id)
	{
		this.send_id = send_id;
	}

	public String getRec_id()
	{
		return rec_id;
	}

	public void setRec_id(String rec_id) 
	{
		this.rec_id = rec_id;
	}
}
