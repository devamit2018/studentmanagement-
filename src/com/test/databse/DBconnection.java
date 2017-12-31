package com.test.databse;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	
	public static Connection getdbconnnection()
	{
	Connection con = null;
	 
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
		return con;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return con;
}

}
