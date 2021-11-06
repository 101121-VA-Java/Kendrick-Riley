package com.revature.controllers;

import java.util.Scanner;
import com.revature.models.Item;
import com.revature.services.ItemService;

public class ItemController {
	static Scanner sc = new Scanner(System.in);
	private static ItemService is = new ItemService();

	public void addItem() {
		
		System.out.println();
		System.out.println("Please enter item name: ");
		String description = sc.nextLine();
		if(description.trim().length() < 3) {
			System.out.println("Sorry! Name should be 3 characters.");
			return;
		}
		System.out.println("Please enter quantity: ");
		String quantityA = sc.nextLine();
		int quantity = Integer.parseInt(quantityA);
		if(quantityA.trim().length() < 1) {
			System.out.println("Quantity must be at least 1 ");
			return;
		}
		System.out.println("Please enter price): ");
		String priceA = sc.nextLine();
		int price = Integer.parseInt(priceA);
		if(priceA.trim().length() < 1 || price == 0) {
			return;
		}
		Item newItem = new Item(0, description, quantity, price);
			System.out.println("Item added " + newItem.getDecription() + "!");
			
		
	}


	
	
	}	

