package logic;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Member 
{
	@NotEmpty
	private String id;
	
	@NotEmpty
	private String nickname;
	
	@NotEmpty
	private String pass;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private int gender;
	
	@NotEmpty
	private String tel;
	
	@NotEmpty
	private String address;
	private String picture;
	private MultipartFile pictureFile;
	
	@NotEmpty
	private int type;
	private String bis_no;
	private String bis_name;
	private boolean prim;
	private int money;
	private double score;
	private String cop_no;
	private String interest;

	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getNickname() 
	{
		return nickname;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getGender()
	{
		return gender;
	}
	
	public void setGender(int gender)
	{
		this.gender = gender;
	}
	
	public String getTel() 
	{
		return tel;
	}
	
	public void setTel(String tel) 
	{
		this.tel = tel;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getPicture() 
	{
		return picture;
	}
	
	public void setPicture(String picture)
	{
		this.picture = picture;
	}
	
	public MultipartFile getPictureFile() 
	{
		return pictureFile;
	}

	public void setPictureFile(MultipartFile pictureFile) 
	{
		this.pictureFile = pictureFile;
	}

	public int getType()
	{
		return type;
	}
	
	public void setType(int type) 
	{
		this.type = type;
	}
	
	public String getBis_no() 
	{
		return bis_no;
	}
	
	public void setBis_no(String bis_no) 
	{
		this.bis_no = bis_no;
	}
	
	public String getBis_name()
	{
		return bis_name;
	}
	
	public void setBis_name(String bis_name)
	{
		this.bis_name = bis_name;
	}
	
	public boolean isPrim() 
	{
		return prim;
	}
	
	public void setPrim(boolean prim) 
	{
		this.prim = prim;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public double getScore()
	{
		return score;
	}
	
	public void setScore(double score)
	{
		this.score = score;
	}
	
	public String getCop_no() 
	{
		return cop_no;
	}

	public void setCop_no(String cop_no) 
	{
		this.cop_no = cop_no;
	}
	
	public String getInterest() 
	{
		return interest;
	}

	public void setInterest(String interest) 
	{
		this.interest = interest;
	}
}
