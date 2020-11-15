package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Staff;
import com.secure.secureboot.entities.User;

public class StaffRowMapper implements RowMapper<Staff> {

	public StaffRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		Staff staff = (new BeanPropertyRowMapper<>(Staff.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        staff.setUser(user);
        return staff;
	}

}
