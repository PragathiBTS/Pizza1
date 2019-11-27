package com.hcl.pizzaorder.dao;
import java.sql.*;

public class ConnectionPizza {
	
	static Connection c;
	
	public static Connection getCon()
	{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(c==null)
			{
				c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
				System.out.println("connected "+c);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return c;
	}

}
