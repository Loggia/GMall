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
	

	
	
		
}
