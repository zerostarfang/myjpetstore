package com.petstore.servlet;

import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Cart;
import com.petstore.domain.CartItem;

public class UpdateCartQuantitiesServlet extends HttpServlet {
	Cart cart = new Cart();
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
		HttpSession session=req.getSession();
		Iterator<CartItem> cartItems = ((Cart)session.getAttribute("cart")).getAllCartItems();
	    while (cartItems.hasNext()) {
	      CartItem cartItem = (CartItem) cartItems.next();
	      String itemId = cartItem.getItem().getItemId();
	      System.out.println(itemId);
	        int quantity = Integer.parseInt((String) req.getParameter("quantity"));
	        System.out.println(quantity);
	        ((Cart)session.getAttribute("cart")).setQuantityByItemId(itemId, quantity);
	        if (quantity < 1) {
	          cartItems.remove();
	        }
	     
	    }
	    RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/shoppingCar/Cart.jsp");
        rd.forward(req, resp);
}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
     this.doGet(req, resp);
}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
