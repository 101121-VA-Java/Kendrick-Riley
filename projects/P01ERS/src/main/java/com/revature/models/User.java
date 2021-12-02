package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private int userId;
	private String userName;
	private String password;
	protected String firstName;
	protected String lastName;
	private String email;
	private Role role;
	private User manager;

	public User() {
		super();
		
	}
	public User(int id) {
		super();
		this.userId = id;
	}

	public User(String username, String password, String firstName, String lastName, String email) {
		super();
		this.userName = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User(String username, String password, String firstName, String lastName, String email, Role role, User manager) {
		super();
		this.userName = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.manager = manager;
	}

	public User(int id, String username, String password, String firstName, String lastName, String email, int roleId, User manager){
		this.userId = id;
		this.userName = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = setRoleFromId(roleId);
		this.manager = manager;
	}

	public User(int id, String username, String firstName, String lastName, String email, int roleId, User manager) {
		this.userId = id;
		this.userName = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = setRoleFromId(roleId);
		this.manager = manager;
	}


	
	
	public User(int userId, String userName, String password, String firstName, String lastName, String email,
			int roleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = setRoleFromId(roleId);
	}
	

	
	public User(int userId, String userName, String password, String firstName, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.role = role;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	TODO Fix get Id.
	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role setRoleFromId(int roleId){
		if (roleId == 1) {
			setRole(Role.ADMIN);
			return Role.ADMIN;
		} else if (roleId == 2) {
			setRole(Role.MANAGER);
			return Role.MANAGER;
		} else if (roleId == 3) {
			setRole(Role.EMPLOYEE);
			return Role.EMPLOYEE;
		}
		return null;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

    public int getRoleId() {
        if (role == Role.ADMIN) 
        	return 1;
		else if (role == Role.MANAGER) 
			return 2;
		else if (role == Role.EMPLOYEE)
			return 3;
		else return -1;
    }
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + ", manager=" + manager
				+ "]";
	}
	public User(int userId, String userName, String password, String firstName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
	}
	


}
