package com.revature.services;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.exception.LoginException;
import com.revature.exception.UsernameAlreadyExistsException;

import com.revature.models.User;

public class UserService {
	protected UserDao ud = new UserPostgres();

	public User add(User user) throws UsernameAlreadyExistsException {

		User newUser = this.getUserByUsername(user.getUserName());
		if (newUser != null) {
			throw new UsernameAlreadyExistsException();
		}

		return ud.add(user);
	}

	public User getUserByUsername(String userName) {
		List<User> user = ud.getAll();
		for (User u : user) {
			if (u.getUserName().equals(userName)) {
				return u;
			}
		}
		return null;
	}

	public User login(String userName, String password) throws LoginException {
		User user = this.getUserByUsername(userName);
		if (user == null || !user.getPassword().equals(password)) {
			throw new LoginException();
		}
		ud.update(user);
		return user;
	}
}
