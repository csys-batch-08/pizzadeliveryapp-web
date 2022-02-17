package com.pizza.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pizza.dao.InvoicebillDao;
import com.pizza.model.Invoicebill;
import com.pizza.model.User;
import com.pizza.utill.ConnectionUtill;

public class InvoicebillDaoImpl implements InvoicebillDao {

	public ResultSet showBill(User user) {
		String showQuery = "select u.user_name,u.phonenumber,u.email,u.address,o.product_id,o.quantity,o.total_prize,o.order_date "
				+ "from users u join orders o on u.user_id=o.user_id";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(showQuery);
			rs = preparedstatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return rs;
	}

	public int insert(Invoicebill invoice) {
		String insertQuery = "insert into bills (order_id,Delivery_date,user_id) values (?,sysdate+?,?)";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		int i = 0;
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(insertQuery);
			i = preparedstatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}
		return i;
	}

}