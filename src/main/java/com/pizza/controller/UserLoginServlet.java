package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.UserDaoImpl;
import com.pizza.exception.Lowbalance;
import com.pizza.model.User;

@WebServlet("/Login")

/**
 * Servlet implementation class Login
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	
	/**HttpServletRequest
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		HttpSession session=request.getSession();
		
		String email=request.getParameter("email");
		System.out.println(email);
		String password=request.getParameter("password");
		System.out.println(password);
		UserDaoImpl userdao=new UserDaoImpl();
		User user = userdao.validateUser(email, password);			
		
		session.setAttribute("user", user);	
		if(user.getType().equals("Admin")) {
			response.sendRedirect("AddDeleteUpdate.jsp");
		}		
		else if(user.getType().equals("user")) {
			response.sendRedirect("Showproducts.jsp");			
		}			
	}
}
