package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.dao.ProductDaoImpl;
import com.pizza.model.Product;
@WebServlet("/updateproduct")
/**
 * Servlet implementation class DeleteproductServlet
 */
public class UpdateproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateproductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productid=Integer.parseInt(request.getParameter("id"));
		String productname=request.getParameter("name");
		String productsize=request.getParameter("size");
		Double productprice=Double.parseDouble(request.getParameter("price"));
		Product product=new Product(productname,productsize,productprice);
		ProductDaoImpl dao=new ProductDaoImpl();
		dao.updated(productname, productsize, productprice, productid);
			response.sendRedirect("AddDeleteUpdate.jsp");
	}

}
