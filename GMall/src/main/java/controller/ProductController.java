package controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.Product;
import logic.ShopService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class ProductController 
{
	@Autowired
	ShopService shopService;

	//상품추가 폼이동 
	@RequestMapping("product/addProduct")
	public ModelAndView addProduct(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		mav.addObject("member",member);
		mav.addObject(new Product());
		return mav;
	}
	//고종환 상품 업데이트 
	@RequestMapping("product/productUpdate")
	public ModelAndView productupdate(Product product,BindingResult bindingResult, HttpServletRequest request,HttpSession session){
		ModelAndView mav=new ModelAndView("member/mypage");
		int pro_no = shopService.prono()+1;
		
		//Member member=(Member)request.getSession().getAttribute("LOGIN_MEMBER");
		Member login=(Member)session.getAttribute("LOGIN_MEMBER");

        product.setPro_no(pro_no);	
        product.setBis_no(login.getBis_no());
        product.setBis_name(login.getBis_name());
		shopService.ProductAdd(product,request);
		List<Product> myBis_list=shopService.getProductList(login.getBis_no());//내아이디만
		mav.addObject("myBis_list",myBis_list);
		mav.addObject("member",login);
		
		return mav;
	}

	//고종환 내 사업장 관리에서 카테고리 클릭시
	@RequestMapping("member/categoryCheck")
	public ModelAndView categoryCheck(HttpSession session,HttpServletRequest request){
		String category=request.getParameter("category");
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String bis_name=member.getBis_name();
		
		List<Product> myBis_list=shopService.categoryCheck(bis_name,category);
		ModelAndView mav=new ModelAndView("member/mypage");
		mav.addObject("myBis_list",myBis_list);
		//System.out.println(myBis_list.get(1));
		mav.addObject("member",member);
		return mav;
	}
	
	@RequestMapping(value="member/bislist", produces="text/plain; charset=UTF8")
	public @ResponseBody String bislist(HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
		String category = request.getParameter("category");
		System.out.println(category);
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String bis_name=member.getBis_name();
		List<Product> myBislist=shopService.categoryCheck(bis_name,category);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("myBislist", myBislist);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(map));
		System.out.println(jsonObject);
		request.setAttribute("data", jsonObject);
		return jsonObject.toString();
	}
	
	

}
