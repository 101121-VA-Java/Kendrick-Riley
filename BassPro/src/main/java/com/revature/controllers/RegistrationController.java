package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;

public class RegistrationController{
	
	static Scanner sc = new Scanner(System.in);
	static String name;
	static String username;
	static String password;
	
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
	User t = new User(0, name, username, password);
	User.add(t);
	System.out.println("Registration in progress...\n");
	System.out.println("Registration Complete");
}
}	

