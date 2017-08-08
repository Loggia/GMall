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
	
	@NotEmpty
	private String have_id;
	
	@NotEmpty
	private int read_chk;

	@Override
	public String toString() {
		return "Message [msg_no=" + msg_no + ", msg_subject=" + msg_subject + ", msg_date=" + msg_date
				+ ", msg_content=" + msg_content + ", send_id=" + send_id + ", rec_id=" + rec_id + ", have_id="
				+ have_id + ", read_chk=" + read_chk + "]";
	}

	public String getHave_id() {
		return have_id;
	}

	public void setHave_id(String have_id) {
		this.have_id = have_id;
	}

	public int getRead_chk() {
		return read_chk;
	}

	public void setRead_chk(int read_chk) {
		this.read_chk = read_chk;
	}

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
