package com.revature.services;
import java.util.List;
import com.revature.daos.ItemDao;
import com.revature.daos.ItemList;
import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.repositories.ItemPostgres;

public class ItemService {
	
	private static ItemDao id = new ItemPostgres();

	
	public Item addItem(Item i){
		Item checkItem = this.getDecription();
		if(checkItem != null ){
			int quan = checkItem.getQuantity() + i.getQuantity();
			i.setQuantity(quan);
			checkItem.setQuantity(quan);
			return checkItem; 
		} else {
			return id.add(i);
		}
			
	}

		public Item getDecription() {
		List<Item> items = id.getAll();
		for(Item i: items) {
			if(i.getDecription().equals(getDecription())) {
				return i;
			}
		}
		return null;

		
	}
		public List<Item> getAll() {
			List<Item> items = id.getAll();
			for()
			return items;
		
}
}