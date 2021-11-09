package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;
import com.revature.models.Item;
import com.revature.services.ItemService;

public class EmployeeMenu {
	 static Scanner sc = new Scanner(System.in);
	 	private static ItemController ic = new ItemController();
	 	private static ItemService is = new ItemService();
		protected static int choose;
		
		
		public static void EmpMenu() {
			boolean run = true;
	
			do {
			System.out.println("***  Top Bass Pro Shop  ***");
	        System.out.println("Select 1 to Add Item");
	        System.out.println("Select 2 to Delete Item");
	        System.out.println("Select 3 Accept/View Pending Offer");
	        System.out.println("Select 4 to View All Payments");
	        System.out.print("Enter selected option: ");
			choose = sc.nextInt();
	        

			
				switch (choose) {
				case 1:
					System.out.println("Add Item");
				ic.addItem();
				run = false;
				
				break;
				case 2:
					System.out.println("Enter the name of the item to remove");
					String name = sc.nextLine();
					Item deletedItem = is.getItemByDescription(name);
					is.deleteItem(deletedItem);
						
				break;
				case 3: 
					System.out.println("Offers for Items");
					run = false;
					is.viewOffers(sc);
					break;
				case 4:
					System.out.println("View Your Payment");
					is.viewPayments();
					run = false;
					break;
				default: 
					System.out.println("Invaild input");
					run = false;
				}
				
			}while (run);
			sc.close();
		}
}
