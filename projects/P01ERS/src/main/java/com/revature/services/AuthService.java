package com.revature.services;
import java.io.IOException;
import java.util.Arrays;
import com.revature.daos.UserDao;
import com.revature.models.UserRoles;
import com.revature.models.User;

public class AuthService {

	private UserDao ud;

	public AuthService() {

	}

	public String login(String username, String password) {

		String token = null;

		User principal = ud.getUserByUsername(username);

		if (principal != null && principal.getPassword().equals(password)) {
			token = principal.getUserId() + ":" + principal.getRoleId();
		}

		return token;
	}

	
	
	public boolean checkPermission(String token) throws IOException {

		if(token == null) {
			return false;
		}
		
		String[] info = token.split(":"); 
		int token_id = Integer.parseInt(info[0]);
		int token_role = Integer.parseInt(info[1]);
		
		User principal = ud.getById(token_id);
		
		if(principal != null && token_role == principal.getRoleId()
				&& token_role == 2) {
			return true;
		}
		
		return false;
	}

}
