package com.pizza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.OrderDaoImpl;
import com.pizza.model.Order;
import com.pizza.model.User;

@WebServlet("/bills")
/**
 * Servlet implementation class Deliverdorder
 */
public class Deliverdorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deliverdorder() {
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
		 
		     User user=(User) session.getAttribute("user");
			
	       
			int orderid=Integer.parseInt(request.getParameter("id"));	
			Order order=new Order(orderid,null,null,0,0.0,null,null);
			OrderDaoImpl dao=new OrderDaoImpl();				
			dao.orderdelivered(orderid);
			
			List<Order> orderlist=dao.showorder(user);
			session.setAttribute("orderList", orderlist);
			
			response.sendRedirect("showorder.jsp");
	}

}
