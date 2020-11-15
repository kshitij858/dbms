package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.entities.UserEmail;

public class UserEmailRowMapper implements RowMapper<UserEmail> {

	public UserEmailRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserEmail mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserEmail userEmail = (new BeanPropertyRowMapper<>(UserEmail.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        userEmail.setUser(user);
        return userEmail;
	}

}
