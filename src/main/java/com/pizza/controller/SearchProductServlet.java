package com.pizza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.ProductDaoImpl;
import com.pizza.model.Product;

/**
 * Servlet implementation class SearchProductServlet
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();	
		
		ProductDaoImpl dao=new ProductDaoImpl();
		String search= request.getParameter("search");
		
		List<Product> list=dao.productsearch(search);
		session.setAttribute("ProductList", list);
		
		 response.sendRedirect("search.jsp");

	}

}
