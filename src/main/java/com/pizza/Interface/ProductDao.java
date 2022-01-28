package com.pizza.Interface;

import java.sql.ResultSet;
import java.util.List;

import com.pizza.model.Product;

public interface ProductDao {

	public List<Product> showProduct();
	public  int insertproduct(Product products);
	public  int updated(String productname, String size,Double price,int productid);
	public int delete(int deleteid);
	public  Product findProductId(Product product);
	public  Product findProduct(int id,String proname,String prosize,double price);
	public Product findid(int id);
	public List<Product> productsearch(String search);
}
