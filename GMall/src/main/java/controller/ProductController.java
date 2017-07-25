package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.Product;
import logic.ShopService;

@Controller
public class ProductController 
{
	@Autowired
	ShopService shopService;

	@RequestMapping("product/productAddForm")
	public ModelAndView productAddForm(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	//상품추가 폼이동
	@RequestMapping("product/addProduct")
	public ModelAndView addProduct()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject(new Product());
		return mav;
	}
	//고종환 상품 업데이트 
	@RequestMapping("product/productUpdate")
	public ModelAndView productupdate(Product product,BindingResult bindingResult, HttpServletRequest request,HttpSession session){
		ModelAndView mav=new ModelAndView("product/productAddForm");
		int pro_no = shopService.prono()+1;
		
		//Member member=(Member)request.getSession().getAttribute("LOGIN_MEMBER");
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");

        product.setPro_no(pro_no);	
        product.setBis_no("ABCDEF");
        product.setId(member.getId());


		shopService.ProductAdd(product,request);
		return mav;
	}
	//고종환 내 사업장 관리
	//product/myBusiness.mall
	@RequestMapping("product/myBusiness")
	public ModelAndView myBusinessList(){
		List<Product> myBis_list=shopService.getProductList();
		ModelAndView mav=new ModelAndView("product/myBusinessList");
		mav.addObject("myBis_list",myBis_list);
		return mav;
	}
	//고종환 내 사업장 관리에서 카테고리 클릭시
	@RequestMapping("product/categoryCheck")
	public ModelAndView categoryCheck(HttpServletRequest request){
		String category=request.getParameter("category");
		System.out.println(category);
		List<Product> myBis_list=shopService.categoryCheck(category);
		ModelAndView mav=new ModelAndView("product/myBusinessList");
		mav.addObject("myBis_list",myBis_list);
		return mav;
	}
	
	

}
