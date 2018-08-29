package com.yordex.services;

import java.util.List;

import com.yordex.entities.User;

public interface UserService {

	User showById(int id);
	User showByFirstName(String firstName);
	User create(User user);
	User update(int id, User user);
	boolean destroy(int id);
	List<User> indexUser();

}
