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

@WebServlet("/OrderProductConformation")
public class OrderProductConformation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();	 
		 
	   	String name=request.getParameter("productname");
		 session.setAttribute("pName", name);	
		 String size=request.getParameter("productsize");
		 session.setAttribute("pSize", size);		 
		 Double price=Double.parseDouble(request.getParameter("productprice"));  		 
		 session.setAttribute("pPrice", price);	
		 
		 Product product=new Product(name,size,price);		
		 session.setAttribute("products", product);		 
	 		 
		 RequestDispatcher dispatcher=request.getRequestDispatcher("order.jsp");
			dispatcher.forward(request, response);	
		
	}

}
