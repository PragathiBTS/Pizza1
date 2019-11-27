package com.hcl.pizzaorder.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

import com.hcl.pizzaorder.bean.Customer;
import com.hcl.pizzaorder.bean.PizzaOrder1;
import com.hcl.pizzaorder.service.PizzaException;
import com.hcl.pizzaorder.service.PizzaOrderService;
import com.hcl.pizzaorder.ui.Pizzaui;
import com.mysql.cj.protocol.Resultset;


public class PizzaOrderDAO {
	Connection c=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	Statement stmt = null;
	

	
	public int placeOrder(Customer customer,PizzaOrder1 pizza) throws PizzaException, SQLException {
	Connection c=ConnectionPizza.getCon();

	String sql = "Insert into pizza" 
            + " (Name,Address,Phoneno) " 
            + " values " //
            + " (?, ?,?)";

    PreparedStatement pst1=null;
	try {
		pst1 = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    pst1.setString(1,customer.getCustName());
	pst1.setString(2,customer.getAddress());
	pst1.setString(3,customer.getPhoneno());
	pst1.executeUpdate();
    ResultSet rs1 = pst1.getGeneratedKeys();

    int CustomerId = 0;
    if (rs1.next()) {
        CustomerId = rs1.getInt(1);
    }
    customer.setCustomerId(CustomerId);

    System.out.println("CustomerId: " +  CustomerId);
	} 
	catch (SQLException e) {
		//rs1.close();
		e.printStackTrace();
	}

		
	    String sql1 = "Insert into menu" //
                + " (toppings,price,cus_id,date) " //
                + " values " //
                + " (?, ?,?,?)";
	    int OrderId = 0;
        PreparedStatement pst2=null;
		try {
			pst2 = c.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			 PizzaOrderService order=new PizzaOrderService();
			 Pizzaui topping=new Pizzaui();
	    pst2.setString(1,pizza.getToppings());
	    HashMap<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("Capsicum",30);
        hm.put("Mushroom",50);
        hm.put("Jalapeno",70);
        hm.put("Paneer",85);
        int price=order.priceToppings(pizza.getToppings(),hm);
		pizza.setTotalPrice(price);
	    pst2.setInt(2,(int) pizza.getTotalPrice());
	    pst2.setInt(3, customer.getCustomerId());
	    java.sql.Date date = getCurrentJavaSqlDate();
	      pst2.setDate(4, date);
        pst2.executeUpdate();
 
        ResultSet rs2 = pst2.getGeneratedKeys();
        if (rs2.next()) {
            OrderId = rs2.getInt(1);
        }
 
        System.out.println("Order Id: " +  OrderId);
		} 
		
		catch (SQLException e) {
			rs2.close();
			e.printStackTrace();
		}
		return OrderId  ;
		
	} 
	
	
	
	public PizzaOrder1 PizzaOrdergetOrderDetails(int orderid) throws PizzaException, SQLException {
		PizzaOrder1 pizza=new PizzaOrder1();
		try {
			PreparedStatement pstmt=null;
		    Connection c=ConnectionPizza.getCon();
		    String query = "Select cus_id,price,date from menu where order_id=?";
			pstmt = c.prepareStatement(query);
	      pstmt.setInt(1, orderid); 
	      rs1 = pstmt.executeQuery();
	      while (rs1.next()) {
	        
			int CustomerId = rs1.getInt(1);
	        String price = rs1.getString(2);
	        Date date=rs1.getDate(3);
	        
	        if(rs1!=null){
	        	pizza.setCustomerId(CustomerId);
	        	pizza.setOrderId(orderid);
	        	Double TotalPrice=Double.parseDouble(price);
	        	pizza.setTotalPrice(TotalPrice);
	        	return pizza;
	        }
	        else
	        {
	        	throw new PizzaException("Order id not found");
	        }
	       
	        
	      }
		} catch (PizzaException e) {
			return null;
		}
		return null;
		
	}
	
	
	
	public static java.sql.Date getCurrentJavaSqlDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	  }
	
	
	
	public int updateOrder(int orderid, String price)  throws PizzaException, SQLException{
		int k=0;
		Customer customer=new Customer();
		
		Connection c=ConnectionPizza.getCon();
		PreparedStatement pstmt=null;
		String query = "Update menu set price=? where order_id=?";
		try {
			
			pstmt = c.prepareStatement(query);
		 pstmt.setString(1, price);
		 pstmt.setInt(2, orderid); 
		  k = pstmt.executeUpdate(); 
		 if(k==0){
			throw new PizzaException("Order id not found");
		}
		}
		catch (PizzaException e) {
			return 0;	
		}
		return k;
		
		
	}
	
	
	
	public int deleteOrder(int orderid) throws PizzaException, SQLException  {
		int delete=0;
		Connection c=ConnectionPizza.getCon();
		PreparedStatement pstmt=null;
		String query = "Delete from menu where order_id=?";
		
		try {
			pstmt = c.prepareStatement(query);
		    pstmt.setInt(1, orderid);
		    delete = pstmt.executeUpdate(); 
		    if(delete==0)
			{
				 throw new PizzaException("Order id not found");
			}
			 
		} 
		catch (PizzaException e) {
			return 0;
		}
		
		return delete;
		}
	
	
	
	
	public static void main(String[] args) throws SQLException {
		 PizzaOrderService order=new PizzaOrderService();


}
	
}
