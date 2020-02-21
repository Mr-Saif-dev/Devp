package com.connection;

import javax.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.NullPointerException;

/**
 * Servlet implementation class DatabaseConnect
 */
public class DatabaseConnect
 {
	public static Connection dbcon()
	{
		Connection con=null;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mysql";
		String user="root";
		String pass="dinga";
		
		
		try
		{
				Class.forName(driver);
				try 
				{
					con=DriverManager.getConnection(url,user,pass);
				}
				catch (Exception e)
				{
					System.out.println("from here");
					System.out.println(e.getMessage());
				}
			
				
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("from out");
			System.out.println(e);
		}
		catch (NullPointerException e)
		{
			System.out.println(e);
		}
		System.out.println("done");
		return con;
	}
}
