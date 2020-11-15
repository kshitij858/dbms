package com.secure.secureboot.dao;

import java.util.List;

import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.Teacher;

public interface TeacherDao {
	
	Teacher save(Teacher teacher);
	//void update(User user);
	
	//User getUser(String username);
	
	List<Teacher> getAllUsers();
	Teacher update (Teacher teacher);
	Teacher get(Integer userId);
	Teacher getByTeacherId(Integer teacherId);

}
