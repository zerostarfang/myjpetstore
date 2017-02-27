package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.dao.AccountDAO;
import com.petstore.dao.impl.AccountDAOImpl;
import com.petstore.domain.Account;

public class DoChangeServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		
		AccountDAO a=new AccountDAOImpl();
		
		HttpSession session=req.getSession();
		Account account=new Account();
		Account account2=new Account();
		account2=(Account)session.getAttribute("accountBean");
		
		account.setUsername(account2.getUsername());
		account.setStatus(account2.getStatus());
		account.setEmail(account2.getEmail());
		account.setPhone(account2.getPhone());
		account.setFirstName(req.getParameter("order.billToFirstName"));
		account.setLastName(req.getParameter("order.billToLastName"));
		//account.setPhone(req.getParameter("account.phone"));
		account.setAddress1(req.getParameter("order.billAddress1"));
		account.setAddress2(req.getParameter("order.billAddress2"));
		account.setCity(req.getParameter("order.billCity"));
		account.setState(req.getParameter("order.billState"));
		account.setZip(req.getParameter("order.billZip"));
		account.setCountry(req.getParameter("order.billCountry"));
		
		a.updateAccount(account);
		
		account2.setFirstName(req.getParameter("order.billToFirstName"));
		account2.setLastName(req.getParameter("order.billToLastName"));
		account2.setAddress1(req.getParameter("order.billAddress1"));
		account2.setAddress2(req.getParameter("order.billAddress2"));
		account2.setCity(req.getParameter("order.billCity"));
		account2.setState(req.getParameter("order.billState"));
		account2.setZip(req.getParameter("order.billZip"));
		account2.setCountry(req.getParameter("order.billCountry"));
		session.setAttribute("accountBean", account2);
		System.out.println("ssssss"+account2.getCountry());
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/order/ConfirmOrder.jsp");
		rd.forward(req, resp);
}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
    throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	  
}

}
