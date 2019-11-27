package com.hcl.pizzaorder.bean;

public class PizzaOrder1 {
	

				private int orderId; 
				private int customerId; 
				private double totalPrice;
				private String toppings;
				
				
				
				public int getOrderId() {
					return orderId;
				}
				public void setOrderId(int orderId) {
					this.orderId = orderId;
				}
				public int getCustomerId() {
					return customerId;
				}
				public void setCustomerId(int customerId){
					this.customerId = customerId;
				}
				public double getTotalPrice() {
					return totalPrice;
				}
				public void setTotalPrice(double totalPrice) {
					this.totalPrice = totalPrice;
				}
				public String getToppings() {
					return toppings;
				}
				public void setToppings(String toppings) {
					this.toppings = toppings;
				}	
					public String toString() { 
				        return String.format("OrderId:"+ orderId +"\nCustomer id:" + customerId + "\nTotal price:" + totalPrice );

	}
				
				
				
}


