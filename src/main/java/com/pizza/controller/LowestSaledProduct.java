package com.pizza.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.daoimpl.OrderDaoImpl;
import com.pizza.model.Product;
@WebServlet("/low")

/**
 * Servlet implementation class LowestSaledProduct
 */
public class LowestSaledProduct extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		
			Date fromdate = sdf.parse(request.getParameter("fromDate"));
			Date todate =  sdf.parse(request.getParameter("toDate"));
		   	OrderDaoImpl orderdao= new OrderDaoImpl();
			Product product=orderdao.lowestsaledproduct(fromdate, todate);
			request.setAttribute("Product", product);
			 
			 RequestDispatcher dispatcher=request.getRequestDispatcher("lowestsaledproduct.jsp");
				dispatcher.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
