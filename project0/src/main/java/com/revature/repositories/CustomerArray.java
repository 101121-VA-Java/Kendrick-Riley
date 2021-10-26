package com.revature.repositories;

import com.revature.model.Customer;

public class CustomerArray implements CustomerDao{
	
	private Customer[] customers;
	
	public CustomerArray() {
		super();
	}

		

	@Override
	public Customer[] getAllCustomers() {
		// TODO Auto-generated method stub
		return this.customers;
	}

	@Override
	public Customer getCustomerByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean editCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}	