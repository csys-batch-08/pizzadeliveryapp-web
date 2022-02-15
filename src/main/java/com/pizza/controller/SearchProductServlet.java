package com.pizza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.daoimpl.ProductDaoImpl;
import com.pizza.model.Product;

/**
 * Servlet implementation class SearchProductServlet
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();	
		
		ProductDaoImpl dao=new ProductDaoImpl();
		String search= request.getParameter("search");
		
		List<Product> list=dao.productsearch(search);
		session.setAttribute("ProductList", list);
		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("search.jsp");
			dispatcher.forward(request, response);

	}

}
