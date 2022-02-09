package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CancelOrderConformation
 */
@WebServlet("/CancelOrderConformation")
public class CancelOrderConformation extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session=request.getSession();	 
		 
	 int orderid=Integer.parseInt(request.getParameter("orderId"));  
	 System.out.println(orderid);
	 session.setAttribute("OrderId", orderid);	
	 double amount=Double.parseDouble(request.getParameter("amount"));
	 session.setAttribute("Amount", amount);
	 System.out.println(amount);
	 response.sendRedirect("cancelorder.jsp");
	}

}
