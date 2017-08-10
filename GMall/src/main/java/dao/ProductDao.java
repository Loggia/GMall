package dao;

import java.util.List;

import logic.Product;

public interface ProductDao {

	int prono();

	void ProductAdd(Product product);
	
	List<Product> findAll(String Bis_no); //고종환 내 사업장 다 뽑기

	List<Product> categoryCheck(String bis_name, String category);//고종환 내사업장 카테고리

	List<Product> selectNewsFeed(String id); // 주한울 - 관심 사업자 최근 등록 목록 조회

	List<Product> findAll(String bis_no, String category);

	Product getproductByNo(Integer pro_no); // 구정연 상품리스트 출력 (장바구니)

	int productCount(String bis_no, String category); // 고종환 내 사업장 관리 카운팅
	List<Product> productList(String bis_no, String category, Integer pageNum, int limit); // 고종환 내 사업장 관리 조회

	String getBis_no(String pro_no); // 상품번호로 bis_no 리턴
	
	void productDelete(String pro_no);//고종환 상품삭제하기
}
