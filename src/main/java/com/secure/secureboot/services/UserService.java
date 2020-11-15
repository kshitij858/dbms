package com.secure.secureboot.services;

import com.secure.secureboot.entities.User;

public interface UserService {
	void save(User user);
	User findByUsername(String username);
	void update(User user, String username);

}
