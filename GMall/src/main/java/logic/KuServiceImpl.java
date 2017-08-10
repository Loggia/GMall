package logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import dao.CouponDao;
import dao.MemberDao;
import dao.ProductDao;
import dao.TradeDao;

@Service
public class KuServiceImpl implements KuService
{
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
	 * 구정연 
	 * 회원관리목록
	 */
	@Override
	public List<Trade> tradeList() {
		
		return tradeDao.tradeList();
	}

	@Override
	public int nomalCount() // 일반회원 카운팅
	{
		return memberDao.nomalCount();
	}
	
	/*
	 * 구정연 
	 * 일반회원목록
	 */
	@Override
	public List<Member> nomalList(Integer pageNum, Integer limit) 
	{
		return memberDao.nomalList(pageNum, limit);
	}
	
	@Override 
	public int businessCount() // 사업자 카운팅
	{
		return memberDao.businessCount();
	}
	
	/*
	 * 구정연
	 * 사업자관리
	 */
	@Override
	public List<Member> businessList(Integer pageNum, Integer limit) 
	{
		return memberDao.businessList(pageNum, limit);
	}
	
	/*
	 * 구정연
	 * 프리미엄 리스트
	 */
	@Override
	public List<Member> primList() {
		
		return memberDao.primList();
	}
	/*
	 * 구정연
	 * 프리미엄 업데이트
	 */
	@Override
	public void primupdate() {
		
		memberDao.primupdate();
	}
	
	@Override
	public Member getUserById(String id) 
	{
		return memberDao.getUserById(id);
	}

	@Override
	public Product getproductByNo(Integer pro_no) {
		
		return productDao.getproductByNo(pro_no);
	}
	
	/*
	 * 정연이
	 * 보유금액(금액 변동) 
	 */
	@Override
	public List<Trade> moneyChangeList(String id, Integer type, Integer pageNum, Integer limit) 
	{
		return tradeDao.moneyChangeList(id, type, pageNum, limit);
	}
	
	
	/*
	 * 구정연
	 * 장바구니 가격총합 
	 */
	@Override
	public Integer totalAmount(List<ProductSet> productList) {
		
		int total = 0;
		for (ProductSet is : productList){
			total += is.getProduct().getPrice() * is.getQuantity();
		}
		return total;
	}

	@Override
	public Trade checkEnd(String id, String trd_address, Cart cart)
	{
		Trade trade = new Trade();
		List<ProductSet> productList = cart.getProductList();
		DateFormat sdFormat = new SimpleDateFormat("yyMMddmmss");
		Date nowDate = new Date();
		String tempDate = sdFormat.format(nowDate);
		trade.setTrd_code(tempDate+"%"+id); //거래코드
		
		for(int i=0; i<productList.size(); i++) 
		{
			ProductSet productset = (ProductSet)productList.get(i);
			
			trade.setTrd_no(tradeDao.getMaxtrd_no()); //거래넘버
			trade.setAddress(trd_address); // 주소
			trade.setBuy_id(id); //구매자
			trade.setDelivery("상품준비중"); //배달
			trade.setRv_chk(1); //리뷰
			trade.setTrd_cnt(productset.getQuantity()); //수량
			trade.setTrd_money(productset.getQuantity()*productset.getProduct().getPrice()); //총가격
			trade.setPro_no(productset.getProduct().getPro_no()); //상품번호
			trade.setSell_id(tradeDao.sell_id(productset.getProduct().getBis_name())); //판매자 (상호) 조인으로 아이디 가져올수도있을까
			trade.setCop_no(productset.getProduct().getCop_no());
			
			String prim = tradeDao.prim(productset.getProduct().getPro_name());
			
			if (prim.equals("1")) 
			{
				trade.setTrd_fee(tradeDao.yesprim(productset.getProduct().getPro_name()));
			} 
			else 
			{
				trade.setTrd_fee(tradeDao.Noprim(productset.getProduct().getPro_name()));
			} //수수료
			
			tradeDao.createtrade(trade);
		}
		
		return trade;
	}
	
	//구정연 구매기능 쿠폰 
	@Override
	public List<Coupon_history> selectCoupon(String id) 
	{
		return couponDao.selectCoupon(id);
	}

	@Override
	public void deleteCoupon(String his_no)
	{
		couponDao.deleteCoupon(his_no);
	}
		
}
