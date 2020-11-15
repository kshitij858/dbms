package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.PositionOfResponsibility;
import com.secure.secureboot.entities.User;

public class PositionOfResponsibilityRowMapper implements RowMapper<PositionOfResponsibility> {

	public PositionOfResponsibilityRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PositionOfResponsibility mapRow(ResultSet rs, int rowNum) throws SQLException {
		PositionOfResponsibility positionOfResponsibility = (new BeanPropertyRowMapper<>(PositionOfResponsibility.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        positionOfResponsibility.setUser(user);
        return positionOfResponsibility;
	}

}
