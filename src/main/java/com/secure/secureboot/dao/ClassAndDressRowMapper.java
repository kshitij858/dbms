package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.ClassAndCourse;
import com.secure.secureboot.entities.ClassAndDress;
import com.secure.secureboot.entities.Course;
import com.secure.secureboot.entities.Dress;

public class ClassAndDressRowMapper implements RowMapper<ClassAndDress> {

	public ClassAndDressRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ClassAndDress mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClassAndDress classAndDress = (new BeanPropertyRowMapper<>(ClassAndDress.class)).mapRow(rs, rowNum);
		Dress dress = (new BeanPropertyRowMapper<>(Dress.class)).mapRow(rs, rowNum);
		classAndDress.setDress(dress);
        return classAndDress;
	}

}
