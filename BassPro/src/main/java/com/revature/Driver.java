package com.revature;

import com.revature.controllers.FrontController;
import com.revature.controllers.RegistrationController;
import com.revature.models.OrderingSystem;

public class Driver {

	public static void main(String[] args) {
		OrderingSystem k = new OrderingSystem();
		FrontController welcome = new FrontController();
		welcome.welcomePage();
		

	}

}
