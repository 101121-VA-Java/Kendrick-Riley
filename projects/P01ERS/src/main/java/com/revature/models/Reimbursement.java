package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {

	private int id;
	private double amount;
	private Timestamp submittedDate;
	private Timestamp  resolvedDate;
	private String description;
	private User author;
	private User resolver;
	private ReimbursementStatus status_Id;
	private ReimbursementType type_Id;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int id, double amount, Timestamp submittedDate, Timestamp resolvedDate, String description,
			User author, User resolver, ReimbursementStatus status_Id, ReimbursementType type_Id) {
		super();
		this.id = id;
		this.amount = amount;
		this.submittedDate = submittedDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_Id = status_Id;
		this.type_Id = type_Id;
	}

	public Reimbursement(double amount, Timestamp submittedDate, Timestamp resolvedDate, String description,
			User author, User resolver, ReimbursementStatus status_Id, ReimbursementType type_Id) {
		super();
		this.amount = amount;
		this.submittedDate = submittedDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_Id = status_Id;
		this.type_Id = type_Id;
	}

	public Reimbursement(double amount, Timestamp submittedDate, Timestamp resolvedDate, String description,
			User author, User resolver, ReimbursementStatus status_Id) {
		super();
		this.amount = amount;
		this.submittedDate = submittedDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_Id = status_Id;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submittedDate=" + submittedDate + ", resolvedDate="
				+ resolvedDate + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", status_Id=" + status_Id + ", type_Id=" + type_Id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Timestamp getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Timestamp resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public ReimbursementStatus getStatus_Id() {
		return status_Id;
	}

	public void setStatus_Id(ReimbursementStatus status_Id) {
		this.status_Id = status_Id;
	}

	public ReimbursementType getType_Id() {
		return type_Id;
	}

	public void setType_Id(ReimbursementType type_Id) {
		this.type_Id = type_Id;
	}


	
}
