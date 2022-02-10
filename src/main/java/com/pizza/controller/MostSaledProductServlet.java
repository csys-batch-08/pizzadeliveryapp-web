package com.pizza.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.OrderDaoImpl;
import com.pizza.model.Product;
@WebServlet("/most")

/**
 * Servlet implementation class MostSaledProductServlet
 */
public class MostSaledProductServlet extends HttpServlet {
	
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
			HttpSession session = request.getSession();			

		   	OrderDaoImpl orderdao= new OrderDaoImpl();
			Product product=orderdao.mostsaledproduct(fromdate, todate);
			request.setAttribute("Product", product);
			
			response.sendRedirect("mostsuccessproduct.jsp");

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
