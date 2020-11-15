package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Guardian;
import com.secure.secureboot.entities.StudentAndGuardian;

public class StudentAndGuardianRowMapper implements RowMapper<StudentAndGuardian> {

	public StudentAndGuardianRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public StudentAndGuardian mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentAndGuardian studentAndGuardian = (new BeanPropertyRowMapper<>(StudentAndGuardian.class)).mapRow(rs, rowNum);
        Guardian guardian = (new BeanPropertyRowMapper<>(Guardian.class)).mapRow(rs, rowNum);
        studentAndGuardian.setGuardian(guardian);
        return studentAndGuardian;
	}

}
