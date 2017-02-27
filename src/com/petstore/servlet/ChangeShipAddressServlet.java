package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeShipAddressServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		String bl="0";
		 bl=req.getParameter("shippingAddressRequired");
		if(bl.equals("1"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/order/ShippingForm.jsp");
			 rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/order/ConfirmOrder.jsp");
			rd.forward(req, resp);
		}
		
	  
}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}

}
