package com.revature.services;


import java.util.List;

import com.revature.daos.CustomerDao;
import com.revature.daos.CustomerList;
import com.revature.exception.LoginException;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerPostgres;



public class CustomerService {
	protected CustomerDao cd = new CustomerPostgres();

	
	
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
	public Customer login(String username, String password) throws LoginException {
		Customer c = this.getCustomerByUsername(username);
		if(c == null || !c.getPassword().equals(password)) {
			throw new LoginException();
		} 
		c.setLogged(true);
		cd.update(c);
		return c;
	}
	
	
	

}

