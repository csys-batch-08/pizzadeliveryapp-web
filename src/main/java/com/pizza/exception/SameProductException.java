package com.pizza.exception;

public class SameProductException extends Exception{
	@Override
public String getMessage() {

	return "Product is already added";			
}	
}
