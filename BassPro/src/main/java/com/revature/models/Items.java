package com.revature.models;

import java.util.Objects;

public class Items {
	public int itemId;
	public String decription;
	public int quantity;
	public boolean itemAvail;

	
	public Items() {
	super();
	
	}


	public Items(int itemId, String decription, int quantity, boolean itemAvail) {
		super();
		this.itemId = itemId;
		this.decription = decription;
		this.quantity = quantity;
		this.itemAvail = itemAvail;
	}


	public Items(int itemId) {
		super();
		this.itemId = itemId;
	}


	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", decription=" + decription + ", quantity=" + quantity + ", itemAvail="
				+ itemAvail + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(decription, itemAvail, itemId, quantity);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return Objects.equals(decription, other.decription) && itemAvail == other.itemAvail && itemId == other.itemId
				&& quantity == other.quantity;
	}
	
	
}
