package com.pizza.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.OrderDaoImpl;
@WebServlet("/total")
/**
 * Servlet implementation class TotalAmountServlet
 */
public class TotalAmountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		
			Date fromdate =(Date) sdf.parse(request.getParameter("fromDate"));
			Date todate = (Date) sdf.parse(request.getParameter("toDate"));
			HttpSession session = request.getSession();			
			
			OrderDaoImpl orderdao= new OrderDaoImpl();
 			Double price=orderdao.TotalAmount(fromdate, todate);
 			session.setAttribute("totalprize", price);
 			
			response.sendRedirect("totalamountsales.jsp");

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
