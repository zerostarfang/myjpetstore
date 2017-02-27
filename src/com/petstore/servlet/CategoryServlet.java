package com.petstore.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Category;
import com.petstore.domain.Product;
import com.petstore.service.CatalogService;

public class CategoryServlet extends HttpServlet{
	CatalogService service=new CatalogService();
	List<Product> products=new ArrayList<Product>();
	Category category=null;
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
            java.io.IOException{
		  
		   String categoryId=req.getParameter("categoryId");
		   category=service.getCategory(categoryId);
		   products=service.getProductListByCategory(categoryId);
		   
		   HttpSession session=req.getSession();
		   session.setAttribute("category", category);
		   session.setAttribute("productList", products);
		   
		   RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/catalog/Category.jsp");
		   rd.forward(req, resp);
		   
		   
		
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
     this.doGet(req, resp);
}

}
