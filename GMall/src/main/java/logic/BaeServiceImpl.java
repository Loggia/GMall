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
	@Override
	public List<Product> infiniteScrollDown(int numToStart, String category) {
		return boardDao.infiniteScrollDown(numToStart, category);
	}

	@Override
	public List<Product> infiniteScrollUp(int numToEnd, String category) {
		return boardDao.infiniteScrollUp(numToEnd, category);
	}
	
	@Override
	public List<Product> priminfiniteScrollDown(int numToStart, String category) {
		return boardDao.priminfiniteScrollDown(numToStart, category);
	}

	@Override
	public List<Product> priminfiniteScrollUp(int numToEnd, String category) {
		return boardDao.priminfiniteScrollUp(numToEnd, category);
	}
	
	@Override
	public List<Product> highinfiniteScrollDown(int priceStart, String category) {
		return boardDao.highinfiniteScrollDown(priceStart, category);
	}

	@Override
	public List<Product> highinfiniteScrollUp(int priceEnd, String category) {
		return boardDao.highinfiniteScrollUp(priceEnd, category);
	}

	@Override
	public List<Product> lowinfiniteScrollDown(int priceStart, String category) {
		return boardDao.lowinfiniteScrollDown(priceStart, category);
	}

	@Override
	public List<Product> lowinfiniteScrollUp(int priceEnd, String category) {
		return boardDao.lowinfiniteScrollUp(priceEnd, category);
	}


	@Override
	public List<Product> proList(String category) {
		return boardDao.proList(category);
	}
	
	@Override
	public List<Product> premiumList(String category) {
		return boardDao.premiumList(category);
	}
	
	@Override
	public List<Product> highPriceList(String category) {
		return boardDao.highPriceList(category);
	}
	
	@Override
	public List<Product> lowPriceList(String category) {
		return boardDao.lowPriceList(category);
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
	  배기수 - 글번호에 해당하는 정보를 가져옴 
	*/
	@Override
	public Board passthrough(String num) {
		return boardDao.passthrough(num);
	}
	
	/*
	 배기수 - 글번호에 해당하는 글을 가져옴
	*/
	@Override
	public Board getBoard(int num) {
		return boardDao.getBoard(num);
	}
	
	/*
	  배기수 - 글번호에 해당하는 비밀번호를 가져옴 
	*/
	@Override
	public String getBoardPassword(int board_no) {
		return boardDao.getBoardPassword(board_no);
	}
	
	/*
	  배기수 - 글 업데이트 기능
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
	  배기수 - 글 삭제 기능
	*/
	@Override
	public void boardDelete(int num) {	
		boardDao.boardDelete(num);
	}
	
	/*
	  배기수 - 답변기능  
	*/
	@Override
	public void boardAnswer(Board board, HttpServletRequest request) {
		board.setAns_chk(1);
		boardDao.boardAnswer(board);	
	}

	
	
}
