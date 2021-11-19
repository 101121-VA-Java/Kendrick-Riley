package com.revature.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.EmployeeDao;
import com.revature.services.EmployeeService;





@ExtendWith(MockitoExtension.class)
public class ReimTest {
	
	@Mock
	private EmployeeDao ed;
	
	@InjectMocks
	private EmployeeService es;
	
	@Test
	public void submitMyRequestTest() {
		
		Mockito.when(es.addReimbursementRequest(null)).thenReturn(true);
		boolean expected = true;
		boolean actual = es.addReimbursementRequest(null);
		assertEquals(expected, actual);
	}

}