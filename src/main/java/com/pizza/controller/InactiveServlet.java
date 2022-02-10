package com.pizza.controller;

import java.io.IOException;
import java.util.List;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email = request.getParameter("id");

		UserDaoImpl dao = new UserDaoImpl();
		boolean b = dao.inactive(email);

		List<User> userlist = dao.showuser();
		session.setAttribute("userList", userlist);

		if (!b) {
			response.sendRedirect("inactive.jsp");
		} else {
			response.sendRedirect("adddeleteupdate.jsp");
		}
	}
}
