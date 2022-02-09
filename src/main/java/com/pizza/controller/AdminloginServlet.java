package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.dao.AdminDaoImpl;
import com.pizza.model.Admin;
@WebServlet("/adminLogin")
/**
 * Servlet implementation class Adminlogin
 */
public class AdminloginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Admin admin = new Admin(email,null,password);
		AdminDaoImpl dao=new AdminDaoImpl();
		dao.validateadmin(email, password);
		if(admin !=null) {
			response.sendRedirect("AddDeleteUpdate.jsp");
		}
		else {
			response.sendRedirect("Adminlogin.jsp");
		}
		
	}

}
