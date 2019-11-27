package com.hcl.pizzaorder.webapp;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToppingsController1
 */
@WebServlet("/ToppingsController1")
public class ToppingsController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
	RequestDispatcher rd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToppingsController1() {
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
		HashMap<Integer,String> hm=Toppings.getToppings();
		request.setAttribute("toppingpreferred", hm);
		ctx=getServletContext();
		//response.sendRedirect("/emplogin2.jsp");
		rd=ctx.getRequestDispatcher("/Pages/placeorder.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
