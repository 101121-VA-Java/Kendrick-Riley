package com.revature.daos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDaoTest {
	@Mock
	private EmployeeDao ed;
	
	@InjectMocks
	private EmployeeService es;

//	private EmployeeDao ed = new EmployeeList();
//	
//	@BeforeEach
//	public void setUp() {
//		ed = new EmployeeList();
//		
//	}
//	
//	@Test
//	public void getAll() {
//		List<Employee> expected = new ArrayList<>();
//		expected.add(new Employee(0, "System Admin", "System Admin", "AdminPass"
//				                                           , Role.Admin, null));
//		assertEquals(expected, ed.getAll());
//	}
//	
//	@Test
//	public void getIdByEmployee() {
//		Employee expected = new Employee(0, "System Admin", "System Admin", "AdminPass",
//				Role.Admin, null);
//		assertEquals(expected, ed.getById(0));
//	}
//	


@Test
public void addEmployeeVaild() {
	
//	Mockito.when(ed.addEmployee(new Employee(0, "test","test","test"))).thenReturn(1);
	
//	Employee expected = new Employee(1, "test", "test", "test");
//	try {
//		Employee actual = es.addEmployee(new Employee("test", "test", "test"));
//		assertEquals(expected, actual);
//	} catch (UsernameAlreadyExistsException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	
//	}
}
	
}