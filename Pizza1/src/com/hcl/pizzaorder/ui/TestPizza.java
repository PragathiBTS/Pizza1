package com.hcl.pizzaorder.ui;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hcl.pizzaorder.bean.Customer;
import com.hcl.pizzaorder.bean.PizzaOrder1;
import com.hcl.pizzaorder.dao.PizzaOrderDAO;
import com.hcl.pizzaorder.service.PizzaException;

public class TestPizza {
	Customer customer;
	PizzaOrder1 pizzaorder;
	static PizzaOrderDAO pizza;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pizza=new PizzaOrderDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		pizza=null;
	}

	@Before
	public void setUp() throws Exception {
		customer=new Customer();
		pizzaorder=new PizzaOrder1();
	}

	@After
	public void tearDown() throws Exception {
		customer=null;
		pizzaorder=null;
	}

	@Test
	public void testUpdate() throws SQLException, PizzaException {
		pizzaorder.setOrderId(2012);
		pizzaorder.setToppings("Jalapeno");
		pizzaorder.setTotalPrice(380);
		assertEquals(1,pizza.updateOrder(pizzaorder.getOrderId(),
				pizzaorder.getToppings()));
		
	}
	@Test
	public void testDelete() throws SQLException, PizzaException {
		pizzaorder.setOrderId(2015);
		assertEquals(1,pizza.deleteOrder(pizzaorder.getOrderId()));
		
	}

}
