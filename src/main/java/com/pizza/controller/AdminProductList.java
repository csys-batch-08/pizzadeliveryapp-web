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
 * Servlet implementation class AdminProductList
 */
@WebServlet("/AdminProductList")
public class AdminProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDaoImpl dao= new ProductDaoImpl();

		List<Product> adminlist=dao.adiminshowProduct();	
    	request.setAttribute("productList", adminlist);	
    	
    	RequestDispatcher dispatcher=request.getRequestDispatcher("adddeleteupdate.jsp");
		dispatcher.forward(request, response);	
	}

}
