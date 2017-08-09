package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
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
	 * 구정연 장바구니
	 */
	@Override
	public Cart getCart() {
		
		return new Cart();
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
}
