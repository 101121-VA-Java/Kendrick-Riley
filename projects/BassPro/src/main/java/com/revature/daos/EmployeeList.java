package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;

public class EmployeeList implements EmployeeDao {

	private List<Employee> employees;

	public EmployeeList() {
		employees = new ArrayList<>();

	}

	@Override
	public Employee add(Employee t) {

		t.setId(employees.size());
		employees.add(t);
		return t;
	}

	@Override
	public Employee getById(int id) {
		for (Employee e : employees) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getAll() {

		return employees;
	}

	@Override
	public boolean update(Employee t) {
		Employee temp = getById(t.getId());
		if (temp == null || temp.equals(t)) {
			return false;
		}
		employees.set(t.getId(), t);
		return true;
	}

	@Override
	public Employee delete(Employee t) {
		employees.remove(t);
		return t;
	}

}
