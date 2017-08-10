package dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.BookmarkMapper;

@Repository
public class BookmarkDaoImpl implements BookmarkDao
{
	@Autowired
	private SqlSessionTemplate sqlSession; 
	private final String NS = "dao.mapper.BookmarkMapper.";
	
	@Override
	public int bookmarkCount(String id)
	{
		return sqlSession.getMapper(BookmarkMapper.class).bookmarkCount(id);
	}
	
	@Override
	public boolean addBookmark(String id, String bis_no)
	{
		try
		{
			int maxCount = sqlSession.getMapper(BookmarkMapper.class).maxCount();
			
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("id", id);
			map.put("bis_no", bis_no);
			map.put("maxCount", maxCount);
			
			sqlSession.getMapper(BookmarkMapper.class).addBookmark(map);
			
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean deleteBookmark(String mark_no) 
	{
		try
		{
			sqlSession.getMapper(BookmarkMapper.class).deleteBookmark(mark_no);
			
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	} 
}
