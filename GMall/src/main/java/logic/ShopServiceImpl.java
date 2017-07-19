package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;

import dao.BoardDao;
import dao.MemberDao;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	BoardDao boardDao;
	@Autowired
	MemberDao memberDao;
	
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
		try
		{
			String path = request.getServletContext().getRealPath("/") + "/jsp/board/picture/";
			int num = boardDao.getMaxNum();
			MultipartRequest multi = new MultipartRequest(request, path, 5*1024*1024, "euc-kr");
			board.setImg1(multi.getFilesystemName("img1"));
			board.setImg2(multi.getFilesystemName("img2"));
			board.setImg3(multi.getFilesystemName("img3"));
			board.setBoard_type(1);
			board.setNum(++num);
			board.setRef(num);
			board.setReflevel(0);
			board.setRefstep(0);
			boardDao.centerInsert(board);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
}