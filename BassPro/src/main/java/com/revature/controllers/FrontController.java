package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;

public class FrontController {
	 static Scanner sc = new Scanner(System.in);
	
		protected static int choose;
		
		
		public void welcomePage() {
				System.out.println("***Greetings from Top Bass Pro Shop***");
		        System.out.println("Select 1 to login as customer");
		        System.out.println("Select 2 to login as employee");
		        System.out.println("Select 3 to exit");
		        System.out.print("Enter selected option: ");
				choose = sc.nextInt();

		        if(choose == 1){
		        	Login.logIn();
		            	
		        } else if (choose == 2){
		        	FrontController.EmployeeMenu();
				           
		        } else {
		        	System.out.println("Program Exited!");
		        }
	}	
		public static void EmployeeMenu() {
			System.out.println("***    Top Bass Pro Shop***");
	        System.out.println("Select 1 for Login");
	        System.out.println("Select 2 for User Registration");
	        System.out.println("Select 3 to add item");
	        System.out.println("Select 4 to delete item");
	        System.out.println("Select 5 accept pending offer");
	        System.out.println("Select 6 to view all payments");
	        System.out.println("Select 7 for manager view");
	        System.out.print("Enter selected option: ");
			choose = sc.nextInt();
	        
	        System.out.print("Enter selected option: ");
			choose = sc.nextInt();
			
				if (choose == 1) {
					Login.logIn();
				}if(choose == 2) {
					RegistrationController.reg();
				}if(choose ==3) {
				
				}if(choose == 4) {
					
				}if(choose == 5) {
					
				}if(choose == 6) {
					
				}if(choose == 7) {
					
				}
				
			}
			
			
			
	
		
			public static void CustomerMenu() {
				System.out.println("***Greetings from Top Bass Pro Shop***");
		        System.out.println("Select 1 for Login");
		        System.out.println("Select 2 for User Registration");
		        System.out.println("Select 3 to View items");
		        System.out.println("Select 4 to make offer");
		        System.out.println("Select 5 to view remaining payment");
		        System.out.println("Select 6 to Exit");
		        System.out.print("Enter selected option: ");
				choose = sc.nextInt();
				if (choose == 1) {
					Login.logIn();
				}if(choose == 2) {
					RegistrationController.reg();
				}if(choose == 3) {
					
				}if(choose == 4) {
					
				}if(choose == 5) {
					
				}if(choose == 6) {
					
				}if(choose == 7) {
					
			}
				}
			public static void ManagerMenu() {
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
			if (choose == 1) {
				Login.logIn();
			}if(choose == 2) {
				RegistrationController.reg();
			}if(choose ==3) {

			}if(choose == 4) {
				
			}if(choose == 5) {
				
			}if(choose == 6) {
				
			}if(choose == 7) {
				
			}
		}	
	}	

