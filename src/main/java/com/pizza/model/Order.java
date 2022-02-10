package com.pizza.model;

import java.util.Date;
import java.util.Objects;

public class Order {
		private int orderId; 
		private User user;
		private Product product;
		private int quantity;
		private Double price;
		private Date orderDate;
		private String status;
		
		
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
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
		public Date getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}
		public Order(User user, Product product, int quantity, Double price, java.util.Date orderdate2) {
			super();
			this.user = user;
			this.product = product;
			this.quantity = quantity;
			this.price = price;
			this.orderDate = orderdate2;
		}
		public Order() {
			super();
		}
		
		
		public Order(int orderId, User user, Product product, int quantity, Double price, Date orderDate,
				String status) {
			super();
			this.orderId = orderId;
			this.user = user;
			this.product = product;
			this.quantity = quantity;
			this.price = price;
			this.orderDate = orderDate;
			this.status = status;
		}
		public Order(User user, Product product, int quantity, Double price, java.util.Date orderdate2,String status) {
			super();
			this.user = user;
			this.product = product;
			this.quantity = quantity;
			this.price = price;
			this.orderDate = orderdate2;
			this.status=status;
		}

		@Override
		public String toString() {
			return "Order \nuser=" + user + ", \nproduct=" + product + ", \nquantity=" + quantity + ", price=" + price
					+ ", orderdate=" + orderDate + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(orderDate, price, product, quantity, user);
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
			return Objects.equals(orderDate, other.orderDate) && Objects.equals(price, other.price)
					&& Objects.equals(product, other.product) && quantity == other.quantity
					&& Objects.equals(user, other.user);
		}
				
}
