package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;

public class CustomerMenu {
	static Scanner sc = new Scanner(System.in);
	
	protected static int choose;
		
			public static void cusMenu() {
				boolean run = true;
				
				do {
				System.out.println("** Top Bass Pro Shop**");
				System.out.println();
		        System.out.println("Select 1 to View items");
		        System.out.println("Select 2 to make offer");
		        System.out.println("Select 3 to view remaining payment");
		        System.out.println("Select 4 to Exit");
		        System.out.print("Enter selected option: ");
				choose = sc.nextInt();
				
				switch (choose) {
					case 1:
					
					break;
					case 2:
				
					break;
					case 3:
	
				
					case 4:
						
						System.out.println("Program exited! Have a great day");
						break;
			
					default: 
						System.out.println("Invaild input");
						run = false;
				}
				

				}	while (run);
				sc.close();
			}
		}

