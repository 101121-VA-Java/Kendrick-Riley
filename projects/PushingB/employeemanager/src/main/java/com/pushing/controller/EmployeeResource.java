package com.pushing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pushing.model.Employee;
import com.pushing.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	private EmployeeService es;

	public EmployeeResource(EmployeeService es) {
		this.es = es;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = es.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Employee employee = es.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
		Employee newE = es.addEmployee(e);
		return new ResponseEntity<>(newE, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {
		Employee updateE = es.addEmployee(e);
		return new ResponseEntity<>(updateE, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
		es.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
