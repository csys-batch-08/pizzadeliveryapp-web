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
@WebServlet("/updateproduct")
/**
 * Servlet implementation class DeleteproductServlet
 */
public class UpdateproductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productid=Integer.parseInt(request.getParameter("id"));
		String productname=request.getParameter("name");
		String productsize=request.getParameter("size");
		Double productprice=Double.parseDouble(request.getParameter("price"));
		String productstatus=request.getParameter("status");
		ProductDaoImpl dao=new ProductDaoImpl();
		
		dao.updated(productname, productsize, productprice, productstatus, productid);
		
		List<Product> adminlist=dao.adiminshowProduct();	
    	request.setAttribute("productList", adminlist);	
    	
		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("adddeleteupdate.jsp");
			dispatcher.forward(request, response);

	}

}
