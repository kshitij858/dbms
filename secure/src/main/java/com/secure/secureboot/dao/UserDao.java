package com.secure.secureboot.dao;

import java.util.List;

import com.secure.secureboot.entities.User;


public interface UserDao {
	User save(User user);
	
	void delete(String username);
	
	void update(User user);
	
	User getUser(String username);
	
	List<User> getAllUsers();
	
	User findByUsername(String username);
	User findByUserId(Integer userId);
	
}
