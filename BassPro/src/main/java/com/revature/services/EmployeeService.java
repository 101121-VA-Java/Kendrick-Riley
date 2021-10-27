package com.revature.services;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeArray;
import com.revature.repositories.EmployeeDao;

public class EmployeeService {
	
	private EmployeeDao ed;
	
	
	public EmployeeService() {
		super();
		ed = new EmployeeArray();
		
	}
	
	public int addEmployee(Employee e) {
		/*
		 * add business logic here to manipulate e before storage
		 */
	
		e.setRole(null);
		return ed.addEmployee(e);
	}

}


