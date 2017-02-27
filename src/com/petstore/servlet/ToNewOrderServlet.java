package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Account;
import com.petstore.domain.Cart;
import com.petstore.domain.Item;
import com.petstore.domain.Order;

public class ToNewOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		Order order=new Order();
		Account account=new Account();
		
		HttpSession session=req.getSession();
		account=(Account)session.getAttribute("accountBean");
		Cart cart=new Cart();
		cart=(Cart)session.getAttribute("cart");
		boolean authenticated=(Boolean)session.getAttribute("authenticated");
		 if(account!=null && authenticated && cart!=null )
		 {
			 order.initOrder(account, cart);
			 session.setAttribute("order", order);
			 RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/order/NewOrderForm.jsp");
			 rd.forward(req, resp);
		 }
		

	  
}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}

}
