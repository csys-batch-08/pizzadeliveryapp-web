package com.pizza.model;

import java.util.Objects;

public class Product {
	
	private int productId;
	private String productname;
	private String size;
	private Double price;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public Product(int productId, String productname, String size, Double price) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.size = size;
		this.price = price;
	}
	public Product(String productname,String size,Double price) {
		super();
		this.productname = productname;
		this.size = size;
		this.price = price;
	}
	
	public Product(int productId, String productname, String size, Double price, String status) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.size = size;
		this.price = price;
		this.status = status;
	}
	public Product() {
		super();
	}
	public Product(int productid2) {
	}
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productname=" + productname + ", size=" + size + ", price="
				+ price + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, productId, productname, size, status);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(price, other.price) && productId == other.productId
				&& Objects.equals(productname, other.productname) && Objects.equals(size, other.size)
				&& Objects.equals(status, other.status);
	}
	
}
