package logic;

import org.hibernate.validator.constraints.NotEmpty;

public class Coupon_history {
	
	
	@NotEmpty
	private int his_no;
	
	@NotEmpty
	private String cop_no;
	
	@NotEmpty
	private String bis_no;
	
	@NotEmpty
	private int discount;
	
	@NotEmpty
	private String id;
	
	@NotEmpty
	private int chk;
	private String nickname;
	private String bis_name;

	public int getHis_no() {
		return his_no;
	}

	public void setHis_no(int his_no) {
		this.his_no = his_no;
	}

	public String getCop_no() {
		return cop_no;
	}

	public void setCop_no(String cop_no) {
		this.cop_no = cop_no;
	}

	public String getBis_no() {
		return bis_no;
	}

	public void setBis_no(String bis_no) {
		this.bis_no = bis_no;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getChk() {
		return chk;
	}

	public void setChk(int chk) {
		this.chk = chk;
	}

	public String getNickname() 
	{
		return nickname;
	}

	public void setNickname(String nickname) 
	{
		this.nickname = nickname;
	}

	public String getBis_name() 
	{
		return bis_name;
	}

	public void setBis_name(String bis_name) 
	{
		this.bis_name = bis_name;
	}
}
