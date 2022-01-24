package com.pizza.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pizza.Interface.CartDao;
import com.pizza.model.Cart;
import com.pizza.model.Order;
import com.pizza.model.Product;
import com.pizza.model.User;
import com.pizza.utill.ConnectionUtill;

public class CartDaoImpl implements CartDao{
	public  int insertCart(Cart carts) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
	String cartQuery="insert into cart(user_id,product_id,quantity,total_prize) values(?,?,?,?)";	
	PreparedStatement pstmt = null;
	int cart1=0;
	try {
		pstmt = c.prepareStatement(cartQuery);
		UserDaoImpl userdao=new UserDaoImpl();
		ProductDaoImpl productdao=new ProductDaoImpl();
		int userid=userdao.finduserid(carts.getUser());
		ResultSet proId=productdao.findProductId(carts.getProduct());
		if(proId.next()) {
		pstmt.setInt(1,userid);
		pstmt.setInt(2, proId.getInt(1));
		pstmt.setInt(3,carts.getQuantity());
		pstmt.setDouble(4, carts.getPrice());		
		cart1 = pstmt.executeUpdate();
		System.out.println("added to cart suuccessfully");
		}
	} catch (SQLException e) {
		// catch the exception and get that message
		e.printStackTrace();
		System.out.println("Value not Setted in the query");
	}		
	return cart1;	
}

public List<Cart> showcart(User user){
	UserDaoImpl dao=new UserDaoImpl();
	int userid=dao.finduserid(user);
	List<Cart> cartList = new ArrayList<Cart>();
	String query="select * from cart where user_id="+userid;
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	Statement stmt=null;
	try {
		 stmt=c.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
			UserDaoImpl userdao=new UserDaoImpl();
			ProductDaoImpl productdao=new ProductDaoImpl();
			OrderDaoImpl orderdao = new OrderDaoImpl();
			while (rs.next()) {
				User user1=userdao.findid(rs.getInt(2));
				Product product=productdao.findid(rs.getInt(3));
				Cart cart=new Cart(rs.getInt(1),user1,product,rs.getInt(4),rs.getDouble(5));
				cartList.add(cart);	
				System.out.println("cartlist"+cartList);
				System.out.println("cart"+cart);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return cartList;
}

public int delete(int deleteid) {
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();	
//int productid=findProductId(proId, size);
String deleteQuery="delete from cart where cart_id=?";
PreparedStatement pstmt;
int prod1d =0;
try {	
	pstmt= c.prepareStatement(deleteQuery);
	pstmt.setInt(1,deleteid);

//	pstmt.setString(1, produce2.getProductname());	
	prod1d = pstmt.executeUpdate();
	System.out.println("delete");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("error in query");
}
return prod1d;
}

}	

