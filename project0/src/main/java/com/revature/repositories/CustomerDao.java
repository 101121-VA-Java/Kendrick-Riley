package com.revature.repositories;

import com.revature.model.Customer;

public interface CustomerDao {
	Customer[] getAllCustomers(); // Returns an array
	Customer getCustomerByID(int id);
	int addCustomer(Customer c); //Return assigned id
	boolean editCustomer(Customer c); //Return true or false
	boolean deleteCustomer(int id); //Return true or false
	
}
