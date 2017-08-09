package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import dao.CouponDao;
import dao.MemberDao;
import dao.ProductDao;
import dao.TradeDao;

@Service
public class KoServiceImpl implements KoService{ 
	@Autowired
	BoardDao boardDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	TradeDao tradeDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CouponDao couponDao;
	
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
	public List<Product> getProductList(String Bis_no) {
		return productDao.findAll(Bis_no);
	}
	//고종환 내사업장관리에서 카테고리 클릭시
	@Override
	public List<Product> categoryCheck(String bis_name, String category) {

		return productDao.categoryCheck(bis_name,category);
	}
	//고종환 사업자 거래목록
	@Override
	public List<Trade> tradeList(String id) {
		return tradeDao.tradeList(id);
	}
    
	//고종환 사업자 배송조회 (사용 안함)
	@Override
	public List<Trade> deliveryList(String id) {
		return tradeDao.deliveryList(id);
	}
	
	@Override
	public List<Trade> delvpageList(String id, int type, Integer pageNum, int limit) 
	{
		return tradeDao.delvpageList(id, type, pageNum, limit);
	}
	
	//고종환 사업자 쿠폰목록
	@Override
	public List<Coupon_history> bisCoupon(String id) 
	{
		return tradeDao.bisCoupon(id);
	}

	//고종환 사업자 쿠폰목록 카테고리 선택시
	@Override
	public List<Coupon_history> bisDiscountCheck(String id, String discount) 
	{
		return tradeDao.bisDiscountCheck(id,discount);
	}

	//고종환 사업자 배송현황 변경을 위한 쿼리
	@Override
	public String tradeCheck(String trd_no) {
		return tradeDao.tradeCheck(trd_no);
	}
	//고종환 사업자 배송현황 변경
	@Override
	public void deliveryControl(String trd_no, String tradeCheck) {
		tradeDao.deliveryControl(trd_no,tradeCheck);
		
	}
	
	@Override
	public int productCount(String bis_no, String category) 
	{
		return productDao.productCount(bis_no, category);
	}

	@Override
	public List<Product> productList(String bis_no, String category, Integer pageNum, int limit) 
	{
		return productDao.productList(bis_no, category, pageNum, limit);
	}
	
	//고종환 쿠폰내역번호
	@Override
	public int his_no() {
		return tradeDao.his_no();
	}

	//고종환 사업자 쿠폰 주기
	@Override
	public void insertCoupon(Map<String, Object> coupon_history) {
		couponDao.insertCoupon(coupon_history);
	}

}
