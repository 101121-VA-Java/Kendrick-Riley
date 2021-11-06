package com.revature.services;
import java.util.List;
import com.revature.daos.ItemDao;
import com.revature.daos.ItemList;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.repositories.ItemPostgres;

public class ItemService {
	
	private static ItemDao id = new ItemPostgres();

	
public Item addItem(Item item)  {
		return id.add(item);
		
		}
		
		

		public Item getDecription() {
		List<Item> item = id.getAll();
		for(Item i: item) {
			if(i.getDecription().equals(getDecription())) {
				return i;
			}
		}
		return null;

		
	}
		public void viewInventory() {
			List<Item> item = id.getAll();
			for(Item i: item) {
				System.out.println("Shop items" + i.getId() + i.getDecription() + " " + i.getQuantity()
				+ " " + i.getPrice() );
			}

		
}
}