package com.revature.models;

import java.util.Objects;

public class UserRoles {
	
	private int roleId;
	private String role;

	public UserRoles() {
		super();
	
	}

	public UserRoles(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public UserRoles(int roleId) {
		super();
		this.roleId = roleId;
	}

	public UserRoles(String role) {
		super();
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, roleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoles other = (UserRoles) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
//		return Objects.equals(role, other.role) && roleId == other.roleId;
	
	}

}
