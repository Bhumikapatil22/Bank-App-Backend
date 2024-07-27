package com.bhumika.db;

import java.sql.*;

public class connectDB
{
	static Connection con=null;
	public static Connection dbCon()
	{
	try
		{
		if(con==null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "");
//			System.out.println("Connection established"+con);
		}
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
	}
}
