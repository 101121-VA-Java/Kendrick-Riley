package com.revature;

import com.revature.controllers.FrontController;
import com.revature.controllers.RegistrationController;
import com.revature.daos.ItemList;
import com.revature.models.OrderingSystem;

public class Driver {

	public static void main(String[] args) {
		OrderingSystem k = new OrderingSystem();
		FrontController welcome = new FrontController();
		ItemList it = new ItemList();
//		welcome.welcomePage();
		it.getAll();

	}

}
