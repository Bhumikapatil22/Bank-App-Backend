package com.bhumika.services;
import java.sql.*;
import java.util.*;

import com.bhumika.db.connectDB;
public class AccountDetails 
{
	int cno=0,acno;
	String cname,cmob,ccity;
	float cbal;
	
	Scanner sc=new Scanner(System.in);
	void addUser()
	{
		try
		{
		System.out.println("Enter account holder's name:");
		cname=sc.nextLine();
		System.out.println("Enter mobile number:");
		cmob=sc.nextLine();
		System.out.println("Enter city name:");
		ccity=sc.nextLine();
		System.out.println("Enter account holder's balance:");
		cbal=sc.nextFloat();
		
		Connection con=connectDB.dbCon();
		
		PreparedStatement ps= con.prepareStatement("insert into users values(?,?,?,?,?)");
		ps.setInt(1,cno);
		ps.setString(2, cname);
		ps.setString(3, cmob);
		ps.setString(4, ccity);
		ps.setFloat(5, cbal);
		
		int i=ps.executeUpdate();
		if(i>0)
		{
			System.out.println(i+"row inserted....");
		}
		else
		{
			System.out.println("Failed to insert...");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void getUser()
	{
		try
		{
		System.out.println("Enter account number");
		acno=sc.nextInt();
		Connection con=connectDB.dbCon();
		PreparedStatement ps=con.prepareStatement("select * from users where ano=?");
		ps.setInt(1, acno);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("---------------------");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getFloat(5));
			System.out.println("---------------------");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void getAllUser()
	{
		try
		{
		Connection con=connectDB.dbCon();
		PreparedStatement ps=con.prepareStatement("select * from users");
		ResultSet rs=ps.executeQuery();
		while(rs.next())	
		{
			System.out.println("---------------------");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getFloat(5));
			System.out.println("---------------------");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	void checkBalance()
	{
		try
		{
			System.out.println("Enter account number");
			acno=sc.nextInt();
			Connection con=connectDB.dbCon();
			PreparedStatement ps=con.prepareStatement("select abal from users where ano=?" );
			ps.setInt(1, acno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getFloat(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
}
