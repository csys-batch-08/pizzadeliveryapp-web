package com.pizza.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private long phoneNumber;
	private String email;
	private String address;
	private Double wallet;
	private String password;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getWallet() {
		return wallet;
	}
	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	
	public User(int userId) {
		this.userId=userId;
	}
	
	
	public User(String userName, long phoneNumber, String email, String address,  String password,double wallet,String type) {
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.wallet = wallet;
		this.password = password;
		this.type=type;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", address=" + address + ", wallet=" + wallet + ", password=" + password + ", type=" + type + "]";
	}	
}
