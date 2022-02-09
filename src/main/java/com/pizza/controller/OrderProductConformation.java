package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.model.Product;

/**
 * Servlet implementation class OrderProductConformation
 */
@WebServlet("/OrderProductConformation")
public class OrderProductConformation extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();	 
		 
	   	String name=request.getParameter("productname");
		 session.setAttribute("pname", name);	
		 String size=request.getParameter("productsize");
		 session.setAttribute("psize", size);		 
		 Double price=Double.parseDouble(request.getParameter("productprice"));  		 
		 session.setAttribute("pprice", price);	
		 
		 Product product=new Product(name,size,price);		
		 session.setAttribute("products", product);		 
	 
		 response.sendRedirect("order.jsp");
		
	}

}
