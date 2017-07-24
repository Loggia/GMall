package controller;

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
	
	@RequestMapping("product/addProduct")
	public ModelAndView addProduct()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject(new Product());
		return mav;
	}
	//productupdate 
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
	
	

}
