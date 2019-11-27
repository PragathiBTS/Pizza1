package com.hcl.pizzaorder.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.hcl.pizzaorder.bean.Customer;
import com.hcl.pizzaorder.bean.PizzaOrder1;


public class PizzaOrderService implements IPizzaOrderService {

	public static void main(String[] args) {
		

	}


	
	  
    public int priceToppings(String Toppings,HashMap hm){
		int price=0;
		 
	        switch(Toppings)
			{
			case "Capsicum":
				 price=(int) hm.get(Toppings);
				break;
			case "Mushroom":
				price=(int) hm.get(Toppings);
				break;
			case "Jalapeno":
				price=(int) hm.get(Toppings);
				break;
			case "Paneer":
				price=(int) hm.get(Toppings);
				break;
				default:
					price=350;
					break;
			}
		
		return price+350;
		
		
    }

	@Override
	public void PizzaOrdergetOrderDetails(int orderid) throws PizzaException {
		
		  PizzaOrderService pizza=new PizzaOrderService();
		 
		 
	        
	}




	@Override
	public int placeOrder(Customer customer, Customer pizza) throws PizzaException {
		// TODO Auto-generated method stub
		return 0;
	}

}
