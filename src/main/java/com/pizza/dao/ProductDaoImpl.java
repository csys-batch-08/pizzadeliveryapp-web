package com.pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pizza.interfaces.ProductDao;
import com.pizza.model.Product;
import com.pizza.utill.ConnectionUtill;

public class ProductDaoImpl implements ProductDao {

	public List<Product> showProduct() {
		List<Product> productsList = new ArrayList<Product>();
		String prod = "select product_id,product_name,product_size,price,status from products where status='Available' order by product_name";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		Product products = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(prod);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				products = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5));
				productsList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return productsList;
	}

	public List<Product> adiminshowProduct() {
		List<Product> productsList = new ArrayList<Product>();
		String prod = "select product_id,product_name,product_size,price,status from products  order by product_name";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		Product products = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(prod);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				products = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5));
				productsList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return productsList;
	}

	public int insertproduct(Product products) {
		ConnectionUtill con = new ConnectionUtill();
		String query = "insert into products(product_name,product_size,price)values(?,?,?)";
		Connection c = con.getDbconnection();
		PreparedStatement pstmt = null;
		int i = 0;
		try {			
			
			pstmt = c.prepareStatement(query);
			pstmt.setString(1, products.getProductname());
			pstmt.setString(2, products.getSize());
			pstmt.setDouble(3, products.getPrice());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, null);
		}
		return i;
	}

	public int updated(String productname, String size, Double price, String status, int productid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String updateQuery = "update products set product_name=?,product_size=?,price=?,status=? where product_id=?";
		int prodid = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = c.prepareStatement(updateQuery);
			pstmt.setString(1, productname);
			pstmt.setString(2, size);
			pstmt.setDouble(3, price);
			pstmt.setString(4, status);
			pstmt.setInt(5, productid);
			prodid = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, null);
		}
		return prodid;
	}

	public Product findProductId(Product product) {
		String query = "select product_id,price from products where product_name=? and product_size=? ";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product2 = null;
		try {
			pstmt = c.prepareStatement(query);
			pstmt.setString(1, product.getProductname());
			pstmt.setString(2, product.getSize());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				product2 = new Product(rs.getInt(1), product.getProductname(), product.getSize(), rs.getDouble(2));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return product2;
	}

	public Product findProduct(int id, String proname, String prosize, double price) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findProductQuery = "select product_id,product_name,product_size,price from products where product_name=? and product_size=?";
		PreparedStatement pstmt = null;
		Product product2 = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(findProductQuery);
			pstmt.setString(1, proname);
			pstmt.setString(2, prosize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				product2 = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return product2;
	}

	public Product findid(int id) {
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		String findid = "select product_id,product_name,product_size,price from Products where product_id='" + id + "'";
		PreparedStatement pstmt = null;
		Product productid1 = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(findid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				productid1 = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return productid1;
	}

	public List<Product> productsearch(String search) {
		List<Product> productsList = new ArrayList<Product>();
		String query = "select product_id,product_name,product_size,price from products where product_name like '"
					+ search + "%' and status='Available'";
		ConnectionUtill con = new ConnectionUtill();
		Connection c = con.getDbconnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product products;
		try {
			pstmt = c.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				products = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));
				productsList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(c, pstmt, rs);
		}
		return productsList;
	}
}