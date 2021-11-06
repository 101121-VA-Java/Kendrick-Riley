package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;
import com.revature.services.ItemService;

public class EmployeeMenu {
	 static Scanner sc = new Scanner(System.in);
	 
	 	private static ItemService is = new ItemService();
		protected static int choose;
		
		
		public static void EmpMenu() {
			boolean run = true;
	
			do {
			System.out.println("***    Top Bass Pro Shop***");
	        System.out.println("Select 1 to add item");
	        System.out.println("Select 2 to delete item");
	        System.out.println("Select 3 accept pending offer");
	        System.out.println("Select 4 to view all payments");
	        System.out.println("Select 5 for manager view");
	        System.out.print("Enter selected option: ");
			choose = sc.nextInt();
	        

			
				switch (choose) {
				case 1:
//					is.addItem(item); todo Start here 
				break;
				case 2:
			
				break;
				case 3: 
					
							
				break;
				
				case 4:
					
					break;
					
					case 5:
					break;
				default: 
					System.out.println("Invaild input");
					run = false;
				}
				
			}while (run);
			sc.close();
		}
}
