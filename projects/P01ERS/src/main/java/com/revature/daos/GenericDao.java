package com.revature.daos;

import java.util.List;

public interface GenericDao<T> {
	int add(T t);

	void delete(int id);

	T getById(int id);

	List<T> getAll();

	int update(T t);

}
