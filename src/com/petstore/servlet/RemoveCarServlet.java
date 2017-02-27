package com.petstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petstore.domain.Cart;

public class RemoveCarServlet extends HttpServlet{
	Cart cart=new Cart();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
		String itemId=req.getParameter("itemId");
		HttpSession session=req.getSession();
		((Cart)session.getAttribute("cart")).removeItemById(itemId);
        RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/shoppingCar/Cart.jsp");
        rd.forward(req, resp);
        
}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,
    java.io.IOException{
     this.doGet(req, resp);
}

}
