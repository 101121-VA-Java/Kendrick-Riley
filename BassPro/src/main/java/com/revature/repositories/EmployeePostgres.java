package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;


import Utilites.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {
	
	

	@Override
	public List<Employee> getAll() {
		String sql = "select * from employees;";
		List<Employee> employees = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String username = rs.getString("e_username");
				String password = rs.getString("e_password");
			
			
				Employee newEmp = new Employee(id, name, username, password);
				employees.add(newEmp);
			}
		} catch (IOException | SQLException e1) {
		
			e1.printStackTrace();
		}
		return employees;
	}


	@Override
	public Employee getById(int id) {
		String sql = "select * from employees where e_id = ? ";
		Employee emp = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int e_id = rs.getInt("e_id");
				String e_name = rs.getString("e_name");
				String e_username = rs.getString("e_username");
				String e_password = rs.getString("e_password");
				
		

				 emp = new Employee(e_id, e_name, e_username, e_password); 
				
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	

	@Override
	public Employee add(Employee employee) {
//		int genId = -1;
		String sql = "insert into employees (e_name, e_username, e_password) "
				+ "values (?, ?, ?, ?) returning e_id;";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
		
			

			ResultSet rs = ps.executeQuery();

//			if (rs.next()) {
//				genId = rs.getInt("e_id");
//			}

		} catch (SQLException | IOException e1) {
		
			e1.printStackTrace();
		}

		return employee;
	}
	

	@Override
	public Employee delete(Employee employee) {
		String sql = "delete from employees where e_id = ?;";
		int rowsChanged = -1;
		int id = employee.getId();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
					
			rowsChanged = ps.executeUpdate();
		}
		catch (SQLException | IOException e) {
		
			e.printStackTrace();
		}
		if(rowsChanged > 0) {
			return null;
		}else {
			return employee;
		}
	}

	@Override
	public boolean update(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}



}


