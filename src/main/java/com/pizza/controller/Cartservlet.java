package com.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.CartDaoImpl;
import com.pizza.dao.OrderDaoImpl;
import com.pizza.dao.UserDaoImpl;
import com.pizza.model.Cart;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;
@WebServlet("/cart")
/**
 * Servlet implementation class Cartservlet
 */
public class Cartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();

		User user=(User) session.getAttribute("user");
		System.out.println("user "+ user);		
		
		Product product=(Product) session.getAttribute("productid");
		System.out.println("product "+product);		

//		int quantity=Integer.parseInt(request.getParameter("qty"));
//		System.out.println(quantity);
//		
//		Double productprice=Double.parseDouble(request.getParameter("price"));
//		System.out.println(productprice);
//		
		CartDaoImpl dao=new CartDaoImpl();
		Cart cart=new Cart(user,product,0,0.0);
		int i=	dao.insertCart(cart);			
		response.sendRedirect("Showproducts.jsp");
//
//		UserDaoImpl dao=new UserDaoImpl();
//		dao.update(productprice,user.getEmail() );
//				OrderDaoImpl orderdao=new OrderDaoImpl();
//				Order order=new Order(user,product,quantity,productprice,null);
//				int i=orderdao.orderproduct(order);
						
	}
}
