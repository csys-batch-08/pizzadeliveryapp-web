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
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Walletrechargeservelet() {
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
	//	doGet(request, response);
		
//		int userid=Integer.parseInt(request.getParameter("userid"));
//		System.out.println(userid);
		Double amount=Double.parseDouble(request.getParameter("recharge"));
		System.out.println(amount);
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		user.setWallet(user.getWallet()+amount);
		UserDaoImpl dao=new UserDaoImpl();
     	int result=dao.recharge(user);
     	if(result==0)
     	{
     		user.setWallet(user.getWallet()-amount);
     	}
     	
		response.sendRedirect("Showproducts.jsp");
	}
}
