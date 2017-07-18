package logic;

import org.hibernate.validator.constraints.NotEmpty;

public class Trade 
{
	@NotEmpty
	private int ord_no;
	
	@NotEmpty
	private String id;
	
	@NotEmpty
	private int pro_no;
	
	@NotEmpty
	private int ord_type;
	
	@NotEmpty
	private String delivery;
	
	@NotEmpty
	private String ord_code;
	
	@NotEmpty
	private int ord_cnt;
	
	@NotEmpty
	private int ord_money;
	
	@NotEmpty
	private int ord_fee;

	public int getOrd_no()
	{
		return ord_no;
	}

	public void setOrd_no(int ord_no)
	{
		this.ord_no = ord_no;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getPro_no()
	{
		return pro_no;
	}

	public void setPro_no(int pro_no)
	{
		this.pro_no = pro_no;
	}

	public int getOrd_type()
	{
		return ord_type;
	}

	public void setOrd_type(int ord_type)
	{
		this.ord_type = ord_type;
	}

	public String getDelivery()
	{
		return delivery;
	}

	public void setDelivery(String delivery)
	{
		this.delivery = delivery;
	}

	public String getOrd_code() 
	{
		return ord_code;
	}

	public void setOrd_code(String ord_code) 
	{
		this.ord_code = ord_code;
	}

	public int getOrd_cnt()
	{
		return ord_cnt;
	}

	public void setOrd_cnt(int ord_cnt) 
	{
		this.ord_cnt = ord_cnt;
	}

	public int getOrd_money()
	{
		return ord_money;
	}

	public void setOrd_money(int ord_money)
	{
		this.ord_money = ord_money;
	}

	public int getOrd_fee()
	{
		return ord_fee;
	}

	public void setOrd_fee(int ord_fee) 
	{
		this.ord_fee = ord_fee;
	}
}
