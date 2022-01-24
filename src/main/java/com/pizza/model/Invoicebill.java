package com.pizza.model;

import java.util.Objects;

import com.pizza.model.Order;

public class Invoicebill {
	private Order order;
	private User user;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Invoicebill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoicebill(Order order, User user) {
		super();
		this.order = order;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Invoicebill [order=" + order + ", user=" + user + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoicebill other = (Invoicebill) obj;
		return Objects.equals(order, other.order) && Objects.equals(user, other.user);
	}
	
}
