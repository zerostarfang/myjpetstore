package com.petstore.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Product;
import com.petstore.service.CatalogService;

public class SearchServlet extends HttpServlet{
	
	List<Product> productList=new ArrayList<Product>();
	String keyWord=null;
	CatalogService service=new CatalogService();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
		keyWord=req.getParameter("keyword");
		productList=service.searchProductList(keyWord);
		
		HttpSession session=req.getSession();
		session.setAttribute("productList", productList);
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/catalog/SearchProducts.jsp");
		rd.forward(req, resp);
        
    }
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
     this.doGet(req, resp);
}

}
