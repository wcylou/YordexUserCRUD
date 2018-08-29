package com.yordex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yordex.entities.User;
import com.yordex.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public User showById(int id) {
		return userRepo.findById(id);
	}

	@Override
	public User showByFirstName(String firstName) {
		return userRepo.findByFirstName(firstName);
	}

	@Override
	public List<User> indexUser() {
		return userRepo.findAll();
	}

	@Override
	public User create(User user) {
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User update(int id, User user) {
		User u = showById(id);
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		return userRepo.saveAndFlush(u);
	}

	@Override
	public boolean destroy(int id) {
		try {
			userRepo.delete(showById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
