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
		 
		 String name=request.getParameter("productname");
		 session.setAttribute("ProductName", name);	
		 
		 String size=request.getParameter("productsize");
		 session.setAttribute("ProductSize", size);	
		 
		 Double price=Double.parseDouble(request.getParameter("productprice"));
		 session.setAttribute("ProductPrice", price);	

		 String status=request.getParameter("productstatus");
		 session.setAttribute("ProductStatus", status);	
		 
		 RequestDispatcher dispatcher=request.getRequestDispatcher("updateproduct.jsp");
			dispatcher.forward(request, response);

		 
	}

}
