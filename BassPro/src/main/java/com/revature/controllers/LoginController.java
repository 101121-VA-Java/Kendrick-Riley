package com.revature.controllers;
import java.util.Scanner;

import com.revature.exception.LoginException;

import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;

public class LoginController{
	private static CustomerService cs = new CustomerService();
	private static EmployeeService es = new EmployeeService();

	static Scanner sc = new Scanner(System.in);
	protected static int choose;
	
	
	public static void userLog() {
		boolean run = true;
	

		System.out.println("Select 1: for customer");
		System.out.println("Select 2: for employee:");
		String us = sc.nextLine();
		
		System.out.println("Please Enter Your Username!");
		String username = sc.nextLine();
	
		
		System.out.println("Please Enter Your Password:");
		String password = sc.nextLine();
		
		if(us.equals("1")) {
			try {
				cs.login(username, password);
				System.out.println("Loading...........!");
				System.out.println("Log In Successful!");
				CustomerMenu.cusMenu();
				
			} catch (LoginException e) {
				System.out.println("Invalid credentials");
				System.out.println("Please Try Again!");
				System.out.println("Press 1: Login Press 2: Register");
				String choose = sc.nextLine();
				switch(choose) {
				case "1":
					System.out.println("Returning to Login Menu");
					userLog();
				break;
				
				case "2":
					RegistrationController.reg();
					break;
					
				default:
					System.out.println("Invaild input");
					run = false;
					
				}
			}
		}if(us.equals("2")) {
			try {
				es.login(username, password);
				EmployeeMenu.EmpMenu();
			} catch (LoginException e) {
				System.out.println();
				System.out.println("Invalid credentials");
				System.out.println("Please Try Again!");
				System.out.println("Press 1: Login Press 2: Register");
				String choose = sc.nextLine();
				System.out.println();
			
				if(choose.equals("1")) {
					userLog();
				} else {
					RegistrationController.reg();
				}
			}
		}
		else {
//			userLog();
		}
	}
	}			
	