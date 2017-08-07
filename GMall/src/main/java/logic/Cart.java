package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart implements Serializable{
	private List<ProductSet> productList = new ArrayList<ProductSet>();
	
	public List<ProductSet> getProductList() {
		return productList ; 
	}
	
	public void push(ProductSet productSet) {
		Iterator<ProductSet> iter = productList.iterator();
		ProductSet is = null;
		while (iter.hasNext()) {
			is = iter.next();
			if(is.getProduct().getPro_no() == productSet.getProduct().getPro_no()){
				is.setQuantity(is.getQuantity() + productSet.getQuantity());
				return ;
			}
		}
		productList.add(productSet);
	}
}
