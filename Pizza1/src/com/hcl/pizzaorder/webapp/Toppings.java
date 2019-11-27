package com.hcl.pizzaorder.webapp;

import java.util.HashMap;

public class Toppings {
	
	public static HashMap<Integer,String> getToppings()
	{
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		hm.put(30,"Capsicum");
        hm.put(50,"Mushroom");
        hm.put(70,"Jalapeno");
        hm.put(85,"Paneer");
        
        
		return hm;
		
	}

}
