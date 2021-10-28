package com.revature.daos;

import java.util.List;

import com.revature.daos.GenericDao;
import com.revature.models.Employee;

public interface EmployeeDao extends GenericDao<Employee>{
	
	Employee[] getAllEmployees(); // returns an array of all of the employees available
	Employee getEmployeeById(int id);
	int addEmployee(Employee e); // returns assigned id
	boolean editEmployee(Employee e);  //returns boolean depending on operation success 
	
}



