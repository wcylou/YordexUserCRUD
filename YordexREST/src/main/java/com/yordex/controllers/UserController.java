package com.yordex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yordex.entities.User;
import com.yordex.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userServ;

	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(path = "users", method = RequestMethod.GET)
	public List<User> indexUsers() {
		return userServ.indexUser();
	}

	@RequestMapping(path = "users/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable int id) {
		return userServ.showById(id);
	}

	@RequestMapping(path = "users/name/{firstName}", method = RequestMethod.GET)
	public User getUserByFirstName(@PathVariable String firstName) {
		return userServ.showByFirstName(firstName);
	}

	@RequestMapping(path = "users", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userServ.create(user);
	}

	@RequestMapping(path = "users/{id}", method = RequestMethod.PATCH)
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		return userServ.update(id, user);
	}

	@RequestMapping(path = "users/{id}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable int id) {
		return userServ.destroy(id);
	}

}
