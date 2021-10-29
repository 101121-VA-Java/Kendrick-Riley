package com.revature.models;

import java.util.Scanner;

public class OrderingSystem {
	
	public static Scanner input = new Scanner(System.in);
	public static String again;
	public static double choose, quantity = 1;
	public static double total = 0, pay;
	
	public static void menu() {
	System.out.println("\t\t\t\t+*************************************+");
	System.out.println("\t\t\t\t            BAITCASTERS MENU      ");
	System.out.println("\t\t\t\t   1. Abu Garcia Revo       Price. 199.99");
	System.out.println("\t\t\t\t    2. Lew's Pro            Price. 349.99");
	System.out.println("\t\t\t\t     3. Penn                Price. 149.99");
	System.out.println("\t\t\t\t      4. Daiwa Lexa         Price. 499.99");
	System.out.println("\t\t\t\t     5. CANCEL                           ");
	System.out.println("\t\t\t\t****************************************");
	}
	public static void order() {
		System.out.println("Press 1 for Abu Garcia Revo, Press 2 for Lew's Pro, Press 3 for Penn"
				+ ", Press 4 for Daiwa Lexa, Press 5 to Cancel");
		System.out.print("Press the item you want to buy?");
		choose = input.nextInt();
		// conditions
		if(choose==1) {
			System.out.println("You choose Abu Garcia Revo");
			System.out.print("How many Abu Garcia Revo you want to Buy? :");
			quantity = input.nextInt();
			total = total + (quantity * 199.99);
			
			System.out.println("You want to buy Again? ");
			System.out.println("Press Y for Yes and N for No : ");
			again = input.next();
			if(again.equalsIgnoreCase("Y")) {
				order(); //Calls the order method to create a new order.
			}else {
				System.out.println("Total price is " + total);
			}
		}
	}
	
	public static void main(String[] args) {
		menu();
		order();
		
	}
}