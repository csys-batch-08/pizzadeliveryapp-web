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

import com.pizza.daoimpl.OrderDaoImpl;
import com.pizza.daoimpl.ProductDaoImpl;
import com.pizza.daoimpl.UserDaoImpl;
import com.pizza.exception.Lowbalance;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;

@WebServlet("/order")
/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
           
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("user");
	
		ProductDaoImpl productdao=new ProductDaoImpl();	
				
		String name=(String) session.getAttribute("pName");
		String size=(String) session.getAttribute("pSize");
		Double price=(Double) session.getAttribute("pPrice");
		 Product product=new Product(name,size,price);
		 
		Product pro=productdao.findProductId(product);
		request.setAttribute("productid",pro);
				
		int quantity=Integer.parseInt(request.getParameter("qty"));
		
		Double productprice=Double.parseDouble(request.getParameter("price"));
		
		UserDaoImpl dao=new UserDaoImpl();
		session.setAttribute("price",productprice);				
				OrderDaoImpl orderdao=new OrderDaoImpl();
				Order order=new Order(user,pro,quantity,productprice,null);
				int i=orderdao.orderproduct(order);			
				dao.update(productprice,user.getEmail());			
				List<Order> orderlist=orderdao.showorder(user);
				request.setAttribute("orderList", orderlist);					
		         try{
				if(i>0) {
					user.setWallet(user.getWallet()-productprice);
					session.setAttribute("user", user);								
					RequestDispatcher dispatcher=request.getRequestDispatcher("ListProductServlet");
					dispatcher.forward(request, response);				
					}
				else {		
					throw new Lowbalance();
		     	}
				}
			catch(Lowbalance l) {
				session.setAttribute("invalidBalance", l.getMessage());
				response.sendRedirect("walletrecharge.jsp");	
				
		}			
	}
}