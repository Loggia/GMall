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
	public List<Product> findAll(String Bis_no) {
		return sqlSession.getMapper(ProductMapper.class).findAll(Bis_no);
	}
	//고종환 내사업장 카테고리
	@Override
	public List<Product> categoryCheck(String bis_name, String category) {
	
		Map<String,String> map=new HashMap<String,String>();
		map.put("bis_name",bis_name);
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

	@Override
	public List<Product> findAll(String bis_no, String category) {
		Map map = new HashMap();
		map.put("bis_no", bis_no);
		map.put("category", category);
		return sqlSession.getMapper(ProductMapper.class).categoryCheck(map);
	}
	/*
	 * 구정연 
	 * 장바구니
	 */
	@Override
	public Product getproductByNo(Integer pro_no) {
		
		return sqlSession.getMapper(ProductMapper.class).getproductByNo(pro_no);
	}
}
