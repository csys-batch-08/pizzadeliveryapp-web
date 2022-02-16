package com.pizza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.daoimpl.ProductDaoImpl;
import com.pizza.model.Product;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDaoImpl dao= new ProductDaoImpl();
		
		List<Product> list=dao.showProduct();
		request.setAttribute("productlist", list);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("showproducts.jsp");
		dispatcher.forward(request, response);
		
		
	}
}
