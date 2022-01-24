package com.pizza.model;

import java.util.Date;
import java.util.Objects;

import com.pizza.model.Product;

public class Order {
		private int orderid; 
		private User user;
		private Product product;
		private int quantity;
		private Double price;
		private Date orderdate;
		private String status;
		
		
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getOrderid() {
			return orderid;
		}
		public void setOrderid(int orderid) {
			this.orderid = orderid;
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
		public Date getOrderdate() {
			return orderdate;
		}
		public void setOrderdate(Date orderdate) {
			this.orderdate = orderdate;
		}
		public Order(User user, Product product, int quantity, Double price, java.util.Date orderdate2) {
			super();
			this.user = user;
			this.product = product;
			this.quantity = quantity;
			this.price = price;
			this.orderdate = orderdate2;
		}
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public Order(int orderid, User user, Product product, int quantity, Double price, Date orderdate,
				String status) {
			super();
			this.orderid = orderid;
			this.user = user;
			this.product = product;
			this.quantity = quantity;
			this.price = price;
			this.orderdate = orderdate;
			this.status = status;
		}
		public Order(User user, Product product, int quantity, Double price, java.util.Date orderdate2,String status) {
			super();
			this.user = user;
			this.product = product;
			this.quantity = quantity;
			this.price = price;
			this.orderdate = orderdate2;
			this.status=status;
		}

		@Override
		public String toString() {
			return "Order \nuser=" + user + ", \nproduct=" + product + ", \nquantity=" + quantity + ", price=" + price
					+ ", orderdate=" + orderdate + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(orderdate, price, product, quantity, user);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Order other = (Order) obj;
			return Objects.equals(orderdate, other.orderdate) && Objects.equals(price, other.price)
					&& Objects.equals(product, other.product) && quantity == other.quantity
					&& Objects.equals(user, other.user);
		}
				
}
