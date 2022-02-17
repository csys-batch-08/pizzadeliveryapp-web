package com.pizza.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BillDeliverdConformation
 */
@WebServlet("/BillDeliverdConformation")
public class BillDeliverdConformation extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      HttpSession session=request.getSession();	

	        
			int id=Integer.parseInt(request.getParameter("orderid"));
			session.setAttribute("oId", id);
			
			String pName=request.getParameter("name");
			session.setAttribute("productName", pName);
			
			String pSize=request.getParameter("size");
			session.setAttribute("productSize", pSize);
			
			int qty=Integer.parseInt(request.getParameter("quantity"));
			session.setAttribute("quantity", qty);
					
			Double pPrize=Double.parseDouble(request.getParameter("price"));
			session.setAttribute("productPrice", pPrize);
		    
		
			response.sendRedirect("bill.jsp");
			
			
	}

}
