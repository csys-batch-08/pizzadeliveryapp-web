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
import com.pizza.daoimpl.OrderDaoImpl;
import com.pizza.model.Cart;
import com.pizza.model.Order;
import com.pizza.model.User;

/**
 * Servlet implementation class ShowOrderServlet
 */
@WebServlet("/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  HttpSession session=request.getSession();	

			
			User user=(User) session.getAttribute("user");		
			OrderDaoImpl orderdao=new OrderDaoImpl();
			List<Order> orderlist=orderdao.showorder(user);
			session.setAttribute("orderList", orderlist);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("showorder.jsp");
			dispatcher.forward(request, response);	
	}

}
