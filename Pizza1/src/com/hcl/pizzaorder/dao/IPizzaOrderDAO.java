package com.hcl.pizzaorder.dao;
import com.hcl.pizzaorder.bean.*;
import com.hcl.pizzaorder.service.*;

public interface IPizzaOrderDAO {
	
	
	
	public int placeOrder(Customer customer,Customer pizza) throws PizzaException; 
	public void PizzaOrdergetOrderDetails(int orderid) throws PizzaException;

}
