package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Achievement;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;

public class AcievementRowMapper implements RowMapper<Achievement> {

	public AcievementRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Achievement mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = (new BeanPropertyRowMapper<>(Student.class)).mapRow(rs, rowNum);
		Achievement achievement = (new BeanPropertyRowMapper<>(Achievement.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        student.setUser(user);
        achievement.setStudent(student);
        return achievement;
	}

}
