package com.revature.repositories;

import com.revature.models.Customer;

public class CustomerArray implements CustomerDao {

		private Customer[] customers;
		
		public CustomerArray() {
			super();
		}
		public CustomerArray(Customer[] customers) {
			this.customers = customers;
		}
		@Override
		public Customer[] getAllCustomers() {
			
			return this.customers;
		}
		@Override
		public Customer getCustomerById(int id) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int addCustomer(Customer c) {
			Customer[] temp = new Customer[customers.length + 1];
			
			int i = 0;
			
			for(; i < customers.length; i++) {
				temp[i] = customers[i];
			}
			c.setId(i);
			temp[i] = c;
			customers = temp;
			return i;
			
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
