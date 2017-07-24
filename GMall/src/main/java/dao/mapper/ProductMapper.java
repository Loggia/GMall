package dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Product;

public interface ProductMapper {

	@Select("select count(*) from product")
	int prono();

	@Insert("insert into product ( pro_no, bis_no, id, date, pro_name, price, cnt, category, favorite, pro_content,main_img,sub_img1,sub_img2,sub_img3 )"
	         +" values ( #{pro_no}, #{bis_no}, #{id}, now(), #{pro_name}, #{price}, #{cnt}, #{category}, #{favorite},#{pro_content},#{fileurl},#{fileurl1}, #{fileurl2}, #{fileurl3})")
	void ProductAdd(Product product);

	
	
		
}
