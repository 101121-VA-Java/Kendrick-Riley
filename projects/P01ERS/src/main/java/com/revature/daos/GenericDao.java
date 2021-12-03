package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface GenericDao<T> {
	int add(T t);

	void delete(int id);

	T getById(int id);

	List<T> getAll();

	int update(T t);

	boolean edit(Reimbursement r);

}
