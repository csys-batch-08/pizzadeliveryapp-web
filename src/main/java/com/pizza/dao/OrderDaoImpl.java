package com.pizza.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pizza.interfaces.OrderDao;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;
import com.pizza.utill.ConnectionUtill;

public class OrderDaoImpl implements OrderDao {
	public List<Order> showorder(User user) {
		List<Order> orderList = new ArrayList<Order>();
		String orderlist = "select order_id,user_id,product_id,quantity,total_prize,order_date,status from orders where user_id="
				+ user.getUserid() + " order by order_id desc ";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;
		try {
			pstmt = c.prepareStatement(orderlist);
			rs = pstmt.executeQuery();
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			while (rs.next()) {
				User user1 = userdao.findid(rs.getInt(2));
				Product product = productdao.findid(rs.getInt(3));
				order = new Order(rs.getInt(1), user1, product, rs.getInt(4), rs.getDouble(5), rs.getDate(6),rs.getString(7));
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return orderList;
	}

	public int delete(int deleteid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String deleteQuery = "delete from Order where order_id=?";
		PreparedStatement pstmt = null;
		int prod1d = 0;
		try {
			pstmt = c.prepareStatement(deleteQuery);
			pstmt.setInt(1, deleteid);
			prod1d = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, null);
		}
		return prod1d;
	}

	public Order findid(int id) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findid = "select order_id,user_id,product_id,quantity,total_prize,order_date,status from orders where order_id='"
				+ id + "'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order orderid = null;
		try {
			pstmt = c.prepareStatement(findid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderid = new Order();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return orderid;
	}

	public ResultSet orderdetails(int id) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findid = "select order_id,user_id,product_id,quantity,total_prize,order_date,status from orders where user_id='"
				+ id + "'";
		PreparedStatement pstmt = null;
		 
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(findid);
			rs = pstmt.executeQuery(findid);
			while (rs.next()) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return rs;
	}

	public int orderproduct(Order orders) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String query = "insert into orders(user_id,product_id,quantity,total_prize,order_date)values(?,?,?,?,sysdate)";
		PreparedStatement pstmt = null;
		int order1 = 0;
		UserDaoImpl userdao = new UserDaoImpl();
		int userid = userdao.finduserid(orders.getUser());
		OrderDaoImpl orderdao=new OrderDaoImpl();
		Double wallet=orderdao.wallet1(userid);
		try {		
		if (wallet > orders.getPrice()) {
				pstmt = c.prepareStatement(query);
				ProductDaoImpl productdao = new ProductDaoImpl();
				Product proId = productdao.findProductId(orders.getProduct());
				pstmt.setInt(1, userid);
				pstmt.setInt(2, proId.getProductId());
				pstmt.setInt(3, orders.getQuantity());
				pstmt.setDouble(4, orders.getPrice());
				order1 = pstmt.executeUpdate();
			}
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionUtill.close(c, pstmt, null);
			
			}
		return order1;
	}
	public Double wallet1(int userid) {
		Connection c = ConnectionUtill.getDbconnection();
		String query2 = "select wallet from users where user_id=?";
		PreparedStatement stmt = null;
		double wallet = 0;
		ResultSet rs = null;
		try {
			stmt = c.prepareStatement(query2);
			stmt.setInt(1, userid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				wallet = rs.getDouble(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			ConnectionUtill.close(c, stmt, rs);
		}
		return wallet;
	}

	public boolean ordercancel(int orderid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String cancel = "update orders set status='canceled' where order_id='" + orderid + "'";
		PreparedStatement pstmt = null;
		boolean b = false;
		try {
			pstmt = c.prepareStatement(cancel);
			b = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, null);
		}
		return b;
	}

	public Double TotalAmount(Date fromDate, Date toDate) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String total = "select sum(total_prize) from  orders where status='delivered' and order_date between ? and ?";
		PreparedStatement pstmt = null;
		double price = 0;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(total);
			pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
			pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				price = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return price;
	}

	public Product mostsaledproduct(Date fromDate, Date toDate) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String highsaled = "Select DISTINCT products.product_name, products.product_size,sum(orders.total_prize) total_price from orders join "
				+ "products on products.product_id=orders.product_id where orders.order_date between ? and ? group by "
				+ "products.product_name ,products.product_size  order by total_price desc ";
		PreparedStatement pstmt = null;
		Product product = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(highsaled);
			pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
			pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
			rs = pstmt.executeQuery();
			ProductDaoImpl productdao = new ProductDaoImpl();
			if (rs.next()) {
				product = productdao.findProduct(0, rs.getString(1), rs.getString(2), rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return product;
	}

	public Product lowestsaledproduct(Date fromDate, Date toDate) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String sold= "Select DISTINCT products.product_name, products.product_size,sum(orders.total_prize) total_price from orders join products on products.product_id=orders.product_id where orders.order_date between ? and ? group by products.product_name ,products.product_size  order by total_price asc ";
		PreparedStatement pstmt = null;
		Product product = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(sold);
			pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
			pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
			rs = pstmt.executeQuery();
			ProductDaoImpl productdao = new ProductDaoImpl();
			if (rs.next()) {
				product = productdao.findProduct(0, rs.getString(1), rs.getString(2), rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return product;
	}

	public User activeuser(Date fromDate, Date toDate) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String query = " select users.user_name ,sum(orders.total_prize) total_prize from orders join users on users.user_id=orders.user_id"
				+ " where orders.order_date between ? and ? group by users.user_name  order by total_prize desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = c.prepareStatement(query);
			pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
			pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(1), 0, "", "", "", rs.getDouble(2), "");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return user;
	}

	public boolean orderdelivered(int orderid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String cancel = "update orders set status='delivered' where order_id='" + orderid + "'";
		PreparedStatement pstmt = null;
		boolean b = false;
		try {
			pstmt = c.prepareStatement(cancel);
			b = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, null);
		}
		return b;
	}
}
