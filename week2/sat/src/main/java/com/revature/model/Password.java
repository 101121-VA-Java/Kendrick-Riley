package com.revature.model;

import java.util.Scanner;

public class Password {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
				
		String user, pass = null;
		
		System.out.print("Enter your username: ");
		user = input.nextLine();
		if(user.equals("Kendrick")){	
		
		System.out.print("Enter your password: ");
		pass = input.nextLine();
		}if((pass.equals("God"))) {
			System.out.println("Welcome King Kendrick");
		}else{
			System.out.println("This is not right");
			input.close();
		}
	}
	

}
