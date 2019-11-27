package com.hcl.pizzaorder.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.pizzaorder.bean.Customer;
import com.hcl.pizzaorder.bean.PizzaOrder1;
import com.hcl.pizzaorder.dao.PizzaOrderDAO;
import com.hcl.pizzaorder.service.PizzaException;

/**
 * Servlet implementation class PizzaController1
 */
@WebServlet("/PizzaController1")
public class PizzaController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ServletContext ctx;
       RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaController1() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletContext context)
    {
    	ctx=context;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String u1=request.getParameter("name");
		String u2=request.getParameter("address");
		String u3=request.getParameter("phoneno");
		String u4=request.getParameter("toppings");
		out.println((u4));
		Customer customer=new Customer();
		PizzaOrder1 pizzaOrder1=new PizzaOrder1();
		
	customer.setCustName(u1);
	customer.setAddress(u2);
	customer.setPhoneno(u3);
	pizzaOrder1.setToppings(u4);
	
	PizzaOrderDAO pizzaOrderDAO=new PizzaOrderDAO();
	try {
		int r= pizzaOrderDAO.placeOrder(customer,pizzaOrder1);
		if(r!=0)
		{
			
			request.setAttribute("orderid",r);
			ctx=getServletContext();
			//response.sendRedirect("/emplogin2.jsp");
			rd=ctx.getRequestDispatcher("/Pages/SuccessPlaceOrder.jsp");
			rd.forward(request,response);
	}
	}
		catch(SQLException e)
		{
			System.out.println(e);
		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
