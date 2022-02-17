package com.pizza.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pizza.dao.ProductDao;
import com.pizza.model.Product;
import com.pizza.utill.ConnectionUtill;

public class ProductDaoImpl implements ProductDao {

	public List<Product> showProduct() {
		List<Product> productsList = new ArrayList<Product>();
		String prod = "select product_id,product_name,product_size,price,status from products where status='Available' order by product_name";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		Product products = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(prod);
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				products = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5));
				productsList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return productsList;
	}

	public List<Product> adiminshowProduct() {
		List<Product> productsList = new ArrayList<Product>();
		String prod = "select product_id,product_name,product_size,price,status from products  order by product_name";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		Product products = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(prod);
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				products = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5));
				productsList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return productsList;
	}

	public int insertproduct(Product products) {
		ConnectionUtill con = new ConnectionUtill();
		String query = "insert into products(product_name,product_size,price)values(?,?,?)";
		Connection connection = con.getDbconnection();
		PreparedStatement preparedstatement = null;
		int i = 0;
		try {			
			
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, products.getProductName());
			preparedstatement.setString(2, products.getSize());
			preparedstatement.setDouble(3, products.getPrice());
			i = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}
		return i;
	}

	public int updated(String productname, String size, Double price, String status, int productid) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String updateQuery = "update products set product_name=?,product_size=?,price=?,status=? where product_id=?";
		int prodid = 0;
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(updateQuery);
			preparedstatement.setString(1, productname);
			preparedstatement.setString(2, size);
			preparedstatement.setDouble(3, price);
			preparedstatement.setString(4, status);
			preparedstatement.setInt(5, productid);
			prodid = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, null);
		}
		return prodid;
	}

	public Product findProductId(Product product) {
		String query = "select product_id,price from products where product_name=? and product_size=? ";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		Product product2 = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, product.getProductName());
			preparedstatement.setString(2, product.getSize());
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				product2 = new Product(rs.getInt(1), product.getProductName(), product.getSize(), rs.getDouble(2));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return product2;
	}

	public Product findProduct(int id, String proname, String prosize, double price) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String findProductQuery = "select product_id,product_name,product_size,price from products where product_name=? and product_size=?";
		PreparedStatement preparedstatement = null;
		Product product2 = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(findProductQuery);
			preparedstatement.setString(1, proname);
			preparedstatement.setString(2, prosize);
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				product2 = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return product2;
	}

	public Product findid(int id) {
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		String findid = "select product_id,product_name,product_size,price from Products where product_id=?";
		PreparedStatement preparedstatement = null;
		Product productid1 = null;
		ResultSet rs = null;
		try {
			preparedstatement = connection.prepareStatement(findid);
			preparedstatement.setInt(1, id);
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				productid1 = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return productid1;
	}

	public List<Product> productsearch(String search) {
		List<Product> productsList = new ArrayList<Product>();
		String query = "select product_id,product_name,product_size,price from products where product_name like ? and status='Available'";
		ConnectionUtill con = new ConnectionUtill();
		Connection connection = con.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		Product products;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, "%" + search + "%");
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				products = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));
				productsList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(connection, preparedstatement, rs);
		}
		return productsList;
	}
}