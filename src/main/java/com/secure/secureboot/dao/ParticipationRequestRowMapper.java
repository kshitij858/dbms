package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Feedback;
import com.secure.secureboot.entities.ParticipationRequest;
import com.secure.secureboot.entities.User;

public class ParticipationRequestRowMapper implements RowMapper<ParticipationRequest> {

	public ParticipationRequestRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ParticipationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParticipationRequest participationRequest = (new BeanPropertyRowMapper<>(ParticipationRequest.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        participationRequest.setUser(user);
        return participationRequest;
	}

}
