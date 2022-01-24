package com.pizza.model;

import java.util.Objects;

public class User {
	private int userid;
	private String username;
	private long phonenumber;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
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
		// TODO Auto-generated constructor stub
	}
	
	public User(int userid) {
		// TODO Auto-generated constructor stub
		this.userid=userid;
	}
	
	
	public User(String username, long phonenumber, String email, String address,  String password,double wallet,String type) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.phonenumber = phonenumber;
		this.email = email;
		this.address = address;
		this.wallet = wallet;
		this.password = password;
		this.type=type;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", phonenumber=" + phonenumber + ", email=" + email
				+ ", address=" + address + ", wallet=" + wallet + ", password=" + password + ", type=" + type + "]";
	}

	

	
	
}
