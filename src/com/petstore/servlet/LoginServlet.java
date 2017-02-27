package com.petstore.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Account;
import com.petstore.domain.Product;
import com.petstore.service.AccountService;
import com.petstore.service.CatalogService;

public class LoginServlet extends HttpServlet{
	private AccountService service=new AccountService();
     Boolean authenticated=false;
     Account account=new Account();
	 List<Product> myList=new ArrayList<Product>();
	 CatalogService catalogService=new CatalogService() ;
	 String error=null;
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		String userName=req.getParameter("username");
		String userPassword=req.getParameter("password");
		
		HttpSession session=req.getSession();
		if(service.getAccount(userName, userPassword)==0)
		{
			authenticated=false;
			error="Login failed";
			session.setAttribute("authenticated",authenticated);
			session.setAttribute("error", error);
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/account/SignonForm.jsp");
			rd.forward(req, resp);
		}
		else{
			account=service.getAccount(userName);
			
			myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
			authenticated=true;
			error="";
			session.setAttribute("accountBean", account);
			session.setAttribute("authenticated",authenticated);
			session.setAttribute("error", error);
			session.setAttribute("MyList", myList);
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/catalog/Main.jsp");
			rd.forward(req, resp);
		}
		
	  
}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}

}
