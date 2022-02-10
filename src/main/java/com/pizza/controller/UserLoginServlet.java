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
import com.pizza.exception.InactiveUserException;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String email=request.getParameter("email");		
		
		String password=request.getParameter("password");
		UserDaoImpl userdao=new UserDaoImpl();		
		User user = userdao.validateUser(email, password);	
		request.setAttribute("user",user);
		ProductDaoImpl dao=new ProductDaoImpl();		
		try {
			if(user!=null) 
			{
			if(user.getType().equals("Admin")) 
			{			
				
			List<Product> adminlist=dao.adiminshowProduct();
			request.setAttribute("productList", adminlist); 
		                                                   
			List<User> userlist=userdao.showuser();
			request.setAttribute("userList", userlist);
			response.sendRedirect("adddeleteupdate.jsp");
	   	}	
		else if(user.getType().equals("user")) 
		{			  
			
			List<Product> list=dao.showProduct();
			request.setAttribute("productlist", list);
			
			OrderDaoImpl orderdao=new OrderDaoImpl();
			List<Order> orderlist=orderdao.showorder(user);
			request.setAttribute("orderList", orderlist);
			
			CartDaoImpl cartdao=new CartDaoImpl();
			List<Cart> cartlist=cartdao.showcart(user);
			request.setAttribute("cartList", cartlist);
			
			response.sendRedirect("showproducts.jsp");		
		}
			else if(user.getType().equals("Inactive")) 
			{
				throw new InactiveUserException();
			}
		}			
		else 
		{					
			throw new UserNotFound();
     	}
		}		
		catch(UserNotFound l) {
			session.setAttribute("notfound", l.getMessage());
			response.sendRedirect("userlogin.jsp");			
	} catch (InactiveUserException e) {
		session.setAttribute("Inactiveuser", e.getMessage() );
		response.sendRedirect("userlogin.jsp");	
		}
	}
}