package logic;

import org.hibernate.validator.constraints.NotEmpty;

public class Coupon 
{
	@NotEmpty
	private int coup_no;
	
	@NotEmpty
	private int coup_type;
	
	@NotEmpty
	private String id;
	
	@NotEmpty
	private int discount;

	public int getCoup_no() 
	{
		return coup_no;
	}

	public void setCoup_no(int coup_no) 
	{
		this.coup_no = coup_no;
	}

	public int getCoup_type() 
	{
		return coup_type;
	}

	public void setCoup_type(int coup_type) 
	{
		this.coup_type = coup_type;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public int getDiscount() 
	{
		return discount;
	}

	public void setDiscount(int discount) 
	{
		this.discount = discount;
	}
}
