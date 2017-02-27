package com.petstore.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Item;
import com.petstore.domain.Product;
import com.petstore.service.CatalogService;

public class ProductServlet extends HttpServlet{
	String productId=null;
	Product product=new Product();
	List<Item> itemList=new ArrayList<Item>();
	CatalogService service=new CatalogService();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
     throws ServletException,java.io.IOException{
		productId=req.getParameter("productId");
		product=service.getProduct(productId);
		itemList=service.getItemListByProduct(productId);
		
		HttpSession session=req.getSession();
		session.setAttribute("product", product);
		session.setAttribute("itemList", itemList);
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/catalog/Product.jsp");
		rd.forward(req, resp);
		
	  
}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}

}
