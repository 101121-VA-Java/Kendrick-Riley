package com.revature.models;

import java.util.Objects;

public class User {
	
	private int userId;
	private String name;
	private String password;
	private String register;	

	public User() {
	
	}
	
	public User(String name, String password, String register) {
		super();
		this.name = name;
		this.password = password;
		this.register = register;
	}



	public User(int userId, String name, String password, String register) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.register = register;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRegister() {
		return register;
	}



	public void setRegister(String register) {
		this.register = register;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", register=" + register + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(name, password, register, userId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(register, other.register) && userId == other.userId;
	}
	
	
	
}