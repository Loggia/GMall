package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Product 
{
	@NotEmpty
	private int pro_no;
	
	@NotEmpty 
	private String bis_no;
	
	@NotEmpty
	private String bis_name;
	
	@NotEmpty
	private Date date;
	
	@NotEmpty
	private String pro_name;
	
	@NotEmpty
	private int price;
	
	@NotEmpty
	private int cnt;
	
	@NotEmpty
	private int prim;
	
	private int num;
	
	@NotEmpty
	private String category;
	private String favorite;
	private String pro_content;
	private String fileurl;
	private String fileurl1;
	private String fileurl2;
	private String fileurl3;
	
	private MultipartFile main_img;
	private MultipartFile sub_img1;
	private MultipartFile sub_img2;
	private MultipartFile sub_img3;
	
	@NotEmpty
	private String date2;
	
	private int averfavorprice;
		
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
	
	public String getBis_name() 
	{
		return bis_name;
	}
	
	public void setBis_name(String bis_name) 
	{
		this.bis_name = bis_name;
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
	
	public int getPrim() {
		return prim;
	}

	public void setPrim(int prim) {
		this.prim = prim;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
	
	public String getFileurl() {
		if(fileurl == null) return "";
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getFileurl1() {
		if(fileurl1 == null) return "";
		return fileurl1;
	}

	public void setFileurl1(String fileurl1) {
		this.fileurl1 = fileurl1;
	}

	public String getFileurl2() {
		if(fileurl2 == null) return "";
		return fileurl2;
	}

	public void setFileurl2(String fileurl2) {
		this.fileurl2 = fileurl2;
	}

	public String getFileurl3() {
		if(fileurl3 == null) return "";
		return fileurl3;
	}

	public void setFileurl3(String fileurl3) {
		this.fileurl3 = fileurl3;
	}

	public MultipartFile getMain_img() {
		return main_img;
	}

	public void setMain_img(MultipartFile main_img) {
		this.main_img = main_img;
	}

	public MultipartFile getSub_img1() {
		return sub_img1;
	}

	public void setSub_img1(MultipartFile sub_img1) {
		this.sub_img1 = sub_img1;
	}

	public MultipartFile getSub_img2() {
		return sub_img2;
	}

	public void setSub_img2(MultipartFile sub_img2) {
		this.sub_img2 = sub_img2;
	}

	public MultipartFile getSub_img3() {
		return sub_img3;
	}

	public void setSub_img3(MultipartFile sub_img3) {
		this.sub_img3 = sub_img3;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public int getAverfavorprice() {
		return averfavorprice;
	}

	public void setAverfavorprice(int averfavorprice) {
		this.averfavorprice = averfavorprice;
	}

	@Override
	public String toString() {
		return "Product [pro_no=" + pro_no + ", bis_no=" + bis_no + ", bis_name=" + bis_name + ", date=" + date
				+ ", pro_name=" + pro_name + ", price=" + price + ", cnt=" + cnt + ", prim=" + prim + ", num=" + num
				+ ", category=" + category + ", favorite=" + favorite + ", pro_content=" + pro_content + ", fileurl="
				+ fileurl + ", fileurl1=" + fileurl1 + ", fileurl2=" + fileurl2 + ", fileurl3=" + fileurl3
				+ ", main_img=" + main_img + ", sub_img1=" + sub_img1 + ", sub_img2=" + sub_img2 + ", sub_img3="
				+ sub_img3 + ", date2=" + date2 + ", averfavorprice=" + averfavorprice + "]";
	}

	
}