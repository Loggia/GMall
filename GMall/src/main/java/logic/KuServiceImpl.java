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
}
