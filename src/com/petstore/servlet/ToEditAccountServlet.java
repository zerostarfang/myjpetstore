package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToEditAccountServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/account/EditAccountForm.jsp");
		rd.forward(req, resp);
	  
}

	public void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}


}
