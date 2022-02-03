package com.pizza.dao;

import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pizza.Interface.UserDao;
import com.pizza.model.Product;
import com.pizza.model.User;
import com.pizza.utill.ConnectionUtill;

	public class UserDaoImpl implements  UserDao {		
	public List<User> showuser() {
		List<User> userlist = new ArrayList<User>();
		String userquery = "select 	user_id,user_name,phonenumber,email,address,wallet,password,role from users";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		PreparedStatement pstmt=null;
		User users = null;
		ResultSet rs = null ;
		try {
			
			pstmt= c.prepareStatement(userquery);	
			rs= pstmt.executeQuery();
			while (rs.next()) {
				users = new User(rs.getString(2),rs.getLong(3), rs.getString(4), rs.getString(5),rs.getString(7),rs.getDouble(6),rs.getString(8));				
				userlist.add(users);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtill.close(c, pstmt ,rs);
		}
		return userlist;	
	}
	
	public  void  insert(User users) {
		ConnectionUtill con=new ConnectionUtill();
		String query="insert into users(user_name,phonenumber,email,address,password)values(?,?,?,?,?)";
			Connection c=con.getDbconnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = c.prepareStatement(query);
				pstmt.setString(1, users.getUsername());
				pstmt.setLong(2, users.getPhonenumber());
				pstmt.setString(3, users.getEmail());
				pstmt.setString(4, users.getAddress());
				pstmt.setString(5, users.getPassword());
				 pstmt.executeUpdate();
				System.out.println(" row inserted");
			} catch (SQLException e) 
			{
			// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Value not Setted in the query");
			}	
			finally {
				ConnectionUtill.close(c, pstmt ,null);
			}
			
	} 
	
	public  int recharge(User user) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();	
		String updateQuery="update users set wallet=? where email=?";	
		int result=0;
		PreparedStatement pstmt = null;
		try {
			
			 pstmt= c.prepareStatement(updateQuery);	
			pstmt.setDouble(1,user.getWallet());
		    pstmt.setString(2, user.getEmail());
			    result = pstmt.executeUpdate();
			     System.out.println("updated");		
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in query");
		}
		finally {
			ConnectionUtill.close(c, pstmt ,null);
		}
		return result;	
	}	

	public   User validateUser(String email,String password) {
		ConnectionUtill con=new ConnectionUtill();
		Connection c=con.getDbconnection();
		String query="select user_id,user_name,phonenumber,email,address,wallet,password,role from users where email='"+email+"' and password='"+password+"'";
		User user=null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		System.out.println("hello");
		try {
			 pstmt= c.prepareStatement(query);
			 rs=pstmt.executeQuery(query);
			if(rs.next())
			{
			//	System.out.println("user"+rs.getString(2));
			user=new User(rs.getString(2),rs.getLong(3), rs.getString(4), rs.getString(5),rs.getString(7),rs.getDouble(6),rs.getString(8));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("statement error");
		}
		finally {
			ConnectionUtill.close(c, pstmt ,rs);
		}
		return user;
	}
	
	public  int finduserid(User user) {
		String query="select user_id from users where email=?";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int userid=0;
		try {
			pstmt = c.prepareStatement(query);
			pstmt.setString(1, user.getEmail());			
			 rs=pstmt.executeQuery();
			while(rs.next()) {
				userid=rs.getInt(1);
				return userid;				
			}	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			ConnectionUtill.close(c, pstmt ,rs);
		}
		return userid;		
	}
	
		public  User finduser(String useremail) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findProductQuery = "select user_id,user_name,phonenumber,email,address,wallet,password,role from users where email=?";
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		try {
			 pstmt = c.prepareStatement(findProductQuery);
			pstmt.setString(1, useremail);
			 rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString(2),rs.getLong(3), rs.getString(4), rs.getString(5),rs.getString(7),rs.getDouble(6),rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtill.close(c, pstmt ,rs);
		}
		return user;
	}
	
	public User findid(int id) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findid="select user_id,user_name,phonenumber,email,address,wallet,password,role from users where user_id='"+id+"'" ;
		PreparedStatement pstmt=null;
		User userid=null;
		ResultSet rs = null ;
		try {
			pstmt = c.prepareStatement(findid);
			  rs = pstmt.executeQuery();
				while (rs.next()) {
					userid = new User(rs.getString(2),rs.getLong(3), rs.getString(4), rs.getString(5),rs.getString(7),rs.getDouble(6),rs.getString(8));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtill.close(c, pstmt ,rs);
		}
		return userid;
	}
	
	public  int updateduser(String name, String email,long pnumber,String address,String password,int userid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();	
		String updateQuery="update users set user_name=?,email=?,phonenumber=?,address=?,password where user_id=?";
		int prodid=0;
		PreparedStatement pstmt = null;
		try {
			 pstmt= c.prepareStatement(updateQuery);	
			pstmt.setString(1,name);
		     pstmt.setString(2,email);
		     pstmt.setLong(3, pnumber);
		    pstmt.setString(4,address);	
		    pstmt.setString(5, password);
		     pstmt.setInt(6 ,userid);
			    prodid = pstmt.executeUpdate();
			     System.out.println("updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in query");
		}
		finally {
			ConnectionUtill.close(c, pstmt ,null);
		}
		return prodid;	
	}
	
	public  String findemail(User user) {
		String query="select email from users where user_id=?";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		PreparedStatement pstmt=null;
		String useremail=null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			
			 rs=pstmt.executeQuery();
			while(rs.next()) {
				useremail=rs.getString(1);
				return useremail;
			}	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			ConnectionUtill.close(c, pstmt ,rs);
		}
		return useremail;		
	}
	
	public int updateuserWallet(User user, double amount) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String Query = "update users set wallet=wallet+? where email=?";
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			System.out.println(user.getWallet());
			pstmt = c.prepareStatement(Query);
			pstmt.setDouble(1, amount);
			pstmt.setString(2, user.getEmail());
			i = pstmt.executeUpdate();
			System.out.println(i + "updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtill.close(c, pstmt ,null);
		}
		return i;

	}

	public  double update(Double wallet,String useremail) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();	
		String select="select wallet from users where email=?";
		String updateQuery="update users set wallet=wallet-? where email=?";	
		double well=0;		
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		double wallet1 =0;
		try {
			 pstmt1= c.prepareStatement(select);
			pstmt1.setString(1, useremail);
			 rs=pstmt1.executeQuery();
			while(rs.next()) {
			  wallet1 = rs.getDouble(1);
			}
			if(wallet1>wallet) {
			PreparedStatement pstmt11= c.prepareStatement(updateQuery);	
			pstmt11.setDouble(1,wallet);
		    pstmt11.setString(2,useremail);
			    well = pstmt11.executeUpdate();
			     System.out.println("updated");
		}else {		
			System.out.println("low balance");
		}
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in query");
		}
		finally {
			ConnectionUtill.close(c, pstmt1 ,rs);
		}
		return well;	
	}
public boolean inactive(String email) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	String inactive="update users set role='Inactive' where email='"+email+"'";
	PreparedStatement pstmt = null;
	boolean b=false;
	try {
		pstmt = c.prepareStatement(inactive);
		b=pstmt.executeUpdate() >0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("error in query");
	}
	finally {
		ConnectionUtill.close(c, pstmt ,null);
	}
	return b;
	}
}

	
