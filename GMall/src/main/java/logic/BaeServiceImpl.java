package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import dao.MemberDao;

public class BaeServiceImpl implements BaeService{
	@Autowired
	BoardDao boardDao;
	@Autowired
	MemberDao memberDao;
	
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
		if(!board.getImg1().isEmpty())
		{
			uploadFileCreate(board.getImg1(), request);
		}
		if(!board.getImg2().isEmpty())
		{
			uploadFileCreate(board.getImg2(), request);
		}
		if(!board.getImg3().isEmpty())
		{
			uploadFileCreate(board.getImg3(), request);
		}
		boardDao.boardUpdate(board);	
	}

	
	
}
