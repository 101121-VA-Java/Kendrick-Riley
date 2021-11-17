package com.revature.models;

import java.util.Objects;

public class Item {

	private String description;
	private int quantity;
	private double price;
	private int cusId;
	private String status;

	public Item() {
		super();

	}

	public Item(String description, int quantity, double price, int cusId, String status) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.cusId = cusId;
		this.status = status;
	}

	public Item(String description, int quantity, double price) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public Item(String description, int quantity, double price, String status) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	public Item(String description, int quantity, double price, int cusId) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.cusId = cusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Item [description=" + description + ", quantity=" + quantity + ", price=" + price + ", cusId=" + cusId
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cusId, description, price, quantity, status);
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
		return cusId == other.cusId && Objects.equals(description, other.description)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
				&& Objects.equals(status, other.status);
	}

}
