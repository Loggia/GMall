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
	
	@RequestMapping("board/cart")
	public ModelAndView cart(HttpSession session)
	{
		return cartAdd(null, null, session);
	}
	
	@RequestMapping("board/cartAdd")
	public ModelAndView cartAdd(Integer pro_no, Integer quantity , HttpSession session)
	{
		ModelAndView mav = new ModelAndView("board/cart");
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		Product selectedProduct;
		
		if(cart == null) 
		{
			cart = new Cart();
			session.setAttribute("CART_KEY", cart);
		}
		
		if(pro_no != null)
		{
			selectedProduct = kuService.getproductByNo(pro_no);
			cart.push(new ProductSet(selectedProduct , quantity));
			
			mav.setViewName("success");
			mav.addObject("url", "../board/cart.mall");
			mav.addObject("msg", "장바구니에 상품이 추가되었습니다.");
		}
		else
		{
			for(ProductSet p : cart.getProductList())
			{
				p.setProduct(kuService.getproductByNo(p.getProduct().getPro_no()));
			}
		}
		
		mav.addObject("cart" , cart);
		return mav;
	}
	
	@RequestMapping("board/cartDelete")
	public ModelAndView cartDel(int index, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("board/cart");
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		String name = cart.remove(index);
		
		mav.addObject("cart" , cart);
		
		return mav;
	}
}
