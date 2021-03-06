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

import com.pizza.daoimpl.CartDaoImpl;
import com.pizza.model.Cart;
import com.pizza.model.User;
@WebServlet("/removecart")

/**
 * Servlet implementation class DeleteCartServlet
 */
public class DeleteCartServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("user");
		
		int cartid=Integer.parseInt(request.getParameter("cartid"));		
		
		CartDaoImpl dao=new CartDaoImpl();
		dao.delete(cartid);
		List<Cart> cartlist=dao.showcart(user);
		request.setAttribute("cartList", cartlist);
		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("ShowCartServlet");
			dispatcher.forward(request, response);
	}

}
