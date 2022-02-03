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
import com.pizza.dao.UserDaoImpl;
import com.pizza.model.Admin;
import com.pizza.model.Product;
import com.pizza.model.User;
@WebServlet("/addproduct")
/**
 * Servlet implementation class AddproductServlet
 */
public class AddproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddproductServlet() {
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
		HttpSession session=request.getSession();
		
		String productname=request.getParameter("name");
		String productsize=request.getParameter("size");	
		Double productprice=Double.parseDouble(request.getParameter("price"));
		Product product=new Product(productname,productsize,productprice);
		ProductDaoImpl dao=new ProductDaoImpl();
		dao.insertproduct(product);
		
		List<Product> adminlist=dao.adiminshowProduct();
		session.setAttribute("productList", adminlist);
		
		response.sendRedirect("adddeleteupdate.jsp");

        
	}

}
