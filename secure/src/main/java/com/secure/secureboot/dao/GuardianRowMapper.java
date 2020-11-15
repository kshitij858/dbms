package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Guardian;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;

public class GuardianRowMapper implements RowMapper<Guardian> {

	public GuardianRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Guardian mapRow(ResultSet rs, int rowNum) throws SQLException {
		Guardian guardian = (new BeanPropertyRowMapper<>(Guardian.class)).mapRow(rs, rowNum);
	        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
	        guardian .setUser(user);
	        return guardian ;
	}

}
