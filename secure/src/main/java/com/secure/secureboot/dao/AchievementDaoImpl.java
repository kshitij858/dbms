package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Achievement;
import com.secure.secureboot.entities.Feedback;

@Repository
public class AchievementDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Achievement> getAllAchievements() {
		String sql = "select * from achievement natural join student natural join user";
		List<Achievement> achievement = jdbcTemplate.query(sql,new AcievementRowMapper());
		return achievement ;
	}
	
	public List<Achievement> getByUserId(Integer userId) {
		String sql = "select * from achievement natural join student natural join user where userId = ?";
		List<Achievement> achievements = jdbcTemplate.query(sql, new Object[] {
                userId },new AcievementRowMapper() );
		return achievements;
	}

	public Achievement save(Achievement achievement) {
		long millis=System.currentTimeMillis();  
		java.sql.Date dates=new java.sql.Date(millis);  
		String s = "insert into achievement(titleOfAchievement, dateOfAchievement,"
				+ "studentId)" + "values(?,?,?)";
		jdbcTemplate.update(s, achievement.getTitleOfAchievement(), achievement.getDateOfAchievement(), achievement.getStudent().getStudentId());
		return achievement;
	}
	
	public AchievementDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
