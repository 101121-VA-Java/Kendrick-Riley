package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.revature.daos.CustomerDao;
import com.revature.exception.LoginException;
import com.revature.models.Customer;

import com.revature.repositories.CustomerPostgres;
import com.revature.services.CustomerService;

public class CustomerDaoTest {
	private int id;
	private String name;
	private String username;
	private String password;
	private boolean logged;

	private static CustomerService cs = new CustomerService();
	private static CustomerDao cd = new CustomerPostgres();

	@BeforeEach
	public void setup() {

		Customer[] customers = { new Customer(0, "Liam", "Liam24", "Peace") };

	}

	@Test
	public void getAllCustomers() {
		List<Customer> expected = new ArrayList<Customer>();
//			expected.add(new Customer(0, "Liam", "Liam24","Peace", true, new (1)));
//			actual = kr.getAllCustomers();
//			assertArrayEquals(expected, actual);
	}

	@Test
	public void loginCheck() throws LoginException {
		Customer newCustomer = new Customer(2, "name", "username", "password", logged);
		Customer expected = newCustomer;
		Customer actual = cs.login("email", "password");
		assertEquals(expected, actual);
	}

}
