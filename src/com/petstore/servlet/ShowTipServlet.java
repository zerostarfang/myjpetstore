package com.petstore.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petstore.domain.Category;
import com.petstore.service.CatalogService;

public class ShowTipServlet  extends HttpServlet{
	CatalogService service=new CatalogService();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
    String name=req.getParameter("name");
    System.out.println(name);
    Category category=service.getCategory(name);
    String res="";
    res= "<name>"+category.getName()+"</name>";
	 resp.setContentType("text/XML;charset=UTF-8");
	PrintWriter out = resp.getWriter();
	out.println("<response>");
	out.println(res);
	out.println("</response>");
	out.flush();
	out.close();
    
    
}

	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
     this.doGet(req, resp);
}
}
