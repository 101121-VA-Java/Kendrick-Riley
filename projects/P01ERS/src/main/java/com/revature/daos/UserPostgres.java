package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.User;
import com.revature.models.UserRoles;

import Utilites.ConnectionUtil;

public class UserPostgres implements UserDao {

	@Override
	public User add(User user) {
		String sql = "insert into ERS_Users (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) "
				+ "values (?, ?, ?, ?, ?, ?);";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());

			ps.executeUpdate();

		} catch (SQLException | IOException e1) {

			e1.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> getAll() {
		String sql = "select * from ers_users;";
		List<User> user = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int userId = rs.getInt("ERS_USER_ID");
				String userName = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				
				
				User newUser = new User(userId, userName, password, firstName, lastName, email, roleId);
				user.add(newUser);
			}
		} catch (IOException | SQLException e1) {

			e1.printStackTrace();
		}
		return user;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User viewMyInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateMyInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
