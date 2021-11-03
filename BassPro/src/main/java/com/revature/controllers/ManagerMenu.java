package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;

public class ManagerMenu {
	 static Scanner sc = new Scanner(System.in);
		
	protected static int choose;
	
	public static void ManagerMenu() {
		boolean run = true;
		
		do {
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
        
	switch (choose) {
		LoginController.logIn();
		case 1: {
		RegistrationController.reg();
	}if(choose ==3) {
		ItemList itemList = new ItemList();
		itemList.getAll();
	}if(choose == 4) {
		
	}if(choose == 5) {
		
	}if(choose == 6) {
		System.out.println("Program exited! Have a great day");
	}if(choose == 7) {
		
	}
}	
}
