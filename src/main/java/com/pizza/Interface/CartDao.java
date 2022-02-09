package com.pizza.Interface; 

import java.util.List;

import com.pizza.model.Cart;
import com.pizza.model.User;

public interface CartDao {

	public List<Cart> showcart(User user);
	public int delete(int deleteid);
}
