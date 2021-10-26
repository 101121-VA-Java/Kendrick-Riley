package com.revature.services;

import com.revature.model.Customer;
import com.revature.repositories.CustomerDao;

public class CustomerServices {
	
	private CustomerDao kr;
	
	public int addCustomer(Customer c) {
		return kr.addCustomer(c);	
	}
}
