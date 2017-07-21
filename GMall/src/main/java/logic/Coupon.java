package logic;

import org.hibernate.validator.constraints.NotEmpty;

public class Coupon 
{
	@NotEmpty
	private String cop_no;
	
	@NotEmpty
	private String bis_no;
	
	@NotEmpty
	private int discount;

	public String getCop_no() 
	{
		return cop_no;
	}

	public void setCop_no(String cop_no) 
	{
		this.cop_no = cop_no;
	}

	public String getBis_no() 
	{
		return bis_no;
	}

	public void setBis_no(String bis_no) 
	{
		this.bis_no = bis_no;
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
