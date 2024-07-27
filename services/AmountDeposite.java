package com.bhumika.services;
import java.sql.*;
import com.bhumika.db.connectDB;

public class AmountDeposite extends AccountDetails
{
	float cbal,rs1,amt,bal;
	int accno;
	
	void amountDeposite()
	{
		try{
		System.out.println("Enter account number ");
		accno=sc.nextInt();
		System.out.println("Enter amount to deposite");
		amt=sc.nextFloat();
		Connection con=connectDB.dbCon();
		PreparedStatement ps=con.prepareStatement("Select abal from users where ano=?");
		ps.setInt(1,accno);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			float bal=rs.getFloat(1);
			bal=bal+amt;
			PreparedStatement ps1=con.prepareStatement("update users set abal=? where ano=? ");
			ps1.setFloat(1,bal);
			ps1.setInt(2,accno);
			int rs1=ps1.executeUpdate();
			System.out.println();	
			System.out.println("Amount deposited Rs."+amt);
			System.out.println("Total Amount is Rs."+bal);
			System.out.println();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}}


