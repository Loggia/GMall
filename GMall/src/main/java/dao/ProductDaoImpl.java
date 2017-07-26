package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ProductMapper;
import dao.mapper.TradeMapper;
import logic.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession; 
	private final String NS = "dao.mapper.ProductMapper."; 

	@Override
	public int prono() {
		return sqlSession.getMapper(ProductMapper.class).prono();
	}

	@Override
	public void ProductAdd(Product product) {
		sqlSession.getMapper(ProductMapper.class).ProductAdd(product);
		
	}
	//고종환 내사업장 다뽑기
	@Override
	public List<Product> findAll(String id) {
		return sqlSession.getMapper(ProductMapper.class).findAll(id);
	}
	//고종환 내사업장 카테고리
	@Override
	public List<Product> categoryCheck(String id, String category) {
		System.out.println(id);
		System.out.println(category);
		Map<String,String> map=new HashMap<String,String>();
		map.put("id",id);
		map.put("category", category);
		
		return sqlSession.getMapper(ProductMapper.class).categoryCheck(map);
	}

	/*
	 * 주한울
	 * 관심 사업자 최근 등록 상품 조회
	 */
	@Override
	public List<Product> selectNewsFeed(String id) 
	{
		try
		{
			return sqlSession.getMapper(ProductMapper.class).newsFeed(id);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
			return null;
		}
	}
}
