package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Cart;
import com.petstore.domain.CartItem;
import com.petstore.domain.Item;
import com.petstore.service.CatalogService;

public class AddToCarServlet extends HttpServlet{
	Item item=new Item();
	CatalogService service=new CatalogService();
	Cart cart=new Cart();
	CartItem cartItem=new CartItem();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
       String ItemId=req.getParameter("workingItemId");
       item=service.getItem(ItemId);
       
       if(item.getQuantity()>0)
       {
       cart.addItem(item,true);/////////////
       
       }
       else
    	   cart.addItem(item,false);
       
       HttpSession session=req.getSession();
       session.setAttribute("cart", cart);
       RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/shoppingCar/Cart.jsp");
       rd.forward(req, resp);
       
}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
     this.doGet(req, resp);
}

}
