package com.pizza.Interface;

import com.pizza.model.User;

public interface UserDao {
	public  void insert(User users);
	public  double update(Double wallet,String useremail);
	public   User validateUser(String emailid,String password1);
	public  int finduserid(User user);
	public  User finduser(String useremail);
	public User findid(int id);
	
}
