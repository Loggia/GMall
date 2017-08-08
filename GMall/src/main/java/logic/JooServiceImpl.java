package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
public class JooServiceImpl implements JooService
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
	 * 주한울
	 * 회원가입
	 */
	@Override
	public void insertMember(Member member) 
	{
		memberDao.insert(member);
	}
	
	/*
	 * 주한울
	 * 사업자 회원가입 시 쿠폰 자동 생성
	 */
	@Override
	public void insertCoupon(String bis_no, String id)
	{
		couponDao.insert(bis_no, id);
	}
	
	/*
	 * 주한울
	 * 회원가입시 중복된 사업자 번호를 사용했는지를 판별
	 */
	@Override
	public boolean cheakMember(String bis_no) 
	{
		return memberDao.cheakMember(bis_no);
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
	public void updateMember(Member member, HttpServletRequest request) 
	{
		if(member.getPictureFile() != null)
		{
			member.setPicture(pictureInsert(member.getId(), member.getPictureFile(), request));
		}
		else
		{
			member.setPicture("");
		}
		
		memberDao.update(member);
	}
	
	/*
	 * 주한울 
	 * 프로필 사진 추가 
	 */
	private String pictureInsert(String id, MultipartFile pictureFile, HttpServletRequest request) 
	{
		String uploadPath = request.getServletContext().getRealPath("/") + "/prof/";
		String url = uploadPath + id + "PictureImg";
		FileOutputStream fos = null;
		
		try
		{
			fos = new FileOutputStream(url);
			InputStream in = pictureFile.getInputStream();
			
			int data;
			byte[] buf = new byte[in.available()];
			
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
		
		return id + "PictureImg";
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
	 * 주한울
	 * 관심 사업자 조회
	 */
	@Override
	public List<Member> selectBookmark(String id) 
	{
		return memberDao.selectBookmark(id);
	}

	/*
	 * 주한울
	 * 관심 사업자 최근 등록 상품 조회
	 */
	@Override
	public List<Product> selectNewsFeed(String id) 
	{
		return productDao.selectNewsFeed(id);
	}
	
	/*
	 * 주한울
	 * 일반 회원 구매 목록 확인
	 */
	@Override
	public List<Trade> tradeList(String id, Integer type, Integer pageNum, Integer limit) 
	{
		return tradeDao.tradeList(id, type, pageNum, limit);
	}
	
	/*
	 * 주한울
	 * 일반 회원 배송 조회
	 */
	@Override
	public List<Trade> delvpageBuyList(String id) 
	{
		return tradeDao.delvpageBuyList(id);
	}
	
	/*
	 * 주한울
	 * 일반회원 쿠폰목록 (사용 안함)
	 */
	@Override
	public List<Coupon_history> memberCoupon(String id) 
	{
		return tradeDao.memberCoupon(id);
	}
	
	// 쿠폰 목록 조회
	@Override
	public List<Coupon_history> couponList(String id, int type, String discount, Integer pageNum, int limit)
	{
		return tradeDao.couponList(id, type, discount, pageNum, limit);
	}
	
	/*
	 * 주한울
	 * 일반회원 쿠폰목록 카테고리 선택시
	 */
	@Override
	public List<Coupon_history> memberDiscountCheck(String id, String discount) 
	{
		return tradeDao.memberDiscountCheck(id,discount);
	}
	
	@Override
	public Member getUserById(String id) 
	{
		return memberDao.getUserById(id);
	}

	@Override
	public int tradeCount(String id, int type) 
	{
		return tradeDao.tradeCount(id, type);
	}

	@Override
	public int delvpageCount(String id, int type) 
	{
		return tradeDao.delvpageCount(id, type);
	}

	@Override
	public int moneyChangeCount(String id, int type) 
	{
		return tradeDao.moneyChangeCount(id, type);
	}
	
	@Override
	public int couponCount(String id, int type) 
	{
		return tradeDao.couponCount(id, type);
	}
}
