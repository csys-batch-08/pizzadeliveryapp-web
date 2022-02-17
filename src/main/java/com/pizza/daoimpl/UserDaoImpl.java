package com.pizza.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pizza.dao.UserDao;
import com.pizza.model.User;
import com.pizza.utill.ConnectionUtill;

public class UserDaoImpl implements UserDao {
	public List<User> showuser() {
		List<User> userlist = new ArrayList<User>();
		String userquery = "select user_id,user_name,phonenumber,email,address,wallet,password,role from users";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		PreparedStatement preparedstatement = null;
		User users = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(userquery);
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				users = new User(rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getString(7),
						rs.getDouble(6), rs.getString(8));
				users.setUserId(rs.getInt(1));
				userlist.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return userlist;
	}

	public void insert(User users) {
		ConnectionUtill con = new ConnectionUtill();
		String query = "insert into users(user_name,phonenumber,email,address,password)values(?,?,?,?,?)";
		Connection connection = con.getDbconnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, users.getUserName());
			preparedstatement.setLong(2, users.getPhoneNumber());
			preparedstatement.setString(3, users.getEmail());
			preparedstatement.setString(4, users.getAddress());
			preparedstatement.setString(5, users.getPassword());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}

	}

	public int recharge(User user) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String updateQuery = "update users set wallet=? where email=?";
		int result = 0;
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(updateQuery);
			preparedstatement.setDouble(1, user.getWallet());
			preparedstatement.setString(2, user.getEmail());
			result = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}
		return result;
	}

	public User validateUser(String email, String password) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String query = "select user_id,user_name,phonenumber,email,address,wallet,password,role from users where email=? and password=?";
		User user = null;
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		boolean flag = false;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, password);
			flag = preparedstatement.executeUpdate() > 0;
			rs = preparedstatement.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getString(7),
						rs.getDouble(6), rs.getString(8));
				user.setUserId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return user;
	}

	public int finduserid(User user) {
		String query = "select user_id from users where email=?";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection= con.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		int userid = 0;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, user.getEmail());
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				userid = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return userid;
	}

	public User finduser(String useremail) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String findProductQuery = "select user_id,user_name,phonenumber,email,address,wallet,password,role from users where email=?";
		User user = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(findProductQuery);
			preparedstatement.setString(1, useremail);
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getString(7),
						rs.getDouble(6), rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return user;
	}

	public User findid(int id) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String findid = "select user_id,user_name,phonenumber,email,address,wallet,password,role from users where user_id=?";
		PreparedStatement preparedstatement = null;
		User userid = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(findid);
			preparedstatement.setInt(1, id);
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				userid = new User(rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getString(7),
						rs.getDouble(6), rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return userid;
	}

	public int updateduser(String name, String email, long pnumber, String address, String password, int userid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String updateQuery = "update users set user_name=?,email=?,phonenumber=?,address=?,password=? where user_id=?";
		int prodid = 0;
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(updateQuery);
			preparedstatement.setString(1, name);
			preparedstatement.setString(2, email);
			preparedstatement.setLong(3, pnumber);
			preparedstatement.setString(4, address);
			preparedstatement.setString(5, password);
			preparedstatement.setInt(6, userid);
			prodid = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}
		return prodid;
	}

	public String findemail(User user) {
		String query = "select email from users where user_id=?";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		PreparedStatement preparedstatement = null;
		String useremail = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, user.getEmail());

			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				useremail = rs.getString(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return useremail;
	}

	public int updateuserWallet(User user, double amount) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String recharge = "update users set wallet=wallet+? where email=?";
		PreparedStatement preparedstatement = null;
		int i = 0;
		try {
			preparedstatement = connection.prepareStatement(recharge);
			preparedstatement.setDouble(1, amount);
			preparedstatement.setString(2, user.getEmail());
			i = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}
		return i;
	}

	public double update(Double wallet, String useremail) {
		Connection connection = ConnectionUtill.getDbconnection();
		String updateQuery = "update users set wallet=wallet-? where email=?";
		UserDaoImpl userdao=new UserDaoImpl();
		Double wallet1=userdao.wallet(useremail);
		PreparedStatement preparedstatement=null;
		int well = 0;		
		try {	
			if (wallet1 > wallet) {
				preparedstatement = connection.prepareStatement(updateQuery);
				preparedstatement.setDouble(1, wallet);
				preparedstatement.setString(2, useremail);
				well = preparedstatement.executeUpdate();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}
		return well;
	}	
	public Double wallet(String email) {
		Connection connection = ConnectionUtill.getDbconnection();
		String query2 = "select wallet from users where email=?";
		PreparedStatement preparedstatement = null;
		double wallet = 0;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(query2);
			preparedstatement.setString(1, email);
			rs = preparedstatement.executeQuery();
			if (rs.next()) {
				wallet = rs.getDouble(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return wallet;
	}
	public boolean inactive(String email) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String inactive = "update users set role='Inactive' where email=?";
		PreparedStatement preparedstatement = null;
		boolean b = false;
		try {
			preparedstatement = connection.prepareStatement(inactive);
			preparedstatement.setString(1, email);
			b = 	preparedstatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}
		return b;
	}
}
