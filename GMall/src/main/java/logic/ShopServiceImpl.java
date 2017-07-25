package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;

import dao.BoardDao;
import dao.MemberDao;
import dao.ProductDao;
import dao.TradeDao;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	BoardDao boardDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	TradeDao tradedao;
	@Autowired
	ProductDao productDao;
	
	/*
	   배기수 
	*/
	@Override
	public List<Board> infiniteScrollDown(int numToStart) {
		return boardDao.infiniteScrollDown(numToStart);
	}

	@Override
	public List<Board> infiniteScrollUp(int numToEnd) {
		return boardDao.infiniteScrollUp(numToEnd);
	}

	@Override
	public List<Board> proList() {
		return boardDao.proList();
	}
	
	@Override
	public int centerCount(String searchType, String searchContent) {
		return boardDao.centerCount(searchType, searchContent);
	}
	
	@Override
	public List<Board> centerList(String searchType, String searchContent, Integer pageNum, int limit) {
		return boardDao.centerList(searchType, searchContent, pageNum, limit);
	}

	@Override
	public void centerInsert(Board board, HttpServletRequest request) {
		board.setFileurl(board.getImg1().getOriginalFilename());
		board.setFileurl2(board.getImg2().getOriginalFilename());
		board.setFileurl3(board.getImg3().getOriginalFilename());
		if(board.getImg1() != null && !board.getImg1().isEmpty())
		{
			uploadFileCreate(board.getImg1(), request);
		}
		if(board.getImg2() != null && !board.getImg2().isEmpty())
		{
			uploadFileCreate(board.getImg2(), request);
		}
		if(board.getImg3() != null && !board.getImg3().isEmpty())
		{
			uploadFileCreate(board.getImg3(), request);
		}
		board.setBoard_type(1); 
		board.setAns_chk(0);
		int num = boardDao.getMaxNum(board.getBoard_type());
		board.setBoard_no(++num);
		boardDao.centerInsert(board);	
	}	
	
	private void uploadFileCreate(MultipartFile img, HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/") + "/fileupload/";
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(uploadPath + img.getOriginalFilename());
			InputStream in = img.getInputStream();
			int data;
			byte[] buf = new byte[10240];
			while((data = in.read(buf)) != -1)
			{
				fos.write(buf,0,data);
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(fos != null)
				{
					fos.flush();
					fos.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}	
	
	

	/*
	 * 주한울
	 * 회원가입
	 */
	@Override
	public boolean insertMember(Member member) 
	{
		return memberDao.insert(member);
	}
	
	/*
	 * 주한울
	 * 로그인
	 */
	@Override
	public Member getUserByIdAndPw(String id, String pass)
	{
		return memberDao.getUserByIdAndPw(id, pass);
	}
	
	/*
	 * 주한울
	 * 회원 수정
	 */
	@Override
	public void updateMember(Member member) 
	{
		memberDao.update(member);
	}
	
	/*
	 * 주한울
	 * 회원 탈퇴
	 */
	@Override
	public void deleteMember(Member member) 
	{
		memberDao.delete(member);
	}
	
	/*
	 * 주한울
	 * 사업자 번호 확인
	 */
	@Override
	public List<String> selectBis_no() 
	{
		return memberDao.selectBis_no();
	}
	
	/*
	 * 구정연 
	 * 회원관리목록
	 */
	@Override
	public List<Trade> tradeList() {
		
		return tradedao.tradeList();
	}

	/*
	 * 구정연 
	 * 일반회원목록
	 */
	@Override
	public List<Member> nomalList() {
		
		return memberDao.nomalList();
	}
	/*
	 * 구정연
	 * 사업자관리
	 */
	@Override
	public List<Member> businessList() {
		
		return memberDao.businessList();
	}
	/*
	 * 고종환 
	 * 사업자 물품등록
	 */
	@Override
	public void ProductAdd(Product product , HttpServletRequest request) {
		product.setFileurl(product.getMain_img().getOriginalFilename());
		product.setFileurl1(product.getSub_img1().getOriginalFilename());
		product.setFileurl2(product.getSub_img2().getOriginalFilename());
		product.setFileurl3(product.getSub_img3().getOriginalFilename());	
		if(product.getMain_img() !=null && !product.getMain_img().isEmpty() ){
			uploadFile(product.getMain_img(),request);
		}
		if(product.getSub_img1() !=null && !product.getSub_img1().isEmpty() ){
			uploadFile(product.getSub_img1(),request);
		}
		if(product.getSub_img2() !=null && !product.getSub_img2().isEmpty() ){
			uploadFile(product.getSub_img2(),request);
		}
		if(product.getSub_img3() !=null && !product.getSub_img3().isEmpty() ){
			uploadFile(product.getSub_img3(),request);
		}
		System.out.println("에러없지 들어왔어?"+product);
		productDao.ProductAdd(product);
		
	}
	
	//고종환 파일 업로드
	private void uploadFile(MultipartFile img, HttpServletRequest request) {
		String uploadpath=request.getServletContext().getRealPath("/")+"/picture/";
		FileOutputStream fos=null;
		//picture.getOriginalFilename(): 업로드된 파일의 원래 파일이름
		try{
			fos= new FileOutputStream(uploadpath+img.getOriginalFilename());
			//picture.getInputStream(): 파일의 내용을 읽기위한 스트림
			InputStream in=img.getInputStream();
			int data;
			byte[] buf=new byte[1024];
			while((data=in.read(buf)) != -1)
				fos.write(buf,0,data);
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(fos !=null){
					fos.flush(); fos.close();
				}
			}catch (IOException e) {}
		}
	}
	@Override
	public int prono() {
		return productDao.prono();
	}
	//고종환 내사업장 관리
	@Override
	public List<Product> getProductList(String id) {
		return productDao.findAll(id);
	}
	//고종환 내사업장관리에서 카테고리 클릭시
	@Override
	public List<Product> categoryCheck(String id, String category) {

		return productDao.categoryCheck(id,category);
	}
}