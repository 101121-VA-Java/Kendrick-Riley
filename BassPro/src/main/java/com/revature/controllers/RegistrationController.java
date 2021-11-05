package com.revature.controllers;

import java.util.Scanner;

import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Role;

import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;

public class RegistrationController{
	
	 static Scanner sc = new Scanner(System.in);
	 static String name;
	 static String username;
	 static String password;
	
	 
	private static CustomerService cs = new CustomerService();
	private static EmployeeService es = new EmployeeService();
	static String check;
	 
	
	
	public static void reg() {
		
		
	System.out.println("Enter your name:");
	name = sc.nextLine();
	if(name.trim().length() < 3) {
		System.out.println("Your name should be great than 3 characters.");
		return;
	}
	System.out.println("Enter your username:");
	username = sc.nextLine();
	if(name.trim().length() < 3) {
		System.out.println("Your username should be great than 3 characters.");
		return;
	}
	System.out.println("Enter your password:");
	password = sc.nextLine();
	if(name.trim().length() < 3) {
		System.out.println("Your password should be great than 3 characters.");
		return;
	}
	System.out.println("Customer 1 or Employee 2!");
	check = sc.nextLine();
	
	if(check.equals("1")) {
		
		Customer newCustomer = new Customer(0, name, username, password);
		
		try {
			newCustomer = cs.addCustomer(newCustomer);
			System.out.println("Welcome " + newCustomer.getName() + "!");
			
		} catch (UsernameAlreadyExistsException e) {
			System.out.println("Username already exists");
			reg();
		}
		System.out.println("Registration in progress...\n");
		System.out.println("Registration Complete");
		CustomerMenu.cusMenu();
		
	}else if(check.equals("2")) {
		
		Employee newEmployee = new Employee(name, username, password);
		
		
		 try {
				newEmployee = es.addEmployee(newEmployee);
				System.out.println("Welcome " + newEmployee.getName());
				
			} catch (UsernameAlreadyExistsException e) {
				System.out.println("Username is already in use.\nPlease try again.");
				reg();
			}
	System.out.println("Registration in progress...\n");
	System.out.println("Registration Complete");
	EmployeeMenu.EmpMenu();  
	
}
}	
}
