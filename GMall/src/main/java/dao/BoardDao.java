package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import logic.Board;
import logic.Product;
import logic.Trade;

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
	int getMaxNum();
	void centerInsert(Board board);
	Board passthrough(String num);
	Board getBoard(int num);
	String getBoardPassword(int board_no);
	void boardUpdate(Board board);
	void boardDelete(int num);
	void boardAnswer(Board board);
	
	int qnaCount(String searchType, String searchContent, String pro_no);
	List<Board> qnaList(String searchType, String searchContent, Integer pageNum, int limit, String pro_no);
	Board qnapassthrough(String num);
	void qnaInsert(Board board);
	void qnaUpdate(Board board);
	int reCount(String pro_no);
	List<Board> reList(Integer pageNum, int limit, String pro_no);
	void reviewInsert(Board board);
	Trade checkUser(String userid, String pro_no);
	void reviewUpdate(Board board);
	Product proInfo(String pro_no);
	List<Product> interList(String inter);
	List<Product> popuList();
	List<Product> newList();
	List<Product> primList();


	
}