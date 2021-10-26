package com.revature.model;

import java.util.Objects;

public class Customer {
	
	private String name;
	private String username;
	private String password;
	private int id;
	private int creditCardNum;
	
	public Customer() {
		super();
	}
	
	public Customer(String name, String username, String password, int id,
			int creditCardNum) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreditCardNum() {
		return creditCardNum;
	}

	public void setCreditCardNum(int creditCardNum) {
		this.creditCardNum = creditCardNum;
	}


	@Override
	public String toString() {
		return "Customers [name=" + name + ", username=" + username + ", password=" + password + ", id=" + id
				+ ", creditCardNum=" + creditCardNum + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(creditCardNum, id, name, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return creditCardNum == other.creditCardNum && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	




	
	
	
	
}
