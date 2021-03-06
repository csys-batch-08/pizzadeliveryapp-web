package com.pizza.model;

import java.util.Objects;

public class Product {
	
	private int productId;
	private String productName;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	
	
	public Product(int productId, String productName, String size, Double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.size = size;
		this.price = price;
	}
	public Product(String productName,String size,Double price) {
		super();
		this.productName = productName;
		this.size = size;
		this.price = price;
	}
	
	public Product(int productId, String productName, String size, Double price, String status) {
		super();
		this.productId = productId;
		this.productName = productName;
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
		return "Product [productId=" + productId + ", productname=" + productName + ", size=" + size + ", price="
				+ price + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, productId, productName, size, status);
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
				&& Objects.equals(productName, other.productName) && Objects.equals(size, other.size)
				&& Objects.equals(status, other.status);
	}
	
}
