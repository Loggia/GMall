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

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sqlSession; 
	private final String NS = "dao.mapper.BoardMapper."; 
	
	@Override
	public List<Board> infiniteScrollDown(int numToStart) {
		return sqlSession.selectList(NS+"infiniteScrollDown");
	}

	@Override
	public List<Board> infiniteScrollUp(int numToEnd) {
		return sqlSession.selectList(NS+"infiniteScrollUp");
	}
	
	@Override
	public List<Board> proList() {
    	return sqlSession.selectList(NS+"proList");
	}
	
	@Override
	public int centerCount(String searchType, String searchContent) {
		return sqlSession.selectOne(NS+"customerCount");
	}
	
	@Override
	public List<Board> centerList(String searchType, String searchContent, Integer pageNum, int limit) {
		int startrow = (pageNum - 1) * limit + 1;
    	int endrow = startrow + limit - 1;
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

	
	
	
	
}