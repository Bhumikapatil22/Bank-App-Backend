package com.bhumika.services;

import java.sql.*;
import com.bhumika.db.connectDB;

public class AmountWithdraw extends AmountDeposite
{	int accno;
	float newBal,withAmt;
	void withdrawMoney()
	{
		try{
		System.out.println("Enter account no. ");
		accno=sc.nextInt();
		System.out.println("Enter amount to withdraw ");
		withAmt=sc.nextFloat();
		Connection con=connectDB.dbCon();
		PreparedStatement ps=con.prepareStatement("select abal from users where ano=?");
		ps.setInt(1,accno);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			newBal=rs.getFloat(1);
			newBal=newBal-withAmt;
			PreparedStatement ps1=con.prepareStatement("update users set abal=? where ano=? ");
			ps1.setFloat(1, newBal);
			ps1.setInt(2,accno);
			int rs1=ps1.executeUpdate();
			System.out.println("Rs."+withAmt+" withdrawn from account");
			System.out.println("Your balance is: "+ newBal);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
