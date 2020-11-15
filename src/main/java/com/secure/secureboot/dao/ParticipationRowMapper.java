package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Achievement;
import com.secure.secureboot.entities.Participation;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;

public class ParticipationRowMapper implements RowMapper<Participation> {

	public ParticipationRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Participation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = (new BeanPropertyRowMapper<>(Student.class)).mapRow(rs, rowNum);
		Participation participation = (new BeanPropertyRowMapper<>(Participation.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        student.setUser(user);
        participation.setStudent(student);
        return participation;
	}

}
