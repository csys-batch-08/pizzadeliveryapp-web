package com.pizza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.daoimpl.UserDaoImpl;
import com.pizza.model.User;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserDaoImpl dao=new UserDaoImpl();

		List<User> list=dao.showuser();
		request.setAttribute("userList", list);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("userlist.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
