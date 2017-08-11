package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Product;

public interface ProductMapper {

	@Select("select max(pro_no) from product")
	int prono();

	@Insert("insert into product ( pro_no, bis_no, bis_name, date, pro_name, price, cnt, category, favorite, pro_content,main_img,sub_img1,sub_img2,sub_img3 )"
	         +" values ( #{pro_no}, #{bis_no}, #{bis_name}, now(), #{pro_name}, #{price}, #{cnt}, #{category}, #{favorite},#{pro_content},#{fileurl},#{fileurl1}, #{fileurl2}, #{fileurl3})")
	void ProductAdd(Product product);
	
	@Select("select * from product where Bis_no=#{Bis_no} order by pro_no")
	List<Product> findAll(String Bis_no);

	
	@Select("select *, DATE_FORMAT(date, '%Y-%m-%e') as date2 from product where bis_name=#{bis_name} and category=#{category} order by pro_no")
	List<Product> categoryCheck(Map<String, String> map);
	
	/*
	 * 주한울
	 * 회원이 등록한 관심사업자의 최근 등록 상품을 확인하기위한 쿼리
	 */
	@Select("select p.bis_name,p.pro_name,p.price,p.category,p.favorite,p.date from product p,bookmark b where p.bis_no=b.bis_no and b.id=#{id} and p.pro_no=(select max(p2.pro_no) from product p2 where p2.bis_no=p.bis_no) order by p.bis_no")
	List<Product> newsFeed(String id);

	@Select("select pro_no, bis_no,bis_name, date, pro_name, price, cnt, category, favorite, pro_content, main_img fileurl, sub_img1 fileurl1, sub_img2 fileurl2, sub_img3 fileurl3 from product where pro_no = #{pro_no}")
	Product getproductByNo(Integer pro_no); // 구정연 상품리스트전부 출력(장바구니)

	// 상품 번호로 bis_no 값 쿼리
	@Select("select bis_no from product where pro_no = #{pro_no}")
	String getBis_no(String pro_no);
	
	//고종환 상품 삭제하기
	@Delete("delete from product where pro_no=#{pro_no}")
	void productDelete(String pro_no);



}
