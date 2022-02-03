package com.pizza.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.OrderDaoImpl;
import com.pizza.dao.ProductDaoImpl;
import com.pizza.dao.UserDaoImpl;
import com.pizza.exception.Lowbalance;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;

@WebServlet("/order")
/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
           
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("user");
		System.out.println("order user "+ user);		
		
		ProductDaoImpl productdao=new ProductDaoImpl();
	
		Product product=(Product) session.getAttribute("products");
		Product pro=productdao.findProductId(product);
		session.setAttribute("productid",pro);
				
		int quantity=Integer.parseInt(request.getParameter("qty"));
		System.out.println(quantity);	
		
		Double productprice=Double.parseDouble(request.getParameter("price"));
		System.out.println(productprice);
		
		UserDaoImpl dao=new UserDaoImpl();
		session.setAttribute("price",productprice);		
		
				OrderDaoImpl orderdao=new OrderDaoImpl();
				Order order=new Order(user,pro,quantity,productprice,null);
				System.out.println(order);
				int i=orderdao.orderproduct(order);
				dao.update(productprice,user.getEmail());
							
				user.setWallet(user.getWallet()-productprice);
				session.setAttribute("user", user);
				
				List<Order> orderlist=orderdao.showorder(user);
				session.setAttribute("orderList", orderlist);	
				
		         try{
				if(i>0) {
					response.sendRedirect("showproducts.jsp");
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