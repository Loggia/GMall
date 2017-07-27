package logic;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Board
{
private int board_no;
	
	@NotEmpty
	private String id;
	private String pass;
	
	@NotEmpty(message="제목을 입력해 주세요.")
	private String subject;
	
	@NotEmpty(message="내용을 입력해 주세요.")
	private String content;
	
	private int board_type;
	
	private Date regdate;
	
	private int readcnt;
	
	private String fileurl;
	private String fileurl2;
	private String fileurl3;
	
	private int ans_chk;
	private MultipartFile img1;
	private MultipartFile img2;
	private MultipartFile img3;
	
	public int getBoard_no() 
	{
		return board_no;
	}
	
	public void setBoard_no(int board_no) 
	{
		this.board_no = board_no;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getPass() 
	{
		return pass;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public String getSubject()
	{
		return subject;
	}
	
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}
	
	public int getBoard_type() 
	{
		return board_type;
	}
	
	public void setBoard_type(int board_type) 
	{
		this.board_type = board_type;
	}
	
	public Date getRegdate() 
	{
		return regdate;
	}
	
	public void setRegdate(Date regdate) 
	{
		this.regdate = regdate;
	}
	
	public int getReadcnt() 
	{
		return readcnt;
	}
	
	public void setReadcnt(int readcnt) 
	{
		this.readcnt = readcnt;
	}
	
	public String getFileurl() {
		if(fileurl == null) return "";
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
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

	public int getAns_chk()
	{
		return ans_chk;
	}
	
	public void setAns_chk(int ans_chk)
	{
		this.ans_chk = ans_chk;
	}

	public MultipartFile getImg1() {
		return img1;
	}

	public void setImg1(MultipartFile img1) {
		this.img1 = img1;
	}

	public MultipartFile getImg2() {
		return img2;
	}

	public void setImg2(MultipartFile img2) {
		this.img2 = img2;
	}

	public MultipartFile getImg3() {
		return img3;
	}

	public void setImg3(MultipartFile img3) {
		this.img3 = img3;
	}

	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", id=" + id + ", pass=" + pass + ", subject=" + subject + ", content="
				+ content + ", board_type=" + board_type + ", regdate=" + regdate + ", readcnt=" + readcnt
				+ ", fileurl=" + fileurl + ", fileurl2=" + fileurl2 + ", fileurl3=" + fileurl3 + ", ans_chk=" + ans_chk
				+ ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + "]";
	}
}