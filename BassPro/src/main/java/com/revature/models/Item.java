package com.revature.models;

import java.util.Objects;

public class Item {
	private int id;
	private String decription;
	private int quantity;
	private boolean itemAvail;

	
	public Item(int id, String decription, int quantity, boolean itemAvail) {
		super();
		this.id = id;
		this.decription = decription;
		this.quantity = quantity;
		this.itemAvail = itemAvail;
	}


	public Item() {
	super();
	
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


	public boolean isItemAvail() {
		return itemAvail;
	}


	public void setItemAvail(boolean itemAvail) {
		this.itemAvail = itemAvail;
	}


	@Override
	public int hashCode() {
		return Objects.hash(decription, id, itemAvail, quantity);
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
		return Objects.equals(decription, other.decription) && id == other.id && itemAvail == other.itemAvail
				&& quantity == other.quantity;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", decription=" + decription + ", quantity=" + quantity + ", itemAvail=" + itemAvail
				+ "]";
	}
	

}
