package Utilites;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.DriverManager;

import com.revature.daos.CustomerDao;
import com.revature.daos.EmployeeDao;
import com.revature.daos.ItemDao;
import com.revature.repositories.CustomerPostgres;
import com.revature.repositories.EmployeePostgres;
import com.revature.repositories.ItemPostgres;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Item;

import java.util.Properties;

public class JdbcDriver {

	public static void main(String[] args) {
		EmployeeDao ed = new EmployeePostgres();
		List<Employee> emps = ed.getAll();
		for (Employee e : emps) {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getUsername());
			System.out.println(e.getPassword());

		}
		CustomerDao cd = new CustomerPostgres();
		List<Customer> cus = cd.getAll();
		for (Customer c : cus) {
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getUsername());
			System.out.println(c.getPassword());

		}
		ItemDao id = new ItemPostgres();
		List<Item> item = id.getAll();
		for (Item i : item) {
			System.out.println(i.getDescription());
			System.out.println(i.getQuantity());
			System.out.println(i.getPrice());
			System.out.println(i.getCusId());
			System.out.println(i.getStatus());
		}
	}
}
