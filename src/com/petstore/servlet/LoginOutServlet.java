package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		HttpSession session=req.getSession();
		session.setAttribute("authenticated", false);
		session.setAttribute("error", null);
		session.setAttribute("accountBean", null);
		session.setAttribute("MyList", null);
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/catalog/Main.jsp");
		rd.forward(req, resp);
	  
}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}

}
