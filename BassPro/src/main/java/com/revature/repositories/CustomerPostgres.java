package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Items;

import Utilites.ConnectionUtil;


	public class CustomerPostgres implements CustomerDao{

		@Override
		public Items viewItems() {
			String sql = "select * from items;";
			List<item> items = new ArrayList<>();

			try (Connection con = ConnectionUtil.getConnectionFromFile()) {
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);

				while (rs.next()) {
					int id = rs.getInt("e_id");
					String name = rs.getString("e_name");
					String e_username = rs.getString("e_username");
					String e_password = rs.getString("e_password");
					String role = rs.getString("e_role");
					int man_id = rs.getInt("man_e_id");

					Employee newEmp = new Employee(id, name, e_username, e_password, role, new Employee(man_id));
					employees.add(newEmp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
			
				e1.printStackTrace();
		}

		@Override
		public double makeOffer() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double makePayment() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}