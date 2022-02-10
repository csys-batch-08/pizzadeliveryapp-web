package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.daoimpl.UserDaoImpl;
import com.pizza.model.User;
import com.pizza.utill.ConnectionUtill;
@WebServlet("/Sample")
public class UserRegisterServlet extends HttpServlet{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String firstname=req.getParameter("firstname");
			String email=req.getParameter("email");
			String address=req.getParameter("address");
			long phonenumber=Long.parseLong(req.getParameter("phonenumber"));
			String password=req.getParameter("password");
			User user=new User(firstname,phonenumber,email,address, password, 0,"");
			UserDaoImpl userdao=new UserDaoImpl();
			userdao.insert(user);
				resp.sendRedirect("userlogin.jsp");
		}
}
