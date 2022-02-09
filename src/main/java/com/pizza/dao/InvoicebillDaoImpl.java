package com.pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pizza.Interface.InvoicebillDao;
import com.pizza.model.Invoicebill;
import com.pizza.model.Order;
import com.pizza.model.User;
//import com.dao.ConnectionUtill;
import com.pizza.utill.ConnectionUtill;

public class InvoicebillDaoImpl implements InvoicebillDao {

	public ResultSet showBill(User user) {
		String showQuery = "select u.user_name,u.phonenumber,u.email,u.address,o.product_id,o.quantity,o.total_prize,o.order_date from users u join orders o on u.user_id=o.user_id";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(showQuery);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return rs;
	}

	public int insert(Invoicebill invoice) {
		String insertQuery = "insert into bills (order_id,Delivery_date,user_id) values (?,sysdate+?,?)";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		int i = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = c.prepareStatement(insertQuery);
			i = pstmt.executeUpdate();
			System.out.println(i + "inserted");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, null);
		}
		return i;
	}

}