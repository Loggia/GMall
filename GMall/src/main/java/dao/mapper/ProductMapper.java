package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Product;

public interface ProductMapper {

	@Select("select count(*) from product")
	int prono();

	@Insert("insert into product ( pro_no, bis_no, id, date, pro_name, price, cnt, category, favorite, pro_content,main_img,sub_img1,sub_img2,sub_img3 )"
	         +" values ( #{pro_no}, #{bis_no}, #{id}, now(), #{pro_name}, #{price}, #{cnt}, #{category}, #{favorite},#{pro_content},#{fileurl},#{fileurl1}, #{fileurl2}, #{fileurl3})")
	void ProductAdd(Product product);
	
	@Select("select * from product where id=#{id} order by pro_no")
	List<Product> findAll(String id);

	
	@Select("select * from product where id=#{id} and category=#{category} order by pro_no")
	List<Product> categoryCheck(Map<String, String> map);
	
	/*
	 * 주한울
	 * 회원이 등록한 관심사업자의 최근 등록 상품을 확인하기위한 쿼리
	 */
	@Select("select p.bis_name,p.pro_name,p.price,p.category,p.favorite,p.date from product p,bookmark b where p.bis_no=b.bis_no and b.id=#{id} and p.pro_no=(select max(p2.pro_no) from product p2 where p2.bis_no=p.bis_no) order by p.bis_no")
	List<Product> newsFeed(String id);	
}
