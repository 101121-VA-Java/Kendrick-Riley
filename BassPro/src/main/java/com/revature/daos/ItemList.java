package com.revature.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Employee;
import com.revature.models.Item;


public class ItemList extends Item implements ItemDao {
	
	
	
	public static List<Item> items;  
	
	public ItemList(){
		items = new ArrayList<>();
		Item a0 = new Item(0,"Abu Garcia Revo", 25,true);
		Item a1 = new Item(1, "Lew's Pro", 20,true);
		Item a2 = new Item(2, "Penn", 5,true);
		Item a3 = new Item(3, "Daiwa Lexa" , 15,true);
		add(a0);
//		System.out.println(items.size());
		add(a1);
		add(a2);
		add(a3);
//		System.out.println(items.size());
}

	@Override
	public Item add(Item t) {
//		t.setId(.size());
//		t.setDecription(getDecription());
		System.out.println("" + items.size());
//		System.out.println("" + t.getId());
		System.out.println("" + t.getDecription());
		System.out.println("" + t.getQuantity());
		System.out.println("" + t.isItemAvail());
		System.out.println("....");
		items.add(t);
		return t;
	}

	@Override
	public Item getById(int id) {
		for (Item i : items) {
			if (i.getId() == id) {
				return i;
			}
		}
				return null;	
	}
		
	@Override
	public List<Item> getAll() {
		return items;
	}

	@Override
	public boolean update(Item t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteItem() {
		for(Item name: items) {
			System.out.print("Items are " + name);
//		}if(items name == name) {
//			items.remove(0);
//		}
			
		
}
		}

	public static void add(int i, String string, int j, boolean b) {
		// TODO Auto-generated method stub
		
	}
	}