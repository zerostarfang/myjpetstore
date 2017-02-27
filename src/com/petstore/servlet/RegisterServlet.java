package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petstore.domain.Account;
import com.petstore.service.AccountService;

public class RegisterServlet  extends HttpServlet{

	AccountService service=new AccountService();
	Account account=new Account();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		
		account.setUsername(req.getParameter("username"));
		account.setPassword(req.getParameter("password"));
		req.getParameter("repeatedPassword");
		account.setFirstName(req.getParameter("account.firstName"));
		account.setLastName(req.getParameter("account.lastName"));
		account.setEmail(req.getParameter("account.email"));
		account.setPhone(req.getParameter("account.phone"));
		account.setAddress1(req.getParameter("account.address1"));
		account.setAddress2(req.getParameter("account.address2"));
		account.setCity(req.getParameter("account.city"));
		account.setState(req.getParameter("account.state"));
		account.setZip(req.getParameter("account.zip"));
		account.setCountry(req.getParameter("account.country"));
		account.setLanguagePreference(req.getParameter("account.languagePreference"));
		account.setFavouriteCategoryId(req.getParameter("account.favouriteCategoryId"));
		req.getParameter("account.listOption");
		account.setListOption(true);
		req.getParameter("account.bannerOption");
		account.setBannerOption(true);
		
		
		service.insertAccount(account);
		
	    RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/account/SignonForm.jsp");
	    rd.forward(req, resp);
}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}
}
