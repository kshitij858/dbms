package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Feedback;
import com.secure.secureboot.entities.User;

public class FeedbackRowMapper implements RowMapper<Feedback> {

	public FeedbackRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
		Feedback feedback = (new BeanPropertyRowMapper<>(Feedback.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        feedback.setUser(user);
        return feedback;

	}

}
