package com.revature.services;

import com.revature.models.Customer;
import com.revature.repositories.CustomerDao;

public class CustomerService {

	private CustomerDao kr;
	
	public int addCustomer(Customer c) {
		//business logic goes here
		
		return kr.addCustomer(c);
	}
}
