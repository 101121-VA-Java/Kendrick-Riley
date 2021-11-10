package com.revature.daos;

import java.util.List;

public interface GenericDao<T> {

	T add(T t);

	T getById(int id);

	List<T> getAll();

	boolean update(T t);

	T delete(T t);
}
