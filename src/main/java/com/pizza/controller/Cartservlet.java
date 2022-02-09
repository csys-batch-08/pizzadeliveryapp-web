package com.pizza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.CartDaoImpl;
import com.pizza.dao.OrderDaoImpl;
import com.pizza.dao.UserDaoImpl;
import com.pizza.model.Cart;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;
@WebServlet("/cart")
/**
 * Servlet implementation class Cartservlet
 */
public class Cartservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		User user=(User) session.getAttribute("user");
		                                           
		Product product=(Product) session.getAttribute("products");
	    
		CartDaoImpl dao=new CartDaoImpl();
		Cart cart=new Cart(user,product,0,0.0);
	    dao.insertCart(cart);		
	    CartDaoImpl cartdao=new CartDaoImpl();
		List<Cart> cartlist=cartdao.showcart(user);
		session.setAttribute("cartList", cartlist);
		
		response.sendRedirect("showproducts.jsp");				
	}
}
