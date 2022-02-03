package com.pizza.exception;

public class UserNotFound extends Exception{
	@Override
public String getMessage() {

	return "Username or password in currect";			
}	
	
}
