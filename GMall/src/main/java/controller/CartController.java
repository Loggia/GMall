package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Cart;
import logic.KuService;
import logic.Product;
import logic.ProductSet;

@Controller
public class CartController 
{
	@Autowired 
	public KuService kuService;
	
	@RequestMapping("board/cartAdd")
	public ModelAndView cartAdd(Integer pro_no, Integer quantity , HttpSession session){
		Product selectedproduct = kuService.getproductByNo(pro_no);
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		
		if(cart == null) {
			cart = kuService.getCart();
			session.setAttribute("CART_KEY", cart);
		}
		System.out.println(quantity);
		cart.push(new ProductSet(selectedproduct , quantity));
		ModelAndView mav = new ModelAndView("board/cart");
		mav.addObject("cart" , cart);
		return mav;
	}
}
