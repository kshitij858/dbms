package com.secure.secureboot.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Feedback;
import com.secure.secureboot.entities.PositionOfResponsibility;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.util.DateTimeUtil;

@Repository
public class FeedbackDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DateTimeUtil dateTimeUtil;

	public List<Feedback> getAllFeedbacks() {
		String sql = "select * from feedback natural join user";
		List<Feedback> feedback = jdbcTemplate.query(sql,new FeedbackRowMapper());
		return feedback;
	}
	
	public List<Feedback> getByUserId(Integer userId) {
		String sql = "select * from feedback natural join user where userId = ?";
		List<Feedback> feedbacks = jdbcTemplate.query(sql, new Object[] {
                userId },new FeedbackRowMapper() );
		return feedbacks;
	}

	public Feedback save(Feedback feedback) {
//		SimpleDateFormat localDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		localDateTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//		String dateTime = localDateTimeFormat.format(new Date());
//	
//		long millis=System.currentTimeMillis();  
//		java.sql.Date dates=new java.sql.Date(millis);  
		String s = "insert into feedback(subject,dateOfFeedback,"
				+ "description,  userId)" + "values(?,?,?,?)";
		jdbcTemplate.update(s, feedback.getSubject(), dateTimeUtil.getCurrentDateTime("yyyy-MM-dd") , feedback.getDescription(),
				feedback.getUser().getUserId());
		return feedback;
	}
	
	public FeedbackDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
