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
	        System.out.println("Select 3 View Pending/Accept Offer");
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
					
//		 		    run = false;
					sc.nextLine();
					removeFromShop(sc);
					run = false;
					
//					String name = sc.nextLine();
//				Item deletedItem = is.getItemByDescription(name);
//					is.deleteItem(deletedItem);
						
				break;
				case 3: 
					System.out.println("Offers for Items");
//					run = false;
					is.viewOffers(sc);
					run = false;
					break;
				case 4:
					System.out.println("View All Payments");
//					is.viewPayments(sc);
					is.showPayments();
					run = false;
					break;
				default: 
					
					System.out.println("Press 5 to return to Main Menu ");
					WelcomePage.welcomePage();
					run = false;
				}
				
			}while (run);
			
		}
		
public static void removeFromShop(Scanner sc) {
	System.out.println();
	System.out.println("Input the description:");
	String description = sc.nextLine();
	if(description.trim().length() < 3) {
		System.out.println("Sorry! Name should be 3 characters.");
		return;
	}
	System.out.println("Input the quantity to remove:");
	String quantityA = sc.nextLine();
	int quantity = Integer.parseInt(quantityA);
	if(quantityA.trim().length() < 1) {
		System.out.println("Quantity must be at least 1 ");
		return;
	}
	Item i = new Item(description,quantity, 0, 0, " " );
	i = is.deleteItem(i); 
	System.out.println("Successfully Removed Item.");	
	if(i != null) {
		System.out.println("Product Remaining: " + i.getDescription() + " " + i.getQuantity() + " " + i.getPrice());
	}
	EmpMenu();
}}
