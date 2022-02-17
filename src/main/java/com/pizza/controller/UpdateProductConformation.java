package com.pizza.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateProductConformation
 */
@WebServlet("/UpdateProductConformation")
public class UpdateProductConformation extends HttpServlet {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();	 
	   	int productid=Integer.parseInt(request.getParameter("Pid"));  		 
		 session.setAttribute("id", productid);		
		 
		 String name=request.getParameter("name");
		 session.setAttribute("productName", name);	
		 
		 String size=request.getParameter("size");
		 session.setAttribute("productSize", size);	
		 
		 Double price=Double.parseDouble(request.getParameter("price"));
		 session.setAttribute("productPrice", price);	

		 String status=request.getParameter("productstatus");
		 session.setAttribute("productStatus", status);	
		 
		 response.sendRedirect("updateproduct.jsp");

		 
	}

}
