package com.pizza.controller;

import java.io.IOException;
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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      HttpSession session=request.getSession();	

	        
			int oid=Integer.parseInt(request.getParameter("orderid"));
			session.setAttribute("Oid", oid);
			
			String pname=request.getParameter("name");
			session.setAttribute("productname", pname);
			
			String psize=request.getParameter("size");
			session.setAttribute("productsize", psize);
			
			int qty=Integer.parseInt(request.getParameter("quantity"));
			session.setAttribute("quantity", qty);
					
			Double pprize=Double.parseDouble(request.getParameter("price"));
			session.setAttribute("productprice", pprize);
		    
			 response.sendRedirect("bill.jsp");
			
			
	}

}