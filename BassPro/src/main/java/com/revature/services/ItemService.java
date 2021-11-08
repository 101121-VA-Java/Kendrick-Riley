package com.revature.services;
import java.util.List;
import java.util.Scanner;

import com.revature.controllers.CustomerMenu;
import com.revature.daos.CustomerDao;
import com.revature.daos.ItemDao;
import com.revature.daos.ItemList;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.repositories.CustomerPostgres;
import com.revature.repositories.ItemPostgres;

public class ItemService {
	private static Scanner sc = new Scanner(System.in);
	private static ItemDao id = new ItemPostgres();
	private static CustomerDao cd = new CustomerPostgres();
	
public Item add(Item i)  {
	Item ck = this.getItemByDecription(i.getDecription());
	if(ck != null ){ 
		int total = ck.getStocked() + i.getStocked();
		i.setStocked(total);
		ck.setStocked(total);
		id.update(ck);
		return ck; 
	} else {
		return id.add(i);	
	}		
}
public Item getItemByDecription(String decription) {
	List<Item> item = id.getAll();
	for(Item i: item) {
		if(i.getDecription().equals(decription)) {
			return i;
		}
	}
	return null;
}
public Item deleteItem(Item i) {
	Item ck = this.getItemByDecription(i.getDecription());
	int total = ck.getStocked() - i.getStocked();
	i.setStocked(total);
	i.setDecription(i.getDecription());
	i.setPrice(ck.getPrice());
	i.setStatus(ck.getStatus());
	ck.setStocked(total);
	if(total == 0) { 
		id.delete(i);
		return null;
	} else {
		return i;
	}
}
public static void showInventory() {
	List<Item> item = id.getAll();
	int counter = 0;
	for(Item i: item) {
		if(i.getStatus().equals("Available")){
			counter += 1;
			System.out.println(counter + ": " + i.getDecription() + " " + i.getQuantity() + " "
					+ i.getPrice() + " " + i.getStocked() + " Stocked: ");
		}
	}
}
public static void toCart(int pick) {
	List<Item> item = id.getAll();
	List<Customer> customers = cd.getAll();
	Customer custLog = new Customer();
	if(pick > item.size()) {
		System.out.println();
		System.out.println("Error, Select an Number from the List or 0 to return"
				+ " to the Dashboard:");
		pick = sc.nextInt();
		sc.nextLine();
		if(pick == 0){
			CustomerMenu.cusMenu();
		} else {
			toCart(pick);
		}
	} else if(pick > 0 && pick < item.size()) {
		Item itemChoice = item.get(pick - 1);
		System.out.println("Added 1 to cart " + itemChoice.getDecription());
		int newStocked = itemChoice.getStocked() - 1;
		itemChoice.setStocked(newStocked);
		for(Customer c : customers) {
			if(c.isLogged() == true) {
				custLog = c;
			}
		}
		int cartId = custLog.getId();
		id.update(itemChoice);
		Item newItem = new Item(itemChoice.getDecription(), itemChoice.getQuantity(), itemChoice.getPrice(), 
				 1, cartId, "Pending");
		id.add(newItem);
	}
	
}	
public static void showItemCart() {
	List<Item> item = id.getAll();
	List<Customer> customers = cd.getAll();
	Customer custLogged = new Customer();
	for(Customer c : customers) {
		if(c.isLogged() == true) {
			custLogged = c;
		}
	}
	int counter = 0;
	for(Item i : item ) {
		if(i.getStatus().equals("Pending") && i.getCusId() == custLogged.getId()){//should be customer id or item customer id? Todo
			counter += 1;
			System.out.println(counter + " " + i.getDecription() + " " + i.getQuantity() + " " +
					+ i.getPrice() + i.getStocked() + "Added to cart");
		}
	}
}
public static void subCart() {
	List<Item> item = id.getAll();
	List<Customer> customers = cd.getAll();
	Customer custLogged = new Customer();
	for(Customer c : customers) {
		if(c.isLogged() == true) {
			custLogged = c;
		}
	}
	for(Item i: item) {
		if(i.getStatus().equals("Pending") && i.getCusId() == custLogged.getId()){
			i.setStatus("Submitted");
			id.update(i);
		}
	}
}

public void accepted(int ite) {
	List<Item> item = id.getAll();
	int counter = 0;
	for(Item i: item) {
		if(i.getStatus().equals("Submitted")){
			counter += 1;
			if(ite == counter) {
				i.setStatus("Owned");
				id.update(i);
				System.out.println("Accepted" + i.getDecription() + " " + i.getQuantity() + " " +
					 i.getPrice() + i.getStocked());
			}
		}
	}
}

public void rejected(int ite) {
	List<Item> item = id.getAll();
	int counter = 0;
	for(Item i: item) {
		if(i.getStatus().equals("Submitted")){
			counter += 1;
			if(ite == counter) {
				i.setStatus("Available");
				i.setCusId(0);
				id.update(i);
				System.out.println("Rejected" + i.getDecription() + " " + i.getQuantity() + " " +
						 i.getPrice() + i.getStocked());
			}
		}
	}
}
public static void buyFromInv(Scanner sc) {
	System.out.println();
	showInventory();
	System.out.println();
	System.out.println("Please Enter the Item Number to add to cart");
	System.out.println("Select 0 for menu:");
	int selected = sc.nextInt();
	sc.nextLine();
	if(selected == 0){
		CustomerMenu.cusMenu();
	} else {
		toCart(selected);
	}
	
}
public static void viewCart(Scanner sc) {
	showItemCart();
	System.out.print("To Submit Item Press 1, To Return to Menu Press 2:");
	int choice = sc.nextInt();
	if(choice == 1 ) {
		System.out.println("Item submitted for processing");
		subCart();
	} else {
		System.out.println(" Returning to Menu");
		CustomerMenu.cusMenu();
	}
}
}

