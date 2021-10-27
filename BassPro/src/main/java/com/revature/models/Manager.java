package com.revature.models;

import java.util.Objects;

public class Manager extends Employee{
	
	private String creatEmployee;
	private String removeEmployee;
	private String viewSalesHistory;
	
	
	public Manager() {
		super();
	}

	public Manager(String creatEmployee, String removeEmployee, String viewSalesHistory) {
		super();
		this.creatEmployee = creatEmployee;
		this.removeEmployee = removeEmployee;
		this.viewSalesHistory = viewSalesHistory;
	}

	public String getCreatEmployee() {
		return creatEmployee;
	}

	public void setCreatEmployee(String creatEmployee) {
		this.creatEmployee = creatEmployee;
	}

	public String getRemoveEmployee() {
		return removeEmployee;
	}

	public void setRemoveEmployee(String removeEmployee) {
		this.removeEmployee = removeEmployee;
	}

	public String getViewSalesHistory() {
		return viewSalesHistory;
	}

	public void setViewSalesHistory(String viewSalesHistory) {
		this.viewSalesHistory = viewSalesHistory;
	}

	@Override
	public String toString() {
		return "Manager [creatEmployee=" + creatEmployee + ", removeEmployee=" + removeEmployee + ", viewSalesHistory="
				+ viewSalesHistory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(creatEmployee, removeEmployee, viewSalesHistory);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(creatEmployee, other.creatEmployee)
				&& Objects.equals(removeEmployee, other.removeEmployee)
				&& Objects.equals(viewSalesHistory, other.viewSalesHistory);
	}
	
	
	
	
	
	
}
