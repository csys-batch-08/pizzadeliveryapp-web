package com.pizza.exception;

public class InactiveUserException extends Exception {
	@Override
	public String getMessage() {

		return "Your account is inactine plz create another account";			
	}	
}
