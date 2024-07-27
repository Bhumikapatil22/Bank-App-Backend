package com.bhumika.services;

import com.bhumika.db.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;
public class MainControl {

	public static void main(String[] args) {
		char y;
		AmountWithdraw a=new AmountWithdraw();
		connectDB.dbCon();
		do
		{
			Scanner sc=new Scanner(System.in);
			System.out.println(("---------Welcome to Apna Bank---------"));
			System.out.println("Please Enter\n 1.To add new user.\n 2.To deposite money\n 3.To withdraw money\n 4.To check balance\n 5.To get user's detail\n 6.To get all users detail\n 7.To exit\n");
			int n=sc.nextInt();
			switch(n)
			{
			case 1: a.addUser();
			break;
			
			case 2: a.amountDeposite();
			break;
			
			case 3: a.withdrawMoney();
			break;
			
			case 4: a.checkBalance();
			break;
			
			case 5:a.getUser();
			break;
			
			case 6:a.getAllUser();
			break;
			
			case 7: System.out.println("-------Thanks for visiting-----");
					System.exit(0);
					
			default: System.out.println("Invalid number");
			}
			System.out.println("Do you want to continue(Y/N?");
			y=sc.next().charAt(0);
		}while(y=='Y'||y=='y');
		System.out.println("-------Thanks for visiting-----");
	}

}
