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
import com.pizza.exception.SameProductException;
import com.pizza.model.Product;

@WebServlet("/addproduct")
/**
 * Servlet implementation class AddproductServlet
 */
public class AddproductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String productname = request.getParameter("name");
		String productsize = request.getParameter("size");
		Double productprice = Double.parseDouble(request.getParameter("price"));
		ProductDaoImpl dao = new ProductDaoImpl();
		List<Product> list = dao.adiminshowProduct();
		
		try {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getProductName().equalsIgnoreCase(productname)
						&& list.get(i).getSize().equalsIgnoreCase(productsize)) {
					
					throw new SameProductException();
				}
			}
			Product product = new Product(productname, productsize, productprice);
			int j = dao.insertproduct(product);
			
			if (j > 0) {
				
				List<Product> adminlist = dao.adiminshowProduct();
				request.setAttribute("productList", adminlist);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("adddeleteupdate.jsp");
				dispatcher.forward(request, response);
			}
		}
		catch (SameProductException s) {
			
				session.setAttribute("notfound", s.getMessage());
				response.sendRedirect("addproduct.jsp");
			
		}
		
	}
}
