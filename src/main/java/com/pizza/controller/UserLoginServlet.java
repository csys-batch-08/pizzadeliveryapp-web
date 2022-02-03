package com.pizza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.dao.CartDaoImpl;
import com.pizza.dao.OrderDaoImpl;
import com.pizza.dao.ProductDaoImpl;
import com.pizza.dao.UserDaoImpl;
import com.pizza.exception.UserNotFound;
import com.pizza.model.Cart;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;

@WebServlet("/Login")

/**
 * Servlet implementation class Login
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	
	/**HttpServletRequest
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		HttpSession session=request.getSession();
		
		String email=request.getParameter("email");
		
		System.out.println(email);
		String password=request.getParameter("password");
		System.out.println(password);
		UserDaoImpl userdao=new UserDaoImpl();
		User user = userdao.validateUser(email, password);			
		session.setAttribute("user", user);	
		
		//user product view
		ProductDaoImpl dao=new ProductDaoImpl();
		List<Product> list=dao.showProduct();
		session.setAttribute("productlist", list);
		
		//adminproduct view
		List<Product> adminlist=dao.adiminshowProduct();
		session.setAttribute("productList", adminlist);
	                                                   
		List<User> userlist=userdao.showuser();
		session.setAttribute("userList", userlist);
		
		OrderDaoImpl orderdao=new OrderDaoImpl();
		List<Order> orderlist=orderdao.showorder(user);
		session.setAttribute("orderList", orderlist);
				
		CartDaoImpl cartdao=new CartDaoImpl();
		List<Cart> cartlist=cartdao.showcart(user);
		session.setAttribute("cartList", cartlist);
		try {
		if(user.getType().equals("Admin")) {			
			response.sendRedirect("adddeleteupdate.jsp");
		}		
		else if(user.getType().equals("user")) {
			response.sendRedirect("showproducts.jsp");			
		}
		else
		{		
			throw new UserNotFound();
     	}
		}		
		catch(UserNotFound l) {
			session.setAttribute("notfound", l.getMessage());
			response.sendRedirect("userlogin.jsp");			
	}
	}
}