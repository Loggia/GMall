package logic;

import org.hibernate.validator.constraints.NotEmpty;

public class Bookmark 
{
	@NotEmpty
	private int mark_no;
	
	@NotEmpty
	private String id;
	
	@NotEmpty
	private String bis_no;

	public int getMark_no() 
	{
		return mark_no;
	}

	public void setMark_no(int mark_no) 
	{
		this.mark_no = mark_no;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getBis_no() 
	{
		return bis_no;
	}

	public void setBis_no(String bis_no) 
	{
		this.bis_no = bis_no;
	}
}
