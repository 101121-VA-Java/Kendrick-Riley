package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;

public class EmployeeMenu {
	 static Scanner sc = new Scanner(System.in);
	 
	 
		protected static int choose;
		
		
		public static void EmpMenu() {
			boolean run = true;
	
			do {
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
	        
//	        System.out.print("Enter selected option: ");
//			choose = sc.nextInt();
			
				switch (choose) {
				case 1:
				lc.logIn();
				break;
				case 2:
					rc.reg();
				break;
				case 3: 
					
							
				break;
				
				case 4:
					
					break;
					
					case 5:
					
					case 6:
					
					break;
					
					case 7:
						
					break;
				default: 
					System.out.println("Invaild input");
					run = false;
				}
				
			}while (run);
			sc.close();
		}
}
