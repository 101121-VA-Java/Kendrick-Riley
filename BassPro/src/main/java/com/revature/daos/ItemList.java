package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;


public class ItemList implements ItemDao {
	
	public List<Item> items;  

	public ItemList(){
		items = new ArrayList<>();
		Item a0 = new Item(0, "Abu Garcia Revo", 25,true);
		
}

	@Override
	public Item add(Item t) {
		t.setId(items.size());
		items.add(t);
		return t;
	}

	@Override
	public Item getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Item t) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}