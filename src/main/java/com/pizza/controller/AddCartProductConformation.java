package com.pizza.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.model.Product;

/**
 * Servlet implementation class AddCartProductConformation
 */
@WebServlet("/AddCartProductConformation")
public class AddCartProductConformation extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session=request.getSession(); 	 		 
   	   	 String name=request.getParameter("productName");
		 session.setAttribute("pName", name);
		 String size=request.getParameter("productSize");
		 session.setAttribute("pSize", size);		 
		 Double price=Double.parseDouble(request.getParameter("productPrice"));  		 
		 session.setAttribute("pPrice", price);			 		 
			RequestDispatcher dispatcher=request.getRequestDispatcher("cart.jsp");
			dispatcher.forward(request, response);	
	}
}