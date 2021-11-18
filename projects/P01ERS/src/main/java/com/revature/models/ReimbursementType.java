package com.revature.models;

public class ReimbursementType {

	private int typeId;
	private String type;

	public ReimbursementType() {
		super();
		
	}

	public ReimbursementType(String type) {
		super();
		this.type = type;
	}

	public ReimbursementType(int typeId) {
		super();
		this.typeId = typeId;
	}

	public ReimbursementType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbursementType [typeId=" + typeId + ", type=" + type + "]";
	}

}
