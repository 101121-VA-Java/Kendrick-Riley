package com.pushing.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pushing.dao.EmployeeDao;
import com.pushing.exception.UserNotFoundException;
import com.pushing.model.Employee;


@Service
public class EmployeeService {
	private EmployeeDao ed;
	
	
	@Autowired
	public EmployeeService(EmployeeDao ed) {
		this.ed = ed;
		
	}
	public Employee addEmployee(Employee e) {
		e.setEmployeeCode(UUID.randomUUID().toString());
		return ed.save(e);
	}
	public List<Employee> findAllEmployees(){
		return ed.findAll();
	}
	public Employee updateEmployee(Employee e) {
		return ed.save(e);
	}
	public void deleteEmployee(Long id) {
		ed.deleteEmployeeById(id);
	}
	public Employee findEmployeeById(Long id) {
		return ed.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
		
	}

}
