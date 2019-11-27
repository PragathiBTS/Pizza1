package com.hcl.pizzaorder.ui;
import java.sql.*;
import java.util.*;

import com.hcl.pizzaorder.bean.Customer;
import com.hcl.pizzaorder.bean.PizzaOrder1;
import com.hcl.pizzaorder.dao.PizzaOrderDAO;
import com.hcl.pizzaorder.service.PizzaException;
import com.hcl.pizzaorder.service.PizzaOrderService;

public class Pizzaui {

	public static void main(String[] args) throws PizzaException, SQLException { 
	  Customer customer=new Customer();
	  PizzaOrder1 pizza=new PizzaOrder1();
	  PizzaOrderDAO pizzaorder=new PizzaOrderDAO();
	  PizzaOrderService order=new PizzaOrderService();
	  HashMap<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("Capsicum",30);
      hm.put("Mushroom",50);
      hm.put("Jalapeno",70);
      hm.put("Paneer",85);
		System.out.println("***Welcome to JUSTEAT PIZZAS***");
		System.out.println("Do you want to ");
		System.out.println("1.Place Order\n 2.Display Order\n 3.Update Order\n 4.Delete Order\n 5.Exit");
		Scanner scan=new Scanner(System.in);
		Scanner scan1=new Scanner(System.in);
		int choice=0;
		choice=scan.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the Customer name");
			customer.setCustName(scan.next());
			System.out.println("Enter the customer address");
			customer.setAddress(scan1.nextLine());
			System.out.println("Enter customer phone number: ");
			customer.setPhoneno(scan.next());
			
	        System.out.println("Available Toppings and their prices are:/n"+hm);
			System.out.println("Type of Pizza Topping preferred:");
			pizza.setToppings(scan1.next());
			int j=pizzaorder.placeOrder(customer, pizza);
			if(j>1)
			{
				System.out.println("Pizza Order successfully placed with Order Id:"+j);
			}
			break;
			
		case 2:
			System.out.println("Enter the order Id");
			int orderId=scan.nextInt();
			//pizzaorder.PizzaOrdergetOrderDetails(orderId);
			PizzaOrder1 pizzaorder1=pizzaorder.PizzaOrdergetOrderDetails(orderId);
			
			
			
		case 3:
			System.out.println("Enter the Order id");
			int orderid=scan.nextInt();
			System.out.println("Enter the phoneno");
			pizza.setToppings(scan1.next());
			int k=pizzaorder.updateOrder(orderid,customer.getPhoneno());
			if(k>0)
			{
				System.out.println("Order is updated");
			}
			else
			{
				System.out.println("Can't update the order");
			}
			break;
			
			
		case 4:
			System.out.println("Enter the order id to delete:");
			int Orderid=scan.nextInt();
			int delete=pizzaorder.deleteOrder(Orderid);
			if(delete>0){
				System.out.println("Oredr is deleted");
			}
			else
			{
				System.out.println("Can't update the order");
			}
			break;
			
		case 5:	
			
		System.out.println("Application is closed");	
			break;
			
			default:
				break;
					
		}
	}

}
