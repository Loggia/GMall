package dao;

import java.util.List;

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
	private final String NS = "dao.mapper.TradeMapper."; 

	@Override
	public int prono() {
		return sqlSession.getMapper(ProductMapper.class).prono();
	}

	@Override
	public void ProductAdd(Product product) {
		sqlSession.getMapper(ProductMapper.class).ProductAdd(product);
		
	}
	
	@Override
	public List<Product> findAll() {//고종환 내사업장 다뽑기
		return sqlSession.selectList(NS+"getProductList");
	}

	@Override
	public List<Product> categoryCheck(String category) {//고종환 나사업장 카테고리 분류
		return sqlSession.getMapper(ProductMapper.class).categoryCheck(category);
	}

}
