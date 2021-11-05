package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.ItemList;

public class ManagerMenu {
	 static Scanner sc = new Scanner(System.in);

	protected static int choose;
	
	public void managerMenu() {
		boolean run = true;
		
		do {
		System.out.println("***Greetings from Top Bass Pro Shop***");
        System.out.println("Select 1 for Login");
        System.out.println("Select 2 for User Registration");
        System.out.println("Select 3 to View items");
        System.out.println("Select 4 to make offer");
        System.out.println("Select 5 to view remaining payment");
        System.out.println("Select 6 to View weekly payments");
        System.out.println("Select 7 to reject all pending offers");
        System.out.println("Select 8 Update item status");
        System.out.println("Select 9 to Exit");
        System.out.print("Enter selected option: ");
        
	switch (choose){
	case 1:
		
		break;
	case 2:
		rc.reg();
		break;
	case 3:

		it.getAll();
		break;
	case 4:
		break;
		
	case 5:
		break;
		
	case 6:
		
		break;
		
	case 7:
		
		break;
	case 8:
		
		break;
	case 9:
		System.out.println("Program Exited!");
   	 run = false;
		break;
		default:
			System.out.println("Invalid Input");
	}	
		}while (run);	
		
	}
}	

