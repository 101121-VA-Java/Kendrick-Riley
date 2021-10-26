package com.revature.repositories;

import com.revature.models.Customer;

public interface CustomerDao {
	Customer[] getAllCustomers(); //Return array of all
	Customer getCustomerById(int id); 
	int addCustomer(Customer c); //Return signed id
	boolean editCustomer(Customer c); // Return t or f
	boolean deleteCustomer(int id);	 // Return t or f
}
