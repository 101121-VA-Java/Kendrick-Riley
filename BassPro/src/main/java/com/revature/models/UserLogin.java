package com.revature.models;

import java.util.Scanner;
import com.revature.models.Employee;
import com.revature.exception.LoginException;
import com.revature.services.EmployeeService;
import com.revature.models.Role;

public class UserLogin {
	private static EmployeeService es = new EmployeeService();
	private static Employee kendrick;
	private static Scanner sc;

	
	public static void run(Scanner scan) {
		sc = scan;
		
		System.out.println();
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		
		try {
			kendrick = es.login(username, password);
			
		}catch (LoginException e) {
			System.out.println("Invaid credentials :");
			
		}
	}
	
}
