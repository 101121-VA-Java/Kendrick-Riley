package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;
import com.revature.services.ItemService;

public class CustomerMenu {
	static Scanner sc = new Scanner(System.in);
	private static ItemService is = new ItemService();
	protected static int choose;
		
			public static void cusMenu() {
				boolean Successful = true;
				
				do {
				System.out.println("** Top Bass Pro Shop**");
				System.out.println();
		        System.out.println("Select 1 to View Items");
		        System.out.println("Select 2 to Check Cart");
		        System.out.println("Select 3 to View Orders");
		        System.out.println("Select 4 to Exit");
		        System.out.print("Enter selected option: ");
				choose = sc.nextInt();
				
				switch (choose) {
					case 1:
						System.out.println(" Bass Master Items: ");
//						Successful = false;
					ItemService.buyFromInv(sc);
					Successful = false;
					break;
					case 2:
						System.out.println("Lets view Your Items");
						Successful = false;
						ItemService.viewCart(sc);
						
					break;
					case 3:
						System.out.println("Your Orders");
						is.showHistory();
						Successful = false;
						break;
					case 4:
						
						System.out.println("Program exited! Have a great day");
						WelcomePage.welcomePage();
						Successful = false;
						break;
			
					default: 
						System.out.println("Invaild input");
						Successful = false;
				}
				

				}	while (Successful = false);
				sc.close();
			}
		}

