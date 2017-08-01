package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import logic.Board;
import logic.Product;

public interface BoardDao {
	List<Product> infiniteScrollDown(int numToStart, String category);
	List<Product> infiniteScrollUp(int numToEnd, String category);
	List<Product> priminfiniteScrollDown(int numToStart, String category);
	List<Product> priminfiniteScrollUp(int numToEnd, String category);
	List<Product> highinfiniteScrollDown(int priceStart, String category);
	List<Product> highinfiniteScrollUp(int priceEnd, String category);
	List<Product> lowinfiniteScrollDown(int priceStart, String category);
	List<Product> lowinfiniteScrollUp(int priceEnd, String category);
	List<Product> proList(String category);
	List<Product> premiumList(String category);
	List<Product> highPriceList(String category);
	List<Product> lowPriceList(String category);
	
	int centerCount(String searchType, String searchContent);
	List<Board> centerList(String searchType, String searchContent, Integer pageNum, int limit);
	int getMaxNum(int typenum);
	void centerInsert(Board board);
	Board passthrough(String num);
	Board getBoard(int num);
	String getBoardPassword(int board_no);
	void boardUpdate(Board board);
	void boardDelete(int num);
	void boardAnswer(Board board);

	
	
}