package com.revature.services;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.exception.LoginException;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Role;
import com.revature.models.User;
import java.util.stream.Collectors;

public class UserService {

	protected UserDao ud = new UserPostgres();

	public int addUser(User user) {
		// assigning a default manager/role
		user.setManager(new User(2));
		System.out.println("ROLE IS" + user.getManager());
		user.setRole(Role.EMPLOYEE);

		return ud.add(user);
	}

	public User getByUsername(String username) {
		User user = ud.getUserByUsername(username);
		if (user != null) {
			user.setPassword(null);
		}

		return user;
	}

	public User getUserById(int id) {
		System.out.println("At service line 35");
		User user = ud.getUserById(id);
		if (user != null) {
			user.setPassword(null);
		}
		return user;
	}
//	gets all users used by manager
	public List<User> getUsers() {
		System.out.println("here@service getusers");
		List<User> users = ud.getAll().stream().map(e -> {
			e.setPassword(null);
			return e;
		}).collect(Collectors.toList());
		return users;
	}

	public int updateUser(User u) {
		System.out.println(u);
		return ud.update(u);

	}



}
