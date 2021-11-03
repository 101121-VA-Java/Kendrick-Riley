package com.revature.controllers;

import java.util.Scanner;

public class WelcomePage {
	 static Scanner sc = new Scanner(System.in);
		
		protected static int choose;
		
		
		public void welcomePage() {
			boolean run = true;
			
			do {
				System.out.println("***Greetings from Top Bass Pro Shop***");
		        System.out.println("Select 1 to Login");
		        System.out.println("Select 2 for Employee Menu");
		        System.out.println("Select 3 for Customer Menu");
		        System.out.println("Select 4 to exit");
		        
		        System.out.print("Enter selected option: ");
				choose = sc.nextInt();

		        switch (choose){
		        case 1:
		        	LoginController.logIn();
		        	break;
		            	
		         case 2: 
		        	EmployeeMenu.EmpMenu();
		       		break;		          
		     
		         case 3:
		        	 System.out.println("Program Exited!");
		        	 run = false;
		        	 break;
		        default:
		        	System.out.println("Invalid Input");
		        }	
		        
			}while (run); 
			sc.close();
		}
}