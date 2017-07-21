package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Product 
{
	@NotEmpty
	private int pro_no;
	
	@NotEmpty 
	private String bis_no;
	
	@NotEmpty
	private String id;
	
	@NotEmpty
	private Date date;
	
	@NotEmpty
	private String pro_name;
	
	@NotEmpty
	private int price;
	
	@NotEmpty
	private int cnt;
	
	@NotEmpty
	private String category;
	private String favorite;
	private String pro_content;
	private String main_img;
	private String sub_img1;
	private String sub_img2;
	private String sub_img3;
	
	public int getPro_no() 
	{
		return pro_no;
	}
	
	public void setPro_no(int pro_no)
	{
		this.pro_no = pro_no;
	}
	
	public String getBis_no()
	{
		return bis_no;
	}
	
	public void setBis_no(String bis_no)
	{
		this.bis_no = bis_no;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public Date getDate() 
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	public String getPro_name()
	{
		return pro_name;
	}
	
	public void setPro_name(String pro_name)
	{
		this.pro_name = pro_name;
	}
	
	public int getPrice() 
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public int getCnt()
	{
		return cnt;
	}
	
	public void setCnt(int cnt) 
	{
		this.cnt = cnt;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public String getFavorite() 
	{
		return favorite;
	}

	public void setFavorite(String favorite) 
	{
		this.favorite = favorite;
	}
	
	public String getPro_content() 
	{
		return pro_content;
	}
	
	public void setPro_content(String pro_content)
	{
		this.pro_content = pro_content;
	}
	
	public String getMain_img()
	{
		return main_img;
	}
	
	public void setMain_img(String main_img)
	{
		this.main_img = main_img;
	}
	
	public String getSub_img1()
	{
		return sub_img1;
	}
	
	public void setSub_img1(String sub_img1) 
	{
		this.sub_img1 = sub_img1;
	}
	
	public String getSub_img2()
	{
		return sub_img2;
	}
	
	public void setSub_img2(String sub_img2) 
	{
		this.sub_img2 = sub_img2;
	}
	
	public String getSub_img3() 
	{
		return sub_img3;
	}
	
	public void setSub_img3(String sub_img3)
	{
		this.sub_img3 = sub_img3;
	}
}
