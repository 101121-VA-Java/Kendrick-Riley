package com.revature.models;

import java.util.Objects;

public class Item {
	

	private String decription;
	private int quantity;
	private double price;
	private int stocked;
	private int cusId;
	private String status;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String decription, int quantity, double price, int stocked, int cusId, String status) {
		super();
		this.decription = decription;
		this.quantity = quantity;
		this.price = price;
		this.stocked = stocked;
		this.cusId = cusId;
		this.status = status;
	}

	public Item(String decription, int stocked) {
		super();
		this.decription = decription;
		this.stocked = stocked;
	}

	public Item(String decription, int quantity, double price, int stocked, String status) {
		super();
		this.decription = decription;
		this.quantity = quantity;
		this.price = price;
		this.stocked = stocked;
		this.status = status;
	}

	public Item(String decription, double price, int stocked) {
		super();
		this.decription = decription;
		this.price = price;
		this.stocked = stocked;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStocked() {
		return stocked;
	}

	public void setStocked(int stocked) {
		this.stocked = stocked;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Item [decription=" + decription + ", quantity=" + quantity + ", price=" + price + ", stocked=" + stocked
				+ ", cusId=" + cusId + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cusId, decription, price, quantity, status, stocked);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return cusId == other.cusId && Objects.equals(decription, other.decription)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
				&& Objects.equals(status, other.status) && stocked == other.stocked;
	}
	


}
