package com.revature.controllers;

import java.util.Scanner;

import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.models.Employee;

import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;

public class RegistrationController {

	static Scanner sc = new Scanner(System.in);

	private static CustomerService cs = new CustomerService();
	private static EmployeeService es = new EmployeeService();

	public static void reg() {

		System.out.println("Customer 1 or Employee 2!");
		String check = sc.nextLine();

		switch (check) {
		case "1":

			System.out.println("Enter your name:");
			String name = sc.nextLine();
			if (name.trim().length() < 3) {
				System.out.println("Your name should be great than 3 characters.");
				return;
			}
			System.out.println("Enter your username:");
			String username = sc.nextLine();
			if (username.trim().length() < 3) {
				System.out.println("Your username should be great than 3 characters.");
				return;
			}
			System.out.println("Enter your password:");
			String password = sc.nextLine();
			if (password.trim().length() < 3) {
				System.out.println("Your password should be great than 3 characters.");
				return;
			}

			Customer newCustomer = new Customer(name, username, password);

			try {
				newCustomer = cs.addCustomer(newCustomer);
				System.out.println("Welcome " + newCustomer.getName() + "!");

			} catch (UsernameAlreadyExistsException e) {
				System.out.println("Username already exists");
				reg();
			}
			System.out.println("Registration in progress...\n");
			System.out.println("Registration Complete");

			WelcomePage.welcomePage();

		case "2":

			System.out.println("Enter your name:");
			String eName = sc.nextLine();
			if (eName.trim().length() < 3) {
				System.out.println("Your name should be great than 3 characters.");
				return;
			}
			System.out.println("Enter your username:");
			String eUsername = sc.nextLine();
			if (eUsername.trim().length() < 3) {
				System.out.println("Your username should be great than 3 characters.");
				return;
			}
			System.out.println("Enter your password:");
			String ePassword = sc.nextLine();
			if (ePassword.trim().length() < 3) {
				System.out.println("Your password should be great than 3 characters.");
				return;
			}
			Employee newEmployee = new Employee(eName, eUsername, ePassword);

			try {
				newEmployee = es.addEmployee(newEmployee);
				System.out.println("Welcome " + newEmployee.getName());

			} catch (UsernameAlreadyExistsException e) {
				System.out.println("Username is already in use.\nPlease try again.");
				reg();
				break;
			}
			System.out.println("Registration Successful: \n");
			EmployeeMenu.EmpMenu();

		}
	}
}
