package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.UserDao;
import com.revature.exception.LoginException;
import com.revature.models.User;
import com.revature.services.UserService;

@ExtendWith(MockitoExtension.class)

public class UserTests {

	@Mock
	private UserDao ud;

	@InjectMocks
	private UserService us;

	@Test
	public void loginSystemTest() {
		Mockito.when(ud.loginUser(null)).thenReturn(true);
		boolean expected = true;
		boolean actual = us.loginUser(null);
		assertEquals(expected, actual);

	}
}

//	public User login(String username, String password) throws LoginException {
//		User user = this.get(username);
//		if (user == null || !user.getPassword().equals(password)) {
//			throw new LoginException();
//			
//		Mockito.when(ud.loginUser(user)
//			
//		User expected = new User(2,"test","test",new User(1));
//		User actual = ud.loginUser(new User("test","test"));
//		assertEquals(expected, actual);
//		}
//		return user;
//	}
//}