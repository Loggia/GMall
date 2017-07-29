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
import dao.MemberDao;
import dao.ProductDao;
import dao.TradeDao;

@Service
public class JooServiceImp implements JooService
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
	public List<Trade> tradeBuyList(String id) 
	{
		return tradeDao.tradeBuyList(id);
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
	 * 일반회원 쿠폰목록
	 */
	@Override
	public List<Coupon_history> memberCoupon(String id) 
	{
		return tradeDao.memberCoupon(id);
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
	
	/*
	 * 주한울
	 * 주한울 일반회원, 사업자 보유금액(금액 변동) 
	 */
	@Override
	public List<Trade> moneyChangeList(Member member) 
	{
		return tradeDao.moneyChangeList(member);
	}
	
	@Override
	public Member getUserById(String id) 
	{
		return memberDao.getUserById(id);
	}
}
