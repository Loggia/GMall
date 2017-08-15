package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import logic.Board;
import logic.Member;
import logic.Product;
import logic.Trade;

public interface BoardDao {
	List<Product> proList(String category, String group, String searchType, String searchContent, Integer pageNum, int limit);
	int proCount(String searchType, String searchContent, String category);
	List<Product> totalList(String searchType, String searchContent, Integer pageNum, int limit);
	int totalCount(String searchType, String searchContent);
	
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
	List<Trade> checkUser(String userid, String pro_no);
	void reviewUpdate(Board board);
	Product proInfo(String pro_no);
	void rvchkUpdate(String userid, String pro_no);
	List<Trade> sellInfo(String pro_no);
	void memGrade(String sellid, int grade, int memberScore);
	Member sellScore(String sellid);
	List<Trade> protrInfo(String pro_no);
	Member sessionType(String userid);
	Product proBis(String bisname, String pro_no);
	List<Product> favorPrice(String favor);
	
	List<Product> interList(String inter);
	List<Product> popuList();
	List<Product> newList();
	List<Product> primList(String id);
	String primGetId1();
	String primGetId2();
	String primGetId3();
	String primGetId4();
	
}