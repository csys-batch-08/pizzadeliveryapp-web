package com.pizza.exception;

public class Lowbalance  extends Exception{
	@Override
public String getMessage() {

	return "Low Balance in Wallet Please Recharge Here";			
}	
	
}
