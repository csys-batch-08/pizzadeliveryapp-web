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
 * Servlet implementation class DeleteProductConformation
 */
@WebServlet("/DeleteProductConformation")
public class DeleteProductConformation extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();	 
		 
		 int productid=Integer.parseInt(request.getParameter("Pid"));  		 
		 session.setAttribute("id", productid);	
		 
		 RequestDispatcher dispatcher=request.getRequestDispatcher("deleteproduct.jsp");
			dispatcher.forward(request, response);
	}

}
