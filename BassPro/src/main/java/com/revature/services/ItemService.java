package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.controllers.CustomerMenu;
import com.revature.controllers.EmployeeMenu;
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

	public Item add(Item i) {
		Item ck = this.getItemByDescription(i.getDescription());
		if (ck != null) {
			int total = ck.getQuantity() + i.getQuantity();
			i.setQuantity(total);
			ck.setQuantity(total);
			id.update(ck);
			return ck;
		} else {
			return id.add(i);
		}
	}

	public Item getItemByDescription(String description) {
		List<Item> item = id.getAll();
		for (Item i : item) {
			if (i.getDescription().equals(description)) {
				return i;
			}
		}
		return null;
	}

	public Item deleteItem(Item i) {
		Item ck = this.getItemByDescription(i.getDescription());
		int total = ck.getQuantity() - i.getQuantity();
		i.setQuantity(total);
		i.setDescription(i.getDescription());
		i.setPrice(ck.getPrice());
		i.setStatus(ck.getStatus());
		id.update(ck);
		if (total == 0) {
			id.delete(i);
			return null;
		} else {
			return i;
		}
	}

	public static void showInventory() {// Need change .equals because Item.getStatus()" is null
		List<Item> item = id.getAll();
		int counter = 0;
		for (Item i : item) {
//		if(i.getStatus().equals("Available")){
			counter += 1;
			System.out.println(counter + ": " + i.getDescription() + " " + i.getQuantity() + " " + i.getPrice() + " "
					+ " Stocked: ");
//		}
		}
	}

	public static void toCart(int pick) {

		List<Item> item = id.getAll();
		List<Customer> customers = cd.getAll();
		Customer custLog = new Customer();
		if (pick > item.size()) {
			System.out.println();
			System.out.println("Error, Select an Number from the List or 0 to return" + " to the Dashboard:");
			pick = sc.nextInt();
			sc.nextLine();
			if (pick == 0) {
				CustomerMenu.cusMenu();
			} else {
				toCart(pick);
			}
		}
		Item itemChoice = item.get(pick - 1);
		System.out.println(" Added 1 to cart " + itemChoice.getDescription());
		int newStocked = itemChoice.getQuantity() - 1;
		itemChoice.setQuantity(newStocked);
		for (Customer c : customers) {
			if (c.isLogged() == true) {
				custLog = c;
			}
		}
		int cartId = custLog.getId();
		id.update(itemChoice);
		Item newItem = new Item(itemChoice.getDescription(), itemChoice.getQuantity(), itemChoice.getPrice(), cartId,
				"Pending");
		id.add(newItem);

	}

	public static void showItemCart() {
		List<Item> item = id.getAll();
		List<Customer> customers = cd.getAll();
		Customer custLogged = new Customer();
		for (Customer c : customers) {
			if (c.isLogged() == true) {
				custLogged = c;
			}
		}

		int counter = 0;
		for (Item i : item) {
			if (i.getStatus().equals("Pending") && i.getCusId() == custLogged.getId()) {// should be customer id or item
																						// customer id? Todo
				counter += 1;
				System.out.println(counter + " " + i.getDescription() + " " + i.getQuantity() + " " + +i.getPrice()
						+ " Added to cart ");
			}
		}
	}

	public static void submitedCart() {
		List<Item> item = id.getAll();
		List<Customer> customers = cd.getAll();
		Customer custLogged = new Customer();
		for (Customer c : customers) {
			if (c.isLogged() == true) {
				custLogged = c;
			}
		}
		for (Item i : item) {
			if (i.getStatus().equals("Pending")) {
				i.setStatus("Submitted");
				id.update(i);
			}
		}
	}

	public static void accepted(int ite) {
		List<Item> item = id.getAll();
		int counter = 0;
		for (Item i : item) {
			if (i.getStatus().equals("Submitted")) {
				counter += 1;
				if (ite == counter) {
					i.setStatus("Owned");
					id.update(i);
					System.out.println("Accepted" + i.getDescription() + " " + i.getQuantity() + " " + i.getPrice());
				}
			}
		}
	}

//Need help on this method
	public void rejected(int ite) {
		List<Item> item = id.getAll();
		int counter = 0;
		for (Item i : item) {
			if (i.getStatus().equals("Submitted")) {
				counter += 1;
				if (ite == counter) {
					Item removedItem = new Item(i.getDescription(), i.getQuantity(), i.getPrice(), i.getCusId());
					i.setStatus("Available");
					i.setCusId(0);
//			    addItem(i);
					id.delete(removedItem);
					System.out.println("Rejected" + i.getDescription() + " " + i.getQuantity() + " " + i.getPrice());
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
		if (selected == 0) {
			CustomerMenu.cusMenu();
		} else {
			toCart(selected);
			CustomerMenu.cusMenu();
		}

	}

	public static void viewCart(Scanner sc) {
		showItemCart();
		System.out.print("To Submit Item Press 1, To Return to Menu Press 2:");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Item submitted for processing");
			submitedCart();
			CustomerMenu.cusMenu();
		} else {
			System.out.println(" Returning to Menu");
			CustomerMenu.cusMenu();
		}

	}

	public void viewOffers(Scanner sc) {
//		showItemCart();
		showOffers();
		acceptAll();
		System.out.println();
		String input = sc.nextLine();
		System.out.println();
		if (input.equals("1")) {
			System.out.println("Enter the Number of the Item You Would Accept");
			int ite = sc.nextInt();
			sc.nextLine();
			accepted(ite);
			viewOffers(sc);
		} else if (input.equals("2")) {
			System.out.println("Enter the Number of the Item You Would Reject");
			int ite = sc.nextInt();
			sc.nextLine();
			rejected(ite);
			viewOffers(sc);
		}
		EmployeeMenu.EmpMenu();

	}

	public static void showOffers() {
		List<Item> item = id.getAll();
		int counter = 0;
		for (Item i : item) {
			if (i.getStatus().equals("Pending")) {
				counter += 1;
				System.out.println(counter + ": " + i.getDescription() + " " + i.getQuantity() + " Offer = $"
						+ i.getPrice() + " In Cart: " + " CusId: " + i.getCusId());
			}
		}
	}

	public void showPayments() {
		List<Item> item = id.getAll();
		double total = 0;
		int counter = 0;
		for (Item i : item) {
			if (i.getStatus().equals("Pending")) {
				counter += 1;
				System.out.println(counter + i.getDescription() + " " + i.getQuantity() + " " + i.getPrice() + " $"
						+ i.getPrice());
				total += i.getPrice();
			}
		}
		System.out.println("Total Sales = " + total);
//		sc.close();
		System.out.println(" Employee Main Screen ");
		EmployeeMenu.EmpMenu();
	}

	public void viewPayments(Scanner sc) {
		showPayments();
		System.out.println("Returning Employee Menu ");
		EmployeeMenu.EmpMenu();
	}

	public void showHistory() {
		List<Item> item = id.getAll();
		List<Customer> customers = cd.getAll();
		Customer custLogged = new Customer();
//		for (Item i : item) {
//			if (i.getStatus().equals("Pending")) {
//				i.setStatus("Owned");
//				id.update(i);
//			}
//		}
		for (Customer cust : customers) {
			if (cust.isLogged() == true) {
				custLogged = cust;
			}
		}
		int counter = 0;
		for (Item i : item) {
			if (i.getStatus().equals("Pending") && i.getCusId() == custLogged.getId()) {
				counter += 1;
				double total = 0, pay;

				System.out.println(i.getDescription() + " " + i.getPrice());
				System.out.println("Enter bid ");
				pay = sc.nextDouble();
				System.out.println(counter + ": " + "Bid for " + pay + " " + i.getDescription() + " " + i.getQuantity()
						+ " $" + i.getPrice() + " Submitted: ");
				i.setStatus("Submitted");
				id.update(i);
				break;
			}
			System.out.println();
			System.out.println("Press 0 To Return to Menu:");
			String choice0 = sc.nextLine();
			CustomerMenu.cusMenu();

		}
	}

	public void acceptAll() {
		List<Item> item = id.getAll();
		for (Item i : item) {
			if (i.getStatus().equals("Pending")) {
				i.setStatus("Owned");
				id.update(i);
				System.out.println("Offers Accepted " + i.getDescription());
			}
		}
	}
}
