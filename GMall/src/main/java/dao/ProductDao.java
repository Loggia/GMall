package dao;

import java.util.List;

import logic.Product;

public interface ProductDao {

	int prono();

	void ProductAdd(Product product);
	
	List<Product> findAll(); //내 사업장 다 뽑기

	List<Product> categoryCheck(String category);//나사업장 카테고리 분류

}
