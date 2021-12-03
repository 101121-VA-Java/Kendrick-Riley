package com.revature.services;

import java.util.Arrays;
import com.revature.models.*;
import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.models.Role;
import com.revature.models.User;

public class AuthService {

	public UserDao ud = new UserPostgres();

	public String login(String username, String password) {

		String token = null;

		User principal = ud.getUserByUsername(username);

		if (principal != null && principal.getPassword().equals(password)) {
			/*
			 * poor token implementation, for example's sake - based on this token, a user
			 * can be authenticated when making a request - user-id:role
			 */
			token = principal.getId() + ":" + principal.getRoleId();
		}

		return token;
	}

	/**
	 * Service method to check the permission of the user to access certain
	 * functionalities
	 * 
	 * @param String token, Role... allowedRoles
	 * @return true if a user is authenticated and has permission, false otherwise
	 */
	public boolean checkPermission(String token, int role) {
		String[] info = token.split(":");

		// 1 = admin, 2 = manager, 3 = employee 4 = manager and admin

		int token_id = Integer.parseInt(info[1]);

		if (token_id == role) {
			return true;
		}
		if (role == 4) {
			if (token_id == 1 || token_id == 2) {
				return true;
			}
			return false;
		}

		return false;

	}

}