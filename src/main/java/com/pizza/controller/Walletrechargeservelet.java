package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.UserDaoImpl;
import com.pizza.model.User;
@WebServlet("/recharge")
/**
 * Servlet implementation class Walletrechargeservelet
 */
public class Walletrechargeservelet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Double amount=Double.parseDouble(request.getParameter("recharge"));
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		user.setWallet(user.getWallet()+amount);
		UserDaoImpl dao=new UserDaoImpl();
     	int result=dao.recharge(user);
     	if(result == 0)
     	{ 
     		user.setWallet(user.getWallet()-amount);
     	}       	
     	request.setAttribute("User", user);
		response.sendRedirect("showproducts.jsp");
	}
}
