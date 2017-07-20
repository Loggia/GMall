package logic;

import org.hibernate.validator.constraints.NotEmpty;

public class Trade 
{
	@NotEmpty
	private int trd_no;
	
	@NotEmpty
	private String id;
	
	@NotEmpty
	private int pro_no;
	
	@NotEmpty
	private int trd_type;
	
	@NotEmpty
	private String delivery;
	
	@NotEmpty
	private String trd_code;
	
	@NotEmpty
	private int trd_cnt;
	
	@NotEmpty
	private int trd_money;
	
	@NotEmpty
	private int trd_fee;

	public int getTrd_no() {
		return trd_no;
	}

	public void setTrd_no(int trd_no) {
		this.trd_no = trd_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public int getTrd_type() {
		return trd_type;
	}

	public void setTrd_type(int trd_type) {
		this.trd_type = trd_type;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getTrd_code() {
		return trd_code;
	}

	public void setTrd_code(String trd_code) {
		this.trd_code = trd_code;
	}

	public int getTrd_cnt() {
		return trd_cnt;
	}

	public void setTrd_cnt(int trd_cnt) {
		this.trd_cnt = trd_cnt;
	}

	public int getTrd_money() {
		return trd_money;
	}

	public void setTrd_money(int trd_money) {
		this.trd_money = trd_money;
	}

	public int getTrd_fee() {
		return trd_fee;
	}

	public void setTrd_fee(int trd_fee) {
		this.trd_fee = trd_fee;
	}

	
}
