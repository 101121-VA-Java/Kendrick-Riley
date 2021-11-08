package Utilites;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.DriverManager;
import com.revature.daos.EmployeeDao;
import com.revature.repositories.EmployeePostgres;
import com.revature.models.Employee;
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
			 
			 
}
}