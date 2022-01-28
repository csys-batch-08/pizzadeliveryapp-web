package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.OrderDaoImpl;
import com.pizza.dao.UserDaoImpl;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;
@WebServlet("/cancel")

/**
 * Servlet implementation class cancelorder
 */
public class cancelorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancelorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request,response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        HttpSession session=request.getSession();	
       
		int orderid=Integer.parseInt(request.getParameter("id"));	
		
		Double price=Double.parseDouble(request.getParameter("refund"));
		
		User user=(User) session.getAttribute("user");

		OrderDaoImpl dao=new OrderDaoImpl();	
		UserDaoImpl userdao=new UserDaoImpl();
		userdao.updateuserWallet(user, price);
		dao.ordercancel(orderid);
		user.setWallet(user.getWallet()+price);
		session.setAttribute("user", user);
		response.sendRedirect("Showorder.jsp");

	}

}
