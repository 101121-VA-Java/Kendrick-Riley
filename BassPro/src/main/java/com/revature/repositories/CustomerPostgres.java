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

public class CustomerPostgres implements CustomerDao {

	@Override
	public Customer add(Customer customer) {

		String sql = "insert into customers (c_name, c_username, c_password) " + "values (?, ?, ?);";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getPassword());

			ps.executeUpdate();

		} catch (SQLException | IOException e1) {

			e1.printStackTrace();
		}

		return customer;
	}

	@Override
	public Customer getById(int id) {
		String sql = "select * from customers where c_id = ? ";
		Customer cust = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int c_id = rs.getInt("c_id");
				String c_name = rs.getString("c_name");
				String c_username = rs.getString("c_username");
				String c_password = rs.getString("c_password");
				Boolean logged = rs.getBoolean("c_logged");

				cust = new Customer(c_id, c_name, c_username, c_password, logged);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public List<Customer> getAll() {
		String sql = "select * from customers;";
		List<Customer> customers = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("c_id");
				String name = rs.getString("c_name");
				String username = rs.getString("c_username");
				String password = rs.getString("c_password");
				Boolean logged = rs.getBoolean("c_logged");

				Customer newCust = new Customer(id, name, username, password, logged);
				customers.add(newCust);
			}
		} catch (IOException | SQLException e1) {

			e1.printStackTrace();
		}
		return customers;
	}

	@Override
	public boolean update(Customer customer) {
		String sql = "update customers set c_name = ?, c_username = ?, c_password = ?, c_logged = ? "
				+ "where c_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getPassword());
			ps.setBoolean(4, customer.isLogged());
			ps.setInt(5, customer.getId());

			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Customer delete(Customer customer) {
		String sql = "delete from customers where e_id = ?;";
		int rowsChanged = -1;
		int id = customer.getId();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rowsChanged > 0) {
			return null;
		} else {
			return customer;
		}

	}

}