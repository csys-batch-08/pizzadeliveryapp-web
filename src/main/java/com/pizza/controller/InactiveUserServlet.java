package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InactiveUserServlet
 */
@WebServlet("/InactiveUserServlet")
public class InactiveUserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();	
		 
		 String Email=request.getParameter("email"); 
   		 session.setAttribute("email", Email);	
   		 
 	     response.sendRedirect("inactive.jsp");		
	}
}
