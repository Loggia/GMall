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

@Service
public class BaeServiceImpl implements BaeService{
	@Autowired
	BoardDao boardDao;
	
	/*
	   배기수 
	*/
	
	/*
	 상품 목록을 보여줌 
	*/
	@Override
	public List<Product> proList(String category, String group, String searchType, String searchContent, Integer pageNum, int limit) {
		return boardDao.proList(category, group, searchType, searchContent, pageNum, limit);
	}
	
	/*
	 해당 상품의 갯수를 가져옴 
	*/
	@Override
	public int proCount(String searchType, String searchContent, String category) {
		return boardDao.proCount(searchType, searchContent, category);
	}
	
	/*
	 상품 목록을 보여줌 
	*/
	@Override
	public List<Product> totalList(String searchType, String searchContent, Integer pageNum, int limit) {
		return boardDao.totalList(searchType, searchContent, pageNum, limit);
	}
	
	/*
	 해당 상품의 갯수를 가져옴 
	*/
	@Override
	public int totalCount(String searchType, String searchContent) {
		return boardDao.totalCount(searchType, searchContent);
	}
	
	/*
	 고객센터에서 검색된 내용을 가져옴 
	*/
	@Override
	public int centerCount(String searchType, String searchContent) {
		return boardDao.centerCount(searchType, searchContent);
	}
	
	/*
	 고객센터 글 목록 가져옴 
	*/
	@Override
	public List<Board> centerList(String searchType, String searchContent, Integer pageNum, int limit) {
		return boardDao.centerList(searchType, searchContent, pageNum, limit);
	}

	/*
	 고객센터 글 작성
	*/
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
		int num = boardDao.getMaxNum();
		board.setBoard_no(++num);
		boardDao.centerInsert(board);	
	}	
	
	/*
	 파일 업로드 
	*/
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
	  글번호에 해당하는 정보를 가져옴 
	*/
	@Override
	public Board passthrough(String num) {
		return boardDao.passthrough(num);
	}
	
	/*
	 글번호에 해당하는 글을 가져옴
	*/
	@Override
	public Board getBoard(int num) {
		return boardDao.getBoard(num);
	}
	
	/*
	  글번호에 해당하는 비밀번호를 가져옴 
	*/
	@Override
	public String getBoardPassword(int board_no) {
		return boardDao.getBoardPassword(board_no);
	}
	
	/*
	  글 업데이트 기능
	*/
	@Override
	public void boardUpdate(Board board, HttpServletRequest request) {
		if(board.getImg1() != null)
		{
			uploadFileCreate(board.getImg1(), request);
		}
		if(board.getImg2() != null)
		{
			uploadFileCreate(board.getImg2(), request);
		}
		if(board.getImg3() != null)
		{
			uploadFileCreate(board.getImg3(), request);
		}
		boardDao.boardUpdate(board);	
	}
	
	/*
	  글 삭제 기능
	*/
	@Override
	public void boardDelete(int num) {	
		boardDao.boardDelete(num);
	}
	
	/*
	  답변기능  
	*/
	@Override
	public void boardAnswer(Board board, HttpServletRequest request) {
		board.setAns_chk(1);
		boardDao.boardAnswer(board);	
	}

	/*
	 qna에서 검색된 내용 가져옴 
	*/
	@Override
	public int qnaCount(String searchType, String searchContent, String pro_no) {
		return boardDao.qnaCount(searchType, searchContent, pro_no);
	}

	@Override
	public List<Board> qnaList(String searchType, String searchContent, Integer pageNum, int limit, String pro_no) {
		return boardDao.qnaList(searchType, searchContent, pageNum, limit, pro_no);
	}

	@Override
	public Board qnapassthrough(String num) {
		return boardDao.qnapassthrough(num);
	}

	@Override
	public void qnaInsert(Board board, HttpServletRequest request) {
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
		board.setBoard_type(2); 
		board.setAns_chk(0);
		int num = boardDao.getMaxNum();
		board.setBoard_no(++num);
		boardDao.qnaInsert(board);
	}

	@Override
	public void qnaUpdate(Board board, HttpServletRequest request) {
		if(board.getImg1() != null)
		{
			uploadFileCreate(board.getImg1(), request);
		}
		if(board.getImg2() != null)
		{
			uploadFileCreate(board.getImg2(), request);
		}
		if(board.getImg3() != null)
		{
			uploadFileCreate(board.getImg3(), request);
		}
		boardDao.qnaUpdate(board);
	}

	@Override
	public int reCount(String pro_no) {
		return boardDao.reCount(pro_no);
	}

	@Override
	public List<Board> reList(Integer pageNum, int limit, String pro_no) {
		return boardDao.reList(pageNum, limit, pro_no);
	}

	@Override
	public void reviewInsert(Board board, String userid, String pro_no, HttpServletRequest request) {
		board.setBoard_type(3); 
		int num = boardDao.getMaxNum();
		board.setBoard_no(++num);
		boardDao.rvchkUpdate(userid, pro_no);
		boardDao.reviewInsert(board);
	}

	@Override
	public Trade checkUser(String userid, String pro_no) {
		return boardDao.checkUser(userid, pro_no);
	}

	@Override
	public void reviewUpdate(Board board, HttpServletRequest request) {
		boardDao.reviewUpdate(board);
	}

	@Override
	public Product proInfo(String pro_no) {
		return boardDao.proInfo(pro_no);
	}

	@Override
	public List<Trade> sellInfo(String pro_no) {
		return boardDao.sellInfo(pro_no);
	}

	@Override
	public void memGrade(String sellid, int grade, int memberScore) {
		boardDao.memGrade(sellid, grade, memberScore);
	}

	@Override
	public Member sellScore(String sellid) {
		return boardDao.sellScore(sellid);
	}

	@Override
	public List<Trade> protrInfo(String pro_no) {
		return boardDao.protrInfo(pro_no);
	}

	@Override
	public Member sessionType(String userid) {
		return boardDao.sessionType(userid);
	}

	@Override
	public Product proBis(String bisname, String pro_no) {
		return boardDao.proBis(bisname, pro_no);
	}

	@Override
	public List<Product> favorPrice(String favor) {
		return boardDao.favorPrice(favor);
	}
	
	
	
	
	
}