package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;

public class WelcomePage {
	 static Scanner sc = new Scanner(System.in);
		
		protected static int choose;
		
		
		public static void welcomePage() {
			boolean run = true;
			
			do {
				System.out.println();
				System.out.println("***Greetings from Top Bass Pro Shop***");
				System.out.println();
		        System.out.println("Select 1: Login");
		        System.out.println("Select 2: Register");
		        System.out.println("Select 3: Exit");
		        
		        System.out.print("Enter selected option: ");
				choose = sc.nextInt();

		        switch (choose){
		        case 1:
		        	System.out.println("Please Login");
		        	System.out.println();
		        	LoginController.userLog();
		        	
	        	  
	        	      
	        	      run = false;
		        	break;
		            	
		         case 2: 
		        	 System.out.println("Please Register");
					 System.out.println();
					 RegistrationController.reg();
					 
		        	
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