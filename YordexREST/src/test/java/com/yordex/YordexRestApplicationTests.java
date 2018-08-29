package com.yordex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yordex.controllers.UserController;
import com.yordex.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YordexRestApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	@DisplayName("Test Search By First Name")
	public void testSearchForUserByFirstName() {
		assertEquals("Bob", userController.getUserByFirstName("Bob").getFirstName());
	}

	@Test
	@DisplayName("Test Search By Id")
	public void testSearchForUserByID() {
		assertEquals("Bob", userController.getUserById(1).getFirstName());
	}

	@Test
	@DisplayName("Test Create User")
	public void testCreateUser() {
		User u = new User("email@gmail.com", "password", "Mary", "Smith");
		assertEquals("Mary", userController.createUser(u).getFirstName());
	}

	@Test
	@DisplayName("Test Update User")
	public void testUpdateUser() {
		User u = userController.getUserById(1);
		u.setPassword("passwordnew");
		assertEquals("Bob", userController.updateUser(1, u).getFirstName());
	}

}
