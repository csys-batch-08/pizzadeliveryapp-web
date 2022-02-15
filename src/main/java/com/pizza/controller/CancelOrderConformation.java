package com.pizza.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();	 
		 
	 int orderid=Integer.parseInt(request.getParameter("orderId"));  
	 session.setAttribute("OrderId", orderid);	
	 double amount=Double.parseDouble(request.getParameter("amount"));
	 session.setAttribute("Amount", amount);
	 RequestDispatcher dispatcher=request.getRequestDispatcher("cancelorder.jsp");
		dispatcher.forward(request, response);	
	}

}
