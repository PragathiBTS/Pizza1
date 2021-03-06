package com.hcl.pizzaorder.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * Servlet implementation class UpdateController1
 */
@WebServlet("/UpdateController1")
public class UpdateController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServletContext ctx;
     RequestDispatcher rd;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController1() {
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
		String u1=request.getParameter("orderid");
		String u2=request.getParameter("price");
		PizzaOrder1 pizzaOrder1=new PizzaOrder1();
		int orderid=Integer.parseInt(u1);
		pizzaOrder1.setOrderId(orderid);
		//double price=Double.parseDouble(u2);
		
		
		PizzaOrderDAO pizzaOrderDAO=new PizzaOrderDAO();
		try {
			 int k=pizzaOrderDAO.updateOrder(orderid,u2);
			if(k==0){
				throw new PizzaException(" Order id not found");
			}
			else{
				request.setAttribute("update",k);
				ctx=getServletContext();
				//response.sendRedirect("/emplogin2.jsp");
				rd=ctx.getRequestDispatcher("/Pages/SuccessUpdate.jsp");
				rd.forward(request,response);
			}
		}
		
			catch (PizzaException e) {
				//request.setAttribute("display1",e);
				ctx=getServletContext();
				rd=ctx.getRequestDispatcher("/Pages/OrderException.jsp");
				rd.forward(request,response);
				//out.println(e.getMessage());
			} 
		
		catch (SQLException e) {
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
