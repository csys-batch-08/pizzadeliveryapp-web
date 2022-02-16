package com.pizza.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.pizza.daoimpl.UserDaoImpl;
import com.pizza.exception.InactiveUserException;
import com.pizza.exception.UserNotFound;

import com.pizza.model.User;

@WebServlet("/Login")

/**
 * Servlet implementation class Login
 */
public class UserLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String email=request.getParameter("email");		
		
		String password=request.getParameter("password");
		UserDaoImpl userdao=new UserDaoImpl();		
		User user = userdao.validateUser(email, password);	
		
		
		
		try {
			if(user!=null) 
			{
			if(user.getType().equals("Admin")) 
			{							
				response.sendRedirect("AdminProductList");
	      	}	
		else if(user.getType().equals("user")) 
		{			  				
			session.setAttribute("user",user);
			response.sendRedirect("ListProductServlet");
			
		}
			else if(user.getType().equals("Inactive")) 
			{
				throw new InactiveUserException();
			}
		}			
		else 
		{					
			throw new UserNotFound();
     	}
		}		
		catch(UserNotFound l) {
			session.setAttribute("nouser", l.getMessage());
			response.sendRedirect("userlogin.jsp");			
	} catch (InactiveUserException e) {
		session.setAttribute("Inactiveuser", e.getMessage() );
		response.sendRedirect("userlogin.jsp");	
		}
	}
}