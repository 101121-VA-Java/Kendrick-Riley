package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.TestMethodOrder;

import com.revature.daos.ItemDao;
import com.revature.models.Item;
import com.revature.repositories.ItemPostgres;
import com.revature.services.ItemService;

public class ItemServiceTest {

	@TestMethodOrder(OrderAnnotation.class)

	public class ItemServicesTest {

		private ItemService is = new ItemService();
		private ItemDao id = new ItemPostgres();

		@Test
		public void addSkisCheck() {
//			Item newItem = new Item("description", quantity, price, 0, "Available");
//			Item actual = is.add(newItem);
			Item expected = id.getById(4);
//			assertEquals(expected,actual);
		}

	}
}
