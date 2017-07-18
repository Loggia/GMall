package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Board
{
	@NotEmpty
	private int num;
	
	@NotEmpty
	private String id;
	private String pass;
	
	@NotEmpty
	private String subject;
	
	@NotEmpty
	private String content;
	
	@NotEmpty
	private Date regdate;
	
	private int readcnt;
	private int ref;
	private int reflevel;
	private int refstep;
	private String img1;
	private String img2;
	private String img3;
	
	public int getNum() 
	{
		return num;
	}
	
	public void setNum(int num) 
	{
		this.num = num;
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
	
	public int getRef() 
	{
		return ref;
	}
	
	public void setRef(int ref) 
	{
		this.ref = ref;
	}
	
	public int getReflevel() 
	{
		return reflevel;
	}
	
	public void setReflevel(int reflevel) 
	{
		this.reflevel = reflevel;
	}
	
	public int getRefstep() 
	{
		return refstep;
	}
	
	public void setRefstep(int refstep) 
	{
		this.refstep = refstep;
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
