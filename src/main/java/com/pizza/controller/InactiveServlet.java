package com.pizza.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// import org.apache.catalina.connector.Response;

import com.pizza.dao.UserDaoImpl;
import com.pizza.model.User;
@WebServlet("/inactive")

/**
 * Servlet implementation class InactiveServlet
 */
public class InactiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InactiveServlet() {
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

		String email=request.getParameter("id");
		System.out.println("email id"+email);
		
		User user=new User("",0,email,"", "", 0,"");
		UserDaoImpl dao=new UserDaoImpl();	
		boolean b=dao.inactive(email);
		if(b == false) {			
			response.sendRedirect("inactive.jsp");
		}
		else {
		response.sendRedirect("AddDeleteUpdate.jsp");		
		}
	}

}
