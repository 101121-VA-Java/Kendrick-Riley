package com.revature.controllers;
import java.util.Scanner;
public class Login {
	static Scanner sc = new Scanner(System.in);
	
	public static void logIn() {
	String un = "Krilo";
    String pass = "pass";
    System.out.println("Enter username" + "\n");
 
    if(un.equals(sc.nextLine())) {
    	System.out.println("Enter you password ");
    }if(pass.equals(sc.nextLine())) {
    	System.out.println("Logged in Sucessfully");
    }
	}
}
