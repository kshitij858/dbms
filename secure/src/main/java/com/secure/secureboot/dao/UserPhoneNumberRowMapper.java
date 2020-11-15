package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.entities.UserPhoneNumber;

public class UserPhoneNumberRowMapper implements RowMapper<UserPhoneNumber>{

	public UserPhoneNumberRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserPhoneNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserPhoneNumber userPhoneNumber = (new BeanPropertyRowMapper<>(UserPhoneNumber.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        userPhoneNumber.setUser(user);
        return userPhoneNumber;
	}

}
