package com.petstore.servlet;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Cart;

public class ToViewOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		
		HttpSession session=req.getSession();
		
		Cart cart=new Cart();
		cart.removeAllItem();
		
		
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/order/ViewOrder.jsp");
		rd.forward(req, resp);
	  
}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}

}
