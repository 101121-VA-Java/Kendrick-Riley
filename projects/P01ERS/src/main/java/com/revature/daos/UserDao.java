package com.revature.daos;

import com.revature.models.User;

public interface UserDao extends GenericDao<User>{

	boolean loginUser(User u);
	User getUserByUsername(String username);
	User getUserById(int userId);
	User viewMyInfo(User u);
	User updateMyInfo(User u);
}
