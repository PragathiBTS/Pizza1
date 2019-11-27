package com.hcl.pizzaorder.service;

import com.hcl.pizzaorder.bean.*;

public interface IPizzaOrderService {
	public int placeOrder(Customer customer, Customer pizza) throws PizzaException; 
	public void PizzaOrdergetOrderDetails(int orderid) throws PizzaException;
}


