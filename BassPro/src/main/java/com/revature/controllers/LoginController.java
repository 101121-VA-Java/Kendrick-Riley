package com.revature.controllers;
import java.util.Scanner;

import com.revature.models.User;

public class LoginController extends User {
	static Scanner sc = new Scanner(System.in);
	static boolean successful = false; 
	
	public static void logIn() {
	String un = "Krilo";
    String pass = "pass";
    while( !successful) {
    	 
    System.out.println("Enter username" + "\n");
 
    if(un.equals(sc.nextLine())) {
    	System.out.println("Enter you password ");
    }if(pass.equals(sc.nextLine())) {
    	successful = true;
    	System.out.println("Logged in Sucessfully");
    }
	}
    }
}
