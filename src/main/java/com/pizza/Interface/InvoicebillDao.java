package com.pizza.Interface;

import java.sql.ResultSet;

import com.pizza.model.Invoicebill;
import com.pizza.model.User;

public interface InvoicebillDao {

public ResultSet showBill(User user) ;
public int insert(Invoicebill invoice);
}
