package com.pizza.Interface;

import java.util.List;

import com.pizza.model.Cart;
import com.pizza.model.User;

public interface CartDao {

	public  int insertCart(Cart carts);
	public List<Cart> showcart(User user);
	
}
