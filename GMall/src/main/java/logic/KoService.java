package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface KoService { 
	
	//종환이꺼

	void ProductAdd(Product product, HttpServletRequest request);//고종환 사업자 물품등록
	int prono();//고종환 -물품번호
	List<Product> getProductList(String Bis_no);//고종환 내 사업장 관리
	List<Product> categoryCheck(String bis_name, String category);//고종환 내사업장 카테고리분류
	List<Trade> tradeList(String id);//고종환 사업자 거래목록
	List<Trade> deliveryList(String id);//고종환 사업자 배송 조회
	List<Coupon_history> bisCoupon(String id);//고종환 사업자 쿠폰목록
	List<Coupon_history> bisDiscountCheck(String id, String discount);//고종환 사업자 쿠폰관리 선택시
	String tradeCheck(String trd_no);//고종환 사업자 배송현황 변경위한 쿼리
	void deliveryControl(String trd_no, String tradeCheck);//고종환 사업자 배송현황 변경

}