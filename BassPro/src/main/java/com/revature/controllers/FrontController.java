package com.revature.controllers;

import java.util.Scanner;

public class FrontController {
	 Scanner sc = new Scanner(System.in);
	
		protected int choose;
		
		
		public void welcomePage() {
				System.out.println("***Greetings from Top Bass Pro Shop***");
		        System.out.println("Select 1 for Login");
		        System.out.println("Select 2 for User Registration");
		        System.out.println("Select 3 to Exit");
		        System.out.print("Enter selected option: ");
				choose = sc.nextInt();

		        if(choose == 1){
		        	Login.logIn();
		            	
		        } else if (choose == 2){
		        	
		        	RegistrationController.reg();
		         
		           
		        } else {
		        	System.out.println("Program Exited!");
		        }
	}	
		public void EmployeeMenu() {
			System.out.println("***    Top Bass Pro Shop***");
	        System.out.println("Select 1 for Login");
	        System.out.println("Select 2 for User Registration");
	        System.out.println("Select 3 to add item");
	        System.out.println("Select 4 to delete item");
	        System.out.println("Select 5 accept pending offer");
	        System.out.println("Select 6 to view all payments");
	        System.out.print("Enter selected option: ");
			choose = sc.nextInt();
	        
	        System.out.print("Enter selected option: ");
			choose = sc.nextInt();
			
		}
		
			public void CustomerMenu() {
				System.out.println("***Greetings from Top Bass Pro Shop***");
		        System.out.println("Select 1 for Login");
		        System.out.println("Select 2 for User Registration");
		        System.out.println("Select 3 to View items");
		        System.out.println("Select 4 to make offer");
		        System.out.println("Select 5 to view remaining payment");
		        System.out.println("Select 6 to Exit");
		        System.out.print("Enter selected option: ");
				choose = sc.nextInt();
			}
			public void ManagerMenu() {
				System.out.println("***Greetings from Top Bass Pro Shop***");
		        System.out.println("Select 1 for Login");
		        System.out.println("Select 2 for User Registration");
		        System.out.println("Select 3 to View items");
		        System.out.println("Select 4 to make offer");
		        System.out.println("Select 5 to view remaining payment");
		        System.out.println("Select 6 to View weekly payments");
		        System.out.println("Select 4 to reject all pending offers");
		        System.out.println("Select 4 Update item status");
		        System.out.println("Select 6 to Exit");
		        
		        System.out.print("Enter selected option: ");
			}
}
	

