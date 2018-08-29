package com.yordex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yordex.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>  {
	
	User findByFirstName(String firstName);
	User findById(int id);

}
