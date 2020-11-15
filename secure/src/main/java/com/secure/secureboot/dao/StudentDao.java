package com.secure.secureboot.dao;

import java.util.List;

import com.secure.secureboot.entities.Student;

public interface StudentDao {
	Student save(Student student);
	List<Student> getAllUsers();
	Student update (Student student);
	Student get(Integer userId);
	Student getByStudentId(Integer studentId);
}
