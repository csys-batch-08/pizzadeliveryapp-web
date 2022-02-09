package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();	
		 
		 String useremail=request.getParameter("email"); 
   		 session.setAttribute("email", useremail);	   		 
 	     response.sendRedirect("inactive.jsp");		
	}
}