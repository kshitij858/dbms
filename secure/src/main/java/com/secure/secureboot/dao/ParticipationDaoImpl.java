package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Achievement;
import com.secure.secureboot.entities.Participation;

@Repository
public class ParticipationDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Participation> getAllParticipations() {
		String sql = "select * from participation natural join student natural join user";
		List<Participation> participation = jdbcTemplate.query(sql,new ParticipationRowMapper());
		return participation ;
	}
	
	public List<Participation> getByUserId(Integer userId) {
		String sql = "select * from participation natural join student natural join user where userId = ?";
		List<Participation> participations = jdbcTemplate.query(sql, new Object[] {
                userId },new ParticipationRowMapper() );
		return participations;
	}

	public Participation save(Participation participation) {
		long millis=System.currentTimeMillis();  
		java.sql.Date dates=new java.sql.Date(millis);  
		String s = "insert into participation(typeOfParticipation, dateOfParticipation,"
				+ "studentId)" + "values(?,?,?)";
		jdbcTemplate.update(s, participation.getTypeOfParticipation(), participation.getDateOfParticipation(), participation.getStudent().getStudentId());
		return participation;
	}
	public ParticipationDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
