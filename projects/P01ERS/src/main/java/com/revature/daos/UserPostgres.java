package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.UserRoles;

import Utilites.ConnectionUtil;

public class UserPostgres implements UserDao {

	@Override
	public int add(User user) {
		int newUser = -1;
		String sql = "insert into ERS_Users (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) "
				+ "values (?, ?, ?, ?, ?, ?, ?) returning ERS_USER_ID;";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRoleId());
			ps.setInt(7, user.getManager().getId());

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				newUser = rs.getInt("ERS_USER_ID");
			}

		} catch (SQLException | IOException e1) {

			e1.printStackTrace();
		}

		return newUser;
	}
//Used for manager
	@Override
	public List<User> getAll() {
		System.out.println("@ Postgres");
		String sql = "select * from ers_users;";
		List<User> user = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				User newUser = new User (
							rs.getInt("ERS_USER_ID"),
							rs.getString("ERS_USERNAME"),
							rs.getString("ERS_PASSWORD"),
							rs.getString("USER_FIRST_NAME"),
							rs.getString("USER_LAST_NAME"),
							rs.getString("USER_EMAIL"),
							rs.getInt("USER_ROLE_ID"),
							new User(rs.getInt("ERS_USER_ID")));
							user.add(newUser);

				
			}
		} catch (IOException | SQLException e1) {

			e1.printStackTrace();
		}
		return user;
	}

	@Override
	public User getById(int id) {
		System.out.println("At postgres line 84");
		User u = null;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			String sql = "select * from ers_users where ERS_USER_ID = ?;";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				u = new User(
						rs.getInt("ERS_USER_ID"),
						rs.getString("ERS_USERNAME"), 
						rs.getString("ERS_PASSWORD"),
						rs.getString("USER_FIRST_NAME")); 
//						Role.valueOf(rs.getString("u_role")));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return u;
	}



	@Override
	public User getUserByUsername(String username) {
	
		String sql =  "select * from ers_users where ers_username = ?;";
		User u = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				u = new User(
							rs.getInt("ERS_USER_ID"),
							rs.getString("ERS_USERNAME"),
							rs.getString("ERS_PASSWORD"),
							rs.getString("USER_FIRST_NAME"),
							rs.getString("USER_LAST_NAME"),
							rs.getString("USER_EMAIL"),
							rs.getInt("user_role_id"));
							 new User (rs.getInt("MANAGER_ID"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
	}
		return u;
	}

	@Override
	public User getUserById(int userId) {
		System.out.println("At postgres line 143");
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

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	   public int update(User u) {
	        int result = 0;
			try (Connection con = ConnectionUtil.getConnectionFromFile()){
				String sql = "UPDATE ers_users SET ers_username = ?, ers_password = ?, user_email = ?, user_first_name = ?, user_last_name = ?, user_role_id = ? WHERE ers_user_id = ?;";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, u.getUserName());
	            ps.setString(2, u.getPassword());
	            ps.setString(3, u.getEmail());
	            ps.setString(4, u.getFirstName());
	            ps.setString(5, u.getLastName());
	            ps.setInt(6, u.getRoleId());
//				ps.setInt(7, u.getManager().getId());
				ps.setInt(7, u.getId());
				result = ps.executeUpdate();
				if (result > 0) return result;
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return result;
	    }
}
