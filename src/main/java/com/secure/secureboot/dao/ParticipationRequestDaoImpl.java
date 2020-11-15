package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.ParticipationRequest;

@Repository
public class ParticipationRequestDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ParticipationRequest> getAllParticipationRequests() {
		String sql = "select * from participationRequest natural join user";
		List<ParticipationRequest> participationRequest = jdbcTemplate.query(sql,new ParticipationRequestRowMapper());
		return participationRequest;
	}
	
	public List<ParticipationRequest> getByUserId(Integer userId) {
		String sql = "select * from participationRequest natural join user where userId = ?";
		List<ParticipationRequest> participationRequests = jdbcTemplate.query(sql, new Object[] {
                userId },new ParticipationRequestRowMapper() );
		return participationRequests;
	}

	public ParticipationRequest save(ParticipationRequest participationRequest) {
		long millis=System.currentTimeMillis();  
		java.sql.Date dates=new java.sql.Date(millis);  
		String s = "insert into ParticipationRequest(titleOfParticipationRequest,dateOfParticipationRequest,"
				+ "  userId)" + "values(?,?,?)";
		jdbcTemplate.update(s,participationRequest.getTitleOfParticipationRequest() , dates,
				participationRequest.getUser().getUserId());
		return participationRequest;
	}
	public void delete(Integer participationRequestId) {
		String sql = "delete  from participationRequest where participationRequestId = ?";
		jdbcTemplate.update(sql, participationRequestId);
		
	}
	public ParticipationRequestDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
