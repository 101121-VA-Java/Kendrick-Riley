package Utilites;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class JdbcDriver {

	public static void main(String[] args) {
		UserDao ud = new UserPostgres();
		List<User> user = ud.getAll();
		for (User u : user) {
			System.out.println(u.getId());
			System.out.println(u.getUserName());
			System.out.println(u.getPassword());
			System.out.println(u.getFirstName());
			System.out.println(u.getLastName());
			System.out.println(u.getRole());

		}

	}
}