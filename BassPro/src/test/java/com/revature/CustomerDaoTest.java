package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.revature.models.Customer;
import com.revature.repositories.CustomerArray;
import com.revature.repositories.CustomerDao;


public class CustomerDaoTest {

		private static CustomerDao kr;
		
		@BeforeEach
		public void setup() {
			Customer[] customers = {new Customer(0, "Liam", "Liam24","Peace")};
			
			kr = new CustomerArray(customers);
		}
		
		@Test
		public void getAllCustomers() {
			Customer[] expected = {new Customer(0, "Liam", "Liam24","Peace")};
			Customer[] actual = kr.getAllCustomers();
			assertArrayEquals(expected, actual);
		}
		
		@Test
		public void addCustomerVaild() {
			Customer[] expected = {new Customer(0,"Liam", "Liam24","Peace"),
					               new Customer(1, "Tris", "Tris24", "Love")};
			
			kr.addCustomer(new Customer(1, "Tris", "Tris24", "Love"));
			
			assertArrayEquals(expected, kr.getAllCustomers());
			}
		
		
		}


