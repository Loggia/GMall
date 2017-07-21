package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import logic.Board;

public interface BoardDao {
	List<Board> infiniteScrollDown(int numToStart);
	List<Board> infiniteScrollUp(int numToEnd);
	List<Board> proList();
	int centerCount();
	List<Board> centerList(Integer pageNum, int limit);
	int getMaxNum(int typenum);
	void centerInsert(Board board);
	
	
}