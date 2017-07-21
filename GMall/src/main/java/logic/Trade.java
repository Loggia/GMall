package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Trade 
{
	@NotEmpty
	private int trd_no;
	
	@NotEmpty
	private String trd_code;
	
	@NotEmpty
	private int trd_cnt;
	
	@NotEmpty
	private int trd_money;
	
	@NotEmpty
	private int trd_fee;
	
	@NotEmpty
	private Date trd_date;
	
	@NotEmpty
	private int pro_no;
	
	@NotEmpty
	private String buy_id;
	
	@NotEmpty
	private String sell_id;
	private String cop_no;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String delivery;

	public int getTrd_no() 
	{
		return trd_no;
	}

	public void setTrd_no(int trd_no) 
	{
		this.trd_no = trd_no;
	}

	public String getTrd_code() 
	{
		return trd_code;
	}

	public void setTrd_code(String trd_code) 
	{
		this.trd_code = trd_code;
	}

	public int getTrd_cnt() 
	{
		return trd_cnt;
	}

	public void setTrd_cnt(int trd_cnt) 
	{
		this.trd_cnt = trd_cnt;
	}

	public int getTrd_money() 
	{
		return trd_money;
	}

	public void setTrd_money(int trd_money) 
	{
		this.trd_money = trd_money;
	}

	public int getTrd_fee() 
	{
		return trd_fee;
	}

	public void setTrd_fee(int trd_fee) 
	{
		this.trd_fee = trd_fee;
	}

	public Date getTrd_date() 
	{
		return trd_date;
	}

	public void setTrd_date(Date trd_date) 
	{
		this.trd_date = trd_date;
	}

	public int getPro_no() 
	{
		return pro_no;
	}

	public void setPro_no(int pro_no)
	{
		this.pro_no = pro_no;
	}

	public String getBuy_id()
	{
		return buy_id;
	}

	public void setBuy_id(String buy_id)
	{
		this.buy_id = buy_id;
	}

	public String getSell_id()
	{
		return sell_id;
	}

	public void setSell_id(String sell_id)
	{
		this.sell_id = sell_id;
	}

	public String getCop_no()
	{
		return cop_no;
	}

	public void setCop_no(String cop_no) 
	{
		this.cop_no = cop_no;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getDelivery()
	{
		return delivery;
	}

	public void setDelivery(String delivery)
	{
		this.delivery = delivery;
	}
}
