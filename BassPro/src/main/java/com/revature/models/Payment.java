package com.revature.models;

import java.util.Objects;

public class Payment {
	
	int cusid;
	double price;
	boolean price_accepted;
	double bid;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int cusid, double price, boolean price_accepted) {
		super();
		this.cusid = cusid;
		this.price = price;
		this.price_accepted = price_accepted;
	}

	@Override
	public String toString() {
		return "Payments [cusid=" + cusid + ", price=" + price + ", price_accepted=" + price_accepted + "]";
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPrice_accepted() {
		return price_accepted;
	}

	public void setPrice_accepted(boolean price_accepted) {
		this.price_accepted = price_accepted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cusid, price, price_accepted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return cusid == other.cusid && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& price_accepted == other.price_accepted;
	}
	
	

}
