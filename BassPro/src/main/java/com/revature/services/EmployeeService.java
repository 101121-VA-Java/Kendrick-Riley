package com.revature.services;


import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeList;
import com.revature.exception.LoginException;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.repositories.EmployeePostgres;

public class EmployeeService {
	
	private static EmployeeDao ed = new EmployeePostgres();
	
	
	public Employee addEmployee(Employee employee) throws UsernameAlreadyExistsException {
		
		Employee newHire = this.getEmployeeByUsername(employee.getUsername());
		if(newHire != null) {
			throw new UsernameAlreadyExistsException();// changed e to employee?? 
		}
		
		return ed.add(employee);
}


	private Employee getEmployeeByUsername(String username) {
		List<Employee> employees = ed.getAll();
		for(Employee e : employees) {
			if(e.getUsername().equals(username)) {
				return e;
			}
		}
		
		return null;
	}


	public Employee login(String username, String password) throws LoginException {
		Employee emp = this.getEmployeeByUsername(username);
		if(emp == null || !emp.getPassword().equals(password)) {
			throw new LoginException();
		}
		return emp;
	}
	
	
	
}
