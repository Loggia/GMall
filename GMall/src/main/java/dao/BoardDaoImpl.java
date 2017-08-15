package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.BoardDao;
import dao.mapper.BoardMapper;
import logic.Board;
import logic.Member;
import logic.Product;
import logic.Trade;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sqlSession; 
	private final String NS = "dao.mapper.BoardMapper."; 
	
	@Override
	public List<Product> proList(String category, String group, String searchType, String searchContent, Integer pageNum, int limit) {
		int startrow = (pageNum - 1) * limit;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("category", category);
    	paramMap.put("group", group);
		paramMap.put("startrow", startrow);
    	paramMap.put("searchType", searchType);
    	paramMap.put("searchContent", searchContent);
    	return sqlSession.selectList(NS+"proList", paramMap);
	}
	
	@Override
	public int proCount(String searchType, String searchContent, String category) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("searchType", searchType);
    	paramMap.put("searchContent", searchContent);
    	paramMap.put("category", category);
    	return sqlSession.selectOne(NS+"proCount", paramMap);
	}
	
	@Override
	public List<Product> totalList(String searchType, String searchContent, Integer pageNum, int limit) {
		int startrow = (pageNum - 1) * limit;	
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(searchContent == "")
		{
			searchContent = "notval";
		}
		paramMap.put("startrow", startrow);
    	paramMap.put("searchType", searchType);
    	paramMap.put("searchContent", searchContent);
    	return sqlSession.selectList(NS+"totalList", paramMap);
	}
	
	@Override
	public int totalCount(String searchType, String searchContent) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(searchContent == "")
		{
			searchContent = "notval";
		}
    	paramMap.put("searchType", searchType);
    	paramMap.put("searchContent", searchContent);
    	return sqlSession.selectOne(NS+"totalCount", paramMap);
	}

	@Override
	public int centerCount(String searchType, String searchContent) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchType", searchType);
		paramMap.put("searchContent", searchContent);
		return sqlSession.selectOne(NS+"centerCount", paramMap);
	}
	
	@Override
	public List<Board> centerList(String searchType, String searchContent, Integer pageNum, int limit) {
		int startrow = (pageNum - 1) * limit;
    	int endrow = startrow + limit;  	
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("startrow", startrow);
    	paramMap.put("endrow", endrow);
    	paramMap.put("searchType", searchType);
    	paramMap.put("searchContent", searchContent);
    	return sqlSession.selectList(NS+"centerList", paramMap);
	}

	@Override
	public int getMaxNum() {
		return sqlSession.getMapper(BoardMapper.class).getMaxNum();
	}

	@Override
	public void centerInsert(Board board) {
		sqlSession.getMapper(BoardMapper.class).centerInsert(board);
	}

	@Override
	public Board passthrough(String num) {
		/*Map<String, String> paramMap = new HashMap<String, String>();
    	paramMap.put("num", num);*/
    	return sqlSession.getMapper(BoardMapper.class).passthrough(num);
	}

	@Override
	public Board getBoard(int num) {
    	return sqlSession.getMapper(BoardMapper.class).getBoard(num);
	}

	@Override
	public String getBoardPassword(int board_no) {
		return sqlSession.getMapper(BoardMapper.class).getBoardPassword(board_no);
	}

	@Override
	public void boardUpdate(Board board) {
		sqlSession.getMapper(BoardMapper.class).boardUpdate(board);
	}

	@Override
	public void boardDelete(int num) {
		sqlSession.getMapper(BoardMapper.class).boardDelete(num);
	}

	@Override
	public void boardAnswer(Board board) {
		sqlSession.getMapper(BoardMapper.class).boardAnswer(board);
	}

	@Override
	public int qnaCount(String searchType, String searchContent, String pro_no) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchType", searchType);
		paramMap.put("searchContent", searchContent);
		paramMap.put("pro_no", pro_no);
		return sqlSession.selectOne(NS+"qnaCount", paramMap);
	}

	@Override
	public List<Board> qnaList(String searchType, String searchContent, Integer pageNum, int limit, String pro_no) {
		int startrow = (pageNum - 1) * limit;
    	int endrow = startrow + limit;  	
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("startrow", startrow);
    	paramMap.put("endrow", endrow);
    	paramMap.put("searchType", searchType);
    	paramMap.put("searchContent", searchContent);
    	paramMap.put("pro_no", pro_no);    	
    	return sqlSession.selectList(NS+"qnaList", paramMap);
	}

	@Override
	public Board qnapassthrough(String num) {
		return sqlSession.getMapper(BoardMapper.class).qnapassthrough(num);
	}

	@Override
	public void qnaInsert(Board board) {
		sqlSession.getMapper(BoardMapper.class).qnaInsert(board);	
	}

	@Override
	public void qnaUpdate(Board board) {
		sqlSession.getMapper(BoardMapper.class).qnaUpdate(board);
	}

	@Override
	public int reCount(String pro_no) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("pro_no", pro_no);
		return sqlSession.selectOne(NS+"reCount", paramMap);
	}

	@Override
	public List<Board> reList(Integer pageNum, int limit, String pro_no) {
		int startrow = (pageNum - 1) * limit;
    	int endrow = startrow + limit;  	
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("startrow", startrow);
    	paramMap.put("endrow", endrow);
    	paramMap.put("pro_no", pro_no);    	
    	return sqlSession.selectList(NS+"reList", paramMap);
	}

	@Override
	public void reviewInsert(Board board) {
		sqlSession.getMapper(BoardMapper.class).reviewInsert(board);
	}

	@Override
	public List<Trade> checkUser(String userid, String pro_no) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("pro_no", pro_no);
		return sqlSession.selectList(NS+"checkUser", paramMap);
	}

	@Override
	public void reviewUpdate(Board board) {
		sqlSession.getMapper(BoardMapper.class).reviewUpdate(board);
	}

	@Override
	public Product proInfo(String pro_no) {
		return sqlSession.getMapper(BoardMapper.class).proInfo(pro_no);
	}
	
	@Override
	public void rvchkUpdate(String userid, String pro_no) {	
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("pro_no", pro_no);
		sqlSession.getMapper(BoardMapper.class).rvchkUpdate(paramMap);
	}
	
	@Override
	public List<Trade> sellInfo(String pro_no) {
		return sqlSession.getMapper(BoardMapper.class).sellInfo(pro_no);
	}
	
	@Override
	public void memGrade(String sellid, int grade, int memberScore) {
		int realGrade = grade + memberScore;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sellid", sellid);
		paramMap.put("realGrade", realGrade);
		sqlSession.getMapper(BoardMapper.class).memGrade(paramMap);
	}
	
	@Override
	public Member sellScore(String sellid) {
		return sqlSession.getMapper(BoardMapper.class).sellScore(sellid);
	}
	
	@Override
	public List<Trade> protrInfo(String pro_no) {
		return sqlSession.getMapper(BoardMapper.class).protrInfo(pro_no);
	}
	
	@Override
	public Member sessionType(String userid) {
		return sqlSession.getMapper(BoardMapper.class).sessionType(userid);
	}
	
	@Override
	public Product proBis(String bisname, String pro_no) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("bisname", bisname);
    	paramMap.put("prono", pro_no);
		return sqlSession.selectOne(NS+"proBis", paramMap);
	}
	
	@Override
	public List<Product> favorPrice(String favor) {
		return sqlSession.getMapper(BoardMapper.class).favorPrice(favor);
	}

	@Override
	public List<Product> interList(String inter) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("inter", inter);
    	return sqlSession.selectList(NS+"inter", paramMap);
	}

	@Override
	public List<Product> popuList() {
		return sqlSession.getMapper(BoardMapper.class).popuList();
	}

	@Override
	public List<Product> newList() {
		return sqlSession.getMapper(BoardMapper.class).newList();
	}

	@Override
	public List<Product> primList(String id) {
		return sqlSession.getMapper(BoardMapper.class).primList(id);
	}

	@Override
	public String primGetId1() {
		return sqlSession.getMapper(BoardMapper.class).primGetId1();
	}

	@Override
	public String primGetId2() {
		return sqlSession.getMapper(BoardMapper.class).primGetId2();
	}

	@Override
	public String primGetId3() {
		return sqlSession.getMapper(BoardMapper.class).primGetId3();
	}

	@Override
	public String primGetId4() {
		return sqlSession.getMapper(BoardMapper.class).primGetId4();
	}

	@Override
	public Product prim(String id) {
		return sqlSession.getMapper(BoardMapper.class).prim(id);
	}
	
}