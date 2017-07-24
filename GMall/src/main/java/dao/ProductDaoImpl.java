package dao;

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

}
