package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Item;
import com.petstore.service.CatalogService;

public class ItemServlet extends HttpServlet{
	CatalogService service=new CatalogService();
	String itemId=null;
	Item item=new Item();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		itemId=req.getParameter("itemId");
		item=service.getItem(itemId);
		
		HttpSession session=req.getSession();
		session.setAttribute("item", item);
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/catalog/Item.jsp");
		rd.forward(req, resp);
		
	  
}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}

}
