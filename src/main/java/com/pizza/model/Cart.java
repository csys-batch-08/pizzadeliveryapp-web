package com.pizza.model;

import java.util.Objects;

import com.pizza.model.Product;

public class Cart {
	private int id;

	private User user;
	private Product product;
	private int quantity;
	private Double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Cart(User user, Product product, int quantity, Double price) {
		super();
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Cart(int id,User user,  Product product, int quantity, Double price) {
		super();
		this.id = id;
		this.user = user;
		
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, product, quantity, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(price, other.price) && Objects.equals(product, other.product)
				&& quantity == other.quantity && Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "Cart [user=" + user + ", product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
