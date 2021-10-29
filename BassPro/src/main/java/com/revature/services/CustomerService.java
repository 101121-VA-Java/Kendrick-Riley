package com.revature.services;


import java.util.List;

import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.models.CustomerList;
import com.revature.repositories.CustomerDao;

public class CustomerService {

	private static CustomerDao cd = new CustomerList();
	
	public Customer addCustomer(Customer c) throws UsernameAlreadyExistsException{
		
		Customer newCustomer = this.getCustomerByUsername(c.getUsername());
		if(newCustomer != null) {
			throw new UsernameAlreadyExistsException();
		}
		
		return cd.add(c);
	}

	private Customer getCustomerByUsername(String username) {
		List<Customer> customers = cd.getAll();
		for(Customer c : customers) {
			if(c.getUsername().equals(username)) {
				return c;
			}
		}
		return null;
	}
	
	
	

}

