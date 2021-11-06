package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.CustomerDao;
import com.revature.models.Customer;
import com.revature.models.Employee;


import Utilites.ConnectionUtil;


	public class CustomerPostgres implements CustomerDao{

		@Override
		public Customer add(Customer customer) {

			String sql = "insert into customers (c_name, c_username, c_password) "
					+ "values (?, ?, ?) returning c_id;";

			try (Connection con = ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, customer.getName());
				ps.setString(2, customer.getUsername());
				ps.setString(3, customer.getPassword());
			
				

				ResultSet rs = ps.executeQuery();

//				if (rs.next()) {
//					genId = rs.getInt("e_id");
//				}

			} catch (SQLException | IOException e1) {
			
				e1.printStackTrace();
			}

			return customer;
		}

		@Override
		public Customer getById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Customer> getAll() {
			String sql = "select * from customer;";
			List<Customer> customers = new ArrayList<>();

			try (Connection con = ConnectionUtil.getConnectionFromFile()) {
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);

				while (rs.next()) {
					int id = rs.getInt("c_id");
					String name = rs.getString("c_name");
					String username = rs.getString("c_username");
					String password = rs.getString("c_password");
				
				
					Customer newCus = new Customer(id, name, username, password);
					customers.add(newCus);
				}
			} catch (IOException | SQLException e1) {
			
				e1.printStackTrace();
			}
			return customers;
		}


		@Override
		public boolean update(Customer t) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Customer delete(Customer t) {
			// TODO Auto-generated method stub
			return null;
		}

	
		
	}