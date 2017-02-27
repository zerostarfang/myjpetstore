package com.petstore.action;

import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.petstore.domain.Account;
import com.petstore.domain.Cart;
import com.petstore.domain.CartItem;
import com.petstore.domain.Item;
import com.petstore.domain.Order;
import com.petstore.service.CatalogService;
 @Scope("prototype")
public class ShoppingCarAction extends ActionSupport{
	Item item=new Item();
	CatalogService service ;
	Cart cart=new Cart();
	CartItem cartItem=new CartItem();
	
	
	HttpSession session=ServletActionContext.getRequest().getSession();
	Order order=new Order();
	Account account=new Account();
	
	
	private String workingItemId;
	
	private String quantity;
	
	private String itemId;
	/**
	 * 将商品添加到购物车里
	 * @return
	 */
	
	public String addToCar(){
		  item=service.getItem(workingItemId);
	       
	       if(item.getQuantity()>0)
	       {
	       cart.addItem(item,true);/////////////
	       
	       }
	       else
	    	   cart.addItem(item,false);
	       
	       HttpSession session=ServletActionContext.getRequest().getSession();
	       session.setAttribute("cart", cart);
		
		return "ok";
	}

	public String updateCartQuantities(){
		
		Iterator<CartItem> cartItems = ((Cart)session.getAttribute("cart")).getAllCartItems();
	    while (cartItems.hasNext()) {
	      cartItem = (CartItem) cartItems.next();
	      String itemId = cartItem.getItem().getItemId();
	      System.out.println(itemId);
	        int quantity1 = Integer.parseInt(quantity);
	        System.out.println(quantity);
	        ((Cart)session.getAttribute("cart")).setQuantityByItemId(itemId, quantity1);
	        if (quantity1 < 1) {
	          cartItems.remove();
	        }
	     
	    }
		return "ok";
	
	}
	
	
	
	public String toNewOrder(){
		account=(Account)session.getAttribute("accountBean");
		Cart cart=new Cart();
		cart=(Cart)session.getAttribute("cart");
		boolean authenticated=(Boolean)session.getAttribute("authenticated");
		
		 if(account!=null && authenticated && cart!=null )
		 {
			 order.initOrder(account, cart);
			 session.setAttribute("order", order);
			 return "ok";
		 }
		return "toLogin";
	}
	
	/**
	 * 将商品从购物车上删除
	 * @return
	 */
	public String removeCar(){
	  ((Cart)session.getAttribute("cart")).removeItemById(itemId);
		return "ok";
	}
	
	
	
	
	
	public String getWorkingItemId() {
		return workingItemId;
	}

	public void setWorkingItemId(String workingItemId) {
		this.workingItemId = workingItemId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Resource(name="catalogService")
	public void setService(CatalogService service) {
		this.service = service;
	}
	

}
