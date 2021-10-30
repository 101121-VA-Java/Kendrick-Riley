package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class UserList implements UserDao {

	public List<User> Users;
	
	public UserList() {
	Users = new ArrayList<>();
}

	@Override
	public User add(User t) {
		t.setId(Users.size());
		Users.add(t);
		return t;	
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

}
