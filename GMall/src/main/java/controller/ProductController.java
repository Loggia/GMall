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

import logic.JooService;
import logic.KoService;
import logic.KuService;
import logic.Member;
import logic.Product;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class ProductController 
{
	@Autowired
	public KoService koService; // 종환이꺼

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
		ModelAndView mav=new ModelAndView();
		int pro_no = koService.prono()+1;
		
		Member login=(Member)session.getAttribute("LOGIN_MEMBER");

        product.setPro_no(pro_no);	
        product.setBis_no(login.getBis_no());
        product.setBis_name(login.getBis_name());
        koService.ProductAdd(product,request);
        //상품업데이트끝
        

		mav.setViewName("success");
		mav.addObject("url", "../member/mypage.mall");
		mav.addObject("msg", "상품을 등록하였습니다.");
		mav.addObject("member", login);
		
		return mav;
	}

	//고종환 내 사업장 관리에서 카테고리 클릭시
	@RequestMapping("member/categoryCheck")
	public ModelAndView categoryCheck(HttpSession session,HttpServletRequest request){
		String category=request.getParameter("category");
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String bis_name=member.getBis_name();
		
		List<Product> myBis_list=koService.categoryCheck(bis_name,category);
		ModelAndView mav=new ModelAndView("member/mypage");
		mav.addObject("myBis_list",myBis_list);
		//System.out.println(myBis_list.get(1));
		mav.addObject("member",member);
		return mav;
	}
	
	/*
	 * 우희동 내 사업장 카테고리 ajax
	 */
	@RequestMapping(value="member/bislist", produces="text/plain; charset=UTF8")
	public @ResponseBody String bislist(HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
		String category = request.getParameter("category");
		System.out.println(category);
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String bis_name=member.getBis_name();
		List<Product> myBislist=koService.categoryCheck(bis_name,category); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("myBislist", myBislist);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(map));
		System.out.println(jsonObject);
		request.setAttribute("data", jsonObject);
		return jsonObject.toString();
	}
	
	//고종환 사업자 목록에서 상품삭제    /product/productDelete.mall?pro_no
	@RequestMapping("product/productDelete")
	public ModelAndView productDelete(HttpServletRequest request,HttpSession session){
		ModelAndView mav=new ModelAndView();
		String pro_no=request.getParameter("pro_no");
		
		Member login=(Member)session.getAttribute("LOGIN_MEMBER");
		
		if(login == null)
		{
			mav.setViewName("error");
			mav.addObject("url", "../member/mypage.mall");
			mav.addObject("msg", "로그인하고 시도하시기 바랍니다.");
			return mav;
		}else{
			koService.productDelete(pro_no);
			mav.setViewName("success");
			mav.addObject("url", "../member/mypage.mall");
			mav.addObject("msg", "상품을 삭제 하였습니다.");
			mav.addObject("member", login);
			
			return mav;
		}
	}
	
	
	

}
