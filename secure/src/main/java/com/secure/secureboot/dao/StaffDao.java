package com.secure.secureboot.dao;

import java.util.List;

import com.secure.secureboot.entities.Staff;
import com.secure.secureboot.entities.Teacher;

public interface StaffDao {
	
	Staff save(Staff staff);
	//void update(User user);
	
	//User getUser(String username);
	
	List<Staff> getAllUsers();
	Staff update (Staff staff);
	Staff get(Integer userId);
}
