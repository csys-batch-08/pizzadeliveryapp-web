package com.pizza.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pizza.Interface.OrderDao;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;
//import com.pizzahut.dao.ConnectionUtill;
//import com.dao.Productdao;
import com.pizza.utill.ConnectionUtill;

public class OrderDaoImpl implements OrderDao{
	public List<Order> showorder(User user) {
		UserDaoImpl dao=new UserDaoImpl();
		int userId=dao.finduserid(user);
		List<Order> orderList = new ArrayList<Order>();
		String orderlist = "select * from orders where user_id="+userId+" order by order_id desc " ;
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		Statement stmt;
		Order order = null;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(orderlist);
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			while (rs.next()) {
				Order orders = new Order();
				User user1 = userdao.findid(rs.getInt(2));
				Product product = productdao.findid(rs.getInt(3));
				order = new Order(rs.getInt(1),user1, product, rs.getInt(4), rs.getDouble(5), rs.getDate(6),rs.getString(7));
				orderList.add(order);
				System.out.println(orderList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		return orderList;
	}
	public int delete(int deleteid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		// int productid=findProductId(proId, size);
		String deleteQuery = "delete from Order where order_id=?";
		PreparedStatement pstmt;
		int prod1d = 0;
		try {
			pstmt = c.prepareStatement(deleteQuery);
			pstmt.setInt(1, deleteid);
			prod1d = pstmt.executeUpdate();
			System.out.println("delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in query");
		}
		return prod1d;
	}

	public Order findid(int id) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findid = "select * from order where order_id='" + id + "'";
		Statement stmt = null;
		Order orderid = null;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(findid);
			while (rs.next()) {
				orderid = new Order();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderid;
	}

public ResultSet orderdetails(int id) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	String findid = "select * from order where user_id='" + id + "'";
	Statement stmt = null;
	Order orderid = null;
	ResultSet rs=null;
	try {
		stmt = c.createStatement();
		 rs = stmt.executeQuery(findid);
		while (rs.next()) {
			orderid = new Order();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}

public int orderproduct(Order orders) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	String query2="select wallet from users where user_id=?";
	String query = "insert into orders(user_id,product_id,quantity,total_prize,order_date)values(?,?,?,?,sysdate)";
	PreparedStatement pstmt = null;
	System.out.println("hi");
	double wallet=0;
	int order1 = 0;
	UserDaoImpl userdao = new UserDaoImpl();
	int userid = userdao.finduserid(orders.getUser());
	try {
		PreparedStatement stmt=c.prepareStatement(query2);		
		stmt.setInt(1, userid);
		ResultSet rs = stmt.executeQuery();			
		if(rs.next()) {
			wallet=rs.getDouble(1);			
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	if(wallet>orders.getPrice()) {	
	try {
		pstmt = c.prepareStatement(query);			
		ProductDaoImpl productdao = new ProductDaoImpl();
		ResultSet proId = productdao.findProductId(orders.getProduct());
		if(proId.next())   {			
		pstmt.setInt(1, userid);
		pstmt.setInt(2, proId.getInt(1));
		pstmt.setInt(3, orders.getQuantity());
		pstmt.setDouble(4, orders.getPrice());
		order1 = pstmt.executeUpdate();
		System.out.println("successfully ordered");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("sql error");
	}
	}
	return order1;
}

public boolean ordercancel(int orderid) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	String cancel="update orders set status='canceled' where order_id='"+orderid+"'";
	Statement stmt;
	boolean b=false;	
	try {
		 stmt=c.createStatement();
		b=stmt.executeUpdate(cancel) >0;
		System.out.println("cancelorder");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("error in query");
	}
	return b;
	}


public ResultSet TotalAmount(Date fromDate,Date toDate) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	String Query="select sum(total_prize) from  orders where status='pending' and order_date between ? and ?";
	System.out.println("total price");
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		pstmt = c.prepareStatement (Query);
		pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
		pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
		rs=pstmt.executeQuery();
		
		System.out.println(rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return rs;	
}

public ResultSet mostsaledproduct(Date fromDate,Date toDate) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	String Query="Select DISTINCT products.product_name, products.product_size,sum(orders.total_prize) total_price from orders join products on products.product_id=orders.product_id where orders.order_date between ? and ? group by products.product_name ,products.product_size  order by total_price desc ";
	System.out.println("total price");
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		pstmt = c.prepareStatement (Query);
		pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
		pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
		rs=pstmt.executeQuery();
		System.out.println(rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}

public ResultSet lowestsaledproduct(Date fromDate,Date toDate) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	String Query="Select DISTINCT products.product_name, products.product_size,sum(orders.total_prize) total_price from orders join products on products.product_id=orders.product_id where orders.order_date between ? and ? group by products.product_name ,products.product_size  order by total_price asc ";
	System.out.println("total price");
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		pstmt = c.prepareStatement (Query);
		pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
		pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
		rs=pstmt.executeQuery();
		System.out.println(rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}
	public ResultSet activeuser(Date fromDate,Date toDate) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	String query=" select users.user_name ,sum(orders.total_prize) total_prize from orders join users on users.user_id=orders.user_id where orders.order_date between ? and ? group by users.user_name  order by total_prize desc";
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		pstmt = c.prepareStatement (query);
		pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
		pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
		rs=pstmt.executeQuery();
		System.out.println(rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}
	
	public boolean orderdelivered(int orderid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String cancel="update orders set status='delivered' where order_id='"+orderid+"'";
		Statement stmt;
		boolean b=false;	
		try {
			 stmt=c.createStatement();
			b=stmt.executeUpdate(cancel) >0;
			System.out.println("cancelorder");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in query");
		}
		return b;
		}


}
