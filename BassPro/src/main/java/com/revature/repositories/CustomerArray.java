package com.revature.repositories;

import com.revature.models.Customer;
import com.revature.models.Item;

public class CustomerArray implements CustomerDao {

		private Customer[] customers;
		

		public CustomerArray() {
			super();
		}
		public CustomerArray(Customer[] customers) {
			this.customers = customers;
		}
		@Override
		public Item viewItems() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public double makeOffer() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public double makePayment() {
			// TODO Auto-generated method stub
			return 0;
		}
	
}
