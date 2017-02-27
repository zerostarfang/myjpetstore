package com.petstore.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petstore.service.AccountService;

public class UserExistServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
		
	AccountService service=new AccountService();
     String name=req.getParameter("name");
     String res;
     System.out.print(service.getAccount(name));
     if(service.getAccount1(name)==1)
     {
    	 System.out.print("aaa");
    	 	
    	 res= "<percent>"+"0"+"</percent>";
    	 resp.setContentType("text/XML;charset=UTF-8");
 		PrintWriter out = resp.getWriter();
 		out.println("<response>");
		out.println(res);
		out.println("</response>");
		out.flush();
		out.close();
     }
     else {
    	 System.out.print("bbb");
    	 res= "<percent>"+"1"+"</percent>";
    	 resp.setContentType("text/XML;charset=UTF-8");
 		PrintWriter out = resp.getWriter();
 		out.println("<response>");
		out.println(res);
		out.println("</response>");
		out.flush();
		out.close();
	}
	 	  
		
}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
     this.doGet(req, resp);
}


}
