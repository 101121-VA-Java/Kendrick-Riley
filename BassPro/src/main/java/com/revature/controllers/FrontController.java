package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;

public class FrontController {
	private Scanner sc;
	private EmployeeController ec;
	private CustomerController cc;
	private ManagerController mc;
	
	public FrontController() {
		sc = new Scanner(System.in);
		cc = new CustomerController();
		mc = new ManagerController();
		
	}
	public void decideTitle() { //manager view 
		if(manager.equals User.name) {///Need to figure out how i am going to call manager
			System.out.println("Welcome Sir!");
			System.out.println("Please select an action from the following options:");
			System.out.println("1: Create an Employee!");
			System.out.println("2: Remove an Employee!");
			System.out.println("2: Review Q1 Sales!");
			
			String leaderChoice = sc.nextLine();
			
			switch(leaderChoice) {//need to create methods to create switch cases
			case "1":
				mc.registerEmployee(sc);
				break;
			case "2":
				mc.removeEmployee(sc);
				break;
			case "3":
				mc.reviewSales(sc);
				break;
			default:
				System.out.println("Invaild Selection: Please Select one of the options:");
			
			}
			
		}
	}
		
	public void run() {
	boolean run = true;
	
	while(run) {
		System.out.println("Please select an option:");
		System.out.println("1: register");
		System.out.println("2: login");
		System.out.println("3: exit");
		
		String choice = sc.nextLine();
		
		switch(choice) {
		case "1":
			ec.registerEmployee(sc);
			// TODO: if an employee is not registered, display a different message
			break;
		case "2":
			break;
		case "3":
			run = false;
			break;
		default:
			System.out.println("Invalid input.");
		}
	}
	
	sc.close();
}
}

