package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.Teacher;
import com.secure.secureboot.entities.User;

public class TeacherRowMapper implements RowMapper<Teacher> {

	public TeacherRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teacher teacher = (new BeanPropertyRowMapper<>(Teacher.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        teacher.setUser(user);
        return teacher;
	}

}
