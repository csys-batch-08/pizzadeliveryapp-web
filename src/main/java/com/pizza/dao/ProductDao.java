package com.pizza.dao;

import java.util.List;

import com.pizza.model.Product;

public interface ProductDao {

	public List<Product> showProduct();
	public  int insertproduct(Product products);
	public  int updated(String productname, String size,Double price,String status,int productid);
	public List<Product> adiminshowProduct();
	public  Product findProductId(Product product);
	public  Product findProduct(int id,String proname,String prosize,double price);
	public Product findid(int id);
	public List<Product> productsearch(String search);
}
