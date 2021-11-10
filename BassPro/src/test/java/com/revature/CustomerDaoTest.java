package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.revature.models.Customer;

import com.revature.repositories.CustomerPostgres;


public class CustomerDaoTest {
	private int id;
	private String name;
	private String username;
	private String password;
	private boolean logged;
	
	 cd = new CustomerPostgres();
		@BeforeEach
		public void setup() {
			
		 
			Customer[] customers = {new Customer(0, "Liam", "Liam24","Peace")};
			
	
		}
		
		@Test
		public void getAllCustomers() {
			List<Customer> expected = new ArrayList<Customer>();
			expected.add(new Customer(0, "Liam", "Liam24","Peace", true, new (1)));
			actual = kr.getAllCustomers();
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


