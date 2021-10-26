package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.revature.model.Customer;
import com.revature.repositories.CustomerArray;
import com.revature.repositories.CustomerDao;


public class CustomerDaoTest {
	
	private static CustomerDao kr;
	
	public void setup() {
		Customer[] customers = {new Customer("Liam", "Lebron", null, 0, 1)};
		
		kr = new CustomerArray(customers);
		
		
			
		}
	}
	


