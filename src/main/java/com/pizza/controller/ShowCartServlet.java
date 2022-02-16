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

/**
 * Servlet implementation class ShowChartServlet
 */
@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session=request.getSession();	

		CartDaoImpl cartdao=new CartDaoImpl();
		
		User user=(User) session.getAttribute("user");		
		List<Cart> cartlist=cartdao.showcart(user);
		request.setAttribute("cartList", cartlist);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("showcart.jsp");
		dispatcher.forward(request, response);	
	}

}
