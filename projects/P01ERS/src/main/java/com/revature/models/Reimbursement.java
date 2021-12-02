package com.revature.models;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Objects;

public class Reimbursement {

	private int id;
	private int amount;
	private Timestamp submittedDate;
	private Timestamp resolvedDate;
	private String description;
	private int author;
	private int resolver;
	private int status_Id;
	private int type_Id;


	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int id, int amount, Timestamp submittedDate, Timestamp resolvedDate, String description,
			int author, int resolver, int status_Id, int type_Id) {
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

	public Reimbursement(int amount, Timestamp submittedDate, Timestamp resolvedDate, String description, int author,
			int resolver, int status_Id, int type_Id) {
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

	public Reimbursement(int amount, Timestamp submittedDate, Timestamp resolvedDate, String description, int author,
			int resolver, int status_Id) {
		super();
		this.amount = amount;
		this.submittedDate = submittedDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_Id = status_Id;
	}

	public Reimbursement(int amount, Timestamp submittedDate, int status_Id, int type_Id, int author) {
		this.submittedDate = submittedDate;
		this.status_Id = status_Id;
		this.type_Id = type_Id;
		this.amount = amount;
		this.author = author;
	}
	public Reimbursement(int amount, Timestamp submittedDate, int status_Id, int type_Id) {
		this.submittedDate = submittedDate;
		this.status_Id = status_Id;
		this.type_Id = type_Id;
		this.amount = amount; 
	}

	public Reimbursement(int id) {
		super();
		this.id = id;
	}


	public Reimbursement(int amount, Timestamp submittedDate, int status_Id, int author, int type_Id, int resolver) {
		this.amount = amount;
		this.submittedDate = submittedDate;
		this.status_Id = status_Id;
		this.author = author;
		this.type_Id = type_Id;
		this.resolver = resolver;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatus_Id() {
		return status_Id;
	}

	public void setStatus_Id(int status_Id) {
		this.status_Id = status_Id;
	}

	public int getType_Id() {
		return type_Id;
	}

	public void setType_Id(int type_Id) {
		this.type_Id = type_Id;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submittedDate=" + submittedDate + ", resolvedDate="
				+ resolvedDate + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", status_Id=" + status_Id + ", type_Id=" + type_Id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, resolvedDate, resolver, status_Id, submittedDate, type_Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return amount == other.amount && author == other.author && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(resolvedDate, other.resolvedDate) && resolver == other.resolver
				&& status_Id == other.status_Id && Objects.equals(submittedDate, other.submittedDate)
				&& type_Id == other.type_Id;
	}

}
