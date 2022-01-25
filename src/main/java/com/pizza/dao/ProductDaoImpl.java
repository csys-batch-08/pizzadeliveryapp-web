package com.pizza.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pizza.Interface.ProductDao;
import com.pizza.model.Admin;
import com.pizza.model.Product;
import com.pizza.model.User;
//import com.dao.ConnectionUtill;
import com.pizza.utill.ConnectionUtill;

public class ProductDaoImpl implements ProductDao{

	public List<Product> showProduct() {
		List<Product> productsList = new ArrayList<Product>();
		String prod = "select product_id,product_name,product_size,price from products";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		Product products = null;
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(prod);
		//	System.out.println(rs.getString(2));
			while (rs.next()) {
				products = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));				
				productsList.add(products);	
			}
		} catch (SQLException e) {
			System.out.println("error on query");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsList;	
	}
	
	public  int insertproduct(Product products) {
		ConnectionUtill con = new ConnectionUtill();
		String query = "insert into products(product_name,product_size,price)values(?,?,?)";
		Connection c = con.getDbconnection();
		PreparedStatement pstmt = null;
		int i =0;
		try {
			pstmt = c.prepareStatement(query);
			pstmt.setString(1, products.getProductname());
			pstmt.setString(2, products.getSize());
			pstmt.setDouble(3, products.getPrice());
			i= pstmt.executeUpdate();
			System.out.println(i + "row inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not Setted in the query");
		}
		return i;
	}
	

	
	public  int updated(String productname, String size,Double price,int productid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();	
		String updateQuery="update products set product_name=?,product_size=?,price=? where product_id=?";
		int prodid=0;
		try {
			PreparedStatement pstmt= c.prepareStatement(updateQuery);	
			pstmt.setString(1,productname);
		     pstmt.setString(2,size);
		     pstmt.setDouble(3, price);
		     pstmt.setInt(4 ,productid);
			    prodid = pstmt.executeUpdate();
			     System.out.println("updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in query");
		}
		return prodid;	
	}

	public int delete(int deleteid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();	
	//int productid=findProductId(proId, size);
	String deleteQuery="delete from products where product_id=?";
	PreparedStatement pstmt;
	int prod1d =0;
	try {	
		pstmt= c.prepareStatement(deleteQuery);
		pstmt.setInt(1,deleteid);

//		pstmt.setString(1, produce2.getProductname());	
		prod1d = pstmt.executeUpdate();
		System.out.println("delete");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("error in query");
	}
	return prod1d;
}

	
	public  ResultSet findProductId(Product product) {
		String query="select product_id,price from products where product_name=? and product_size=? ";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		PreparedStatement pstmt=null;
		int proId=0;
		ResultSet rs=null;
		try {
			pstmt = c.prepareStatement(query);
			pstmt.setString(1, product.getProductname());
			pstmt.setString(2,product.getSize() );
			 rs=pstmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return rs;
	}

	public  Product findProduct(String proname,String prosize) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findProductQuery = "select * from products where product_name=? and product_size=?";
		PreparedStatement pstmt=null; 
		Product product2 = null;
		try {
			pstmt = c.prepareStatement(findProductQuery);
			pstmt.setString(1, proname);
			pstmt.setString(2, prosize);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				product2 = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product2;
	}
	
	public Product findid(int id) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findid="select * from Products where product_id='"+id+"'" ;
		Statement stmt=null;
		Product productid1=null;
		try {
			 stmt=c.createStatement();
			 ResultSet rs = stmt.executeQuery(findid);
				while (rs.next()) {
					productid1 = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return productid1;
	}

	public ResultSet search(String search) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String query = "select product_id,product_name,product_size,price from products where lower(product_name) like '"+search.toLowerCase()+"%'";
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			 pstmt=c.prepareStatement(query);	
			  rs=pstmt.executeQuery();
			 return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return rs;		
	}
public List<Product> productsearch(String search){
	List<Product> productsList = new ArrayList<Product>();
	String query="select product_id,product_name,product_size,price from products where product_name like '"+search+ "%'";
	ConnectionUtill con = new ConnectionUtill();
	Connection c = con.getDbconnection();
	PreparedStatement pstmt;
	ResultSet rs;
	Product products;
	System.out.println("hi guys");
	System.out.println(query);
	try {
		 pstmt=c.prepareStatement(query);
		 rs=pstmt.executeQuery();
		 while (rs.next()) {
				products = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));				
				productsList.add(products);	
				System.out.println("search"+productsList);
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return productsList;	
	}
}