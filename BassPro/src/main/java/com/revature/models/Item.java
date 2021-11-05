package com.revature.models;

import java.util.Objects;

public class Item {
	
	private int id;
	private String decription;
	private int quantity;
	private double price;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String decription, int quantity, double price) {
		super();
		this.id = id;
		this.decription = decription;
		this.quantity = quantity;
		this.price = price;
	}

	public Item(String decription) {
		super();
		this.decription = decription;
	}

	public Item(int id, String decription, int quantity) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Item [id=" + id + ", decription=" + decription + ", quantity=" + quantity + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(decription, id, price, quantity);
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
		return Objects.equals(decription, other.decription) && id == other.id
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
	}

}
