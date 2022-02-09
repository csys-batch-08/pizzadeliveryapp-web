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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Double amount=Double.parseDouble(request.getParameter("recharge"));
		System.out.println(amount);
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		user.setWallet(user.getWallet()+amount);
		UserDaoImpl dao=new UserDaoImpl();
     	int result=dao.recharge(user);
     	if(result == 0)
     	{ 
     		user.setWallet(user.getWallet()-amount);
     	}   
     	
     	session.setAttribute("User", user);
		response.sendRedirect("showproducts.jsp");
	}
}
