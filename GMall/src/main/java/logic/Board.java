package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Board
{
	@NotEmpty
	private int board_no;
	
	@NotEmpty
	private String id;
	private String pass;
	
	@NotEmpty
	private String subject;
	
	@NotEmpty
	private String content;
	
	@NotEmpty
	private int board_type;
	
	@NotEmpty
	private Date regdate;
	
	private int readcnt;
	
	@NotEmpty
	private int ans_chk;
	private String img1;
	private String img2;
	private String img3;
	
	public int getBoard_no() 
	{
		return board_no;
	}
	
	public void setBoard_no(int board_no) 
	{
		this.board_no = board_no;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getPass() 
	{
		return pass;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public String getSubject()
	{
		return subject;
	}
	
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}
	
	public int getBoard_type() 
	{
		return board_type;
	}
	
	public void setBoard_type(int board_type) 
	{
		this.board_type = board_type;
	}
	
	public Date getRegdate() 
	{
		return regdate;
	}
	
	public void setRegdate(Date regdate) 
	{
		this.regdate = regdate;
	}
	
	public int getReadcnt() 
	{
		return readcnt;
	}
	
	public void setReadcnt(int readcnt) 
	{
		this.readcnt = readcnt;
	}
	
	public int getAns_chk()
	{
		return ans_chk;
	}
	
	public void setAns_chk(int ans_chk)
	{
		this.ans_chk = ans_chk;
	}
	
	public String getImg1()
	{
		return img1;
	}
	
	public void setImg1(String img1) 
	{
		this.img1 = img1;
	}
	
	public String getImg2() 
	{
		return img2;
	}
	
	public void setImg2(String img2) 
	{
		this.img2 = img2;
	}
	
	public String getImg3()
	{
		return img3;
	}
	
	public void setImg3(String img3) 
	{
		this.img3 = img3;
	}
}
