package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Participation;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.entities.UserEmail;

@Repository
public class UserEmailDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<UserEmail> getAllEmails() {
		String sql = "select * from userEmail natural join user";
		List<UserEmail> userEmail = jdbcTemplate.query(sql,new UserEmailRowMapper());
		return userEmail;
	}
	
	public List<UserEmail> getByUserId(Integer userId) {
		String sql = "select * from userEmail natural join user where userId = ?";
		List<UserEmail> userEmails = jdbcTemplate.query(sql, new Object[] {
                userId },new UserEmailRowMapper() );
		return userEmails;
	}
	
	public UserEmail save(UserEmail userEmail) {
		String sql = "select * from userEmail where email = ?";
		List<UserEmail> userEmails = jdbcTemplate.query(sql, 
				new Object[] { userEmail.getEmail() },
                new UserEmailRowMapper());
		Integer k = userEmails.size();
		if(k.equals(0)) {
			String s = "insert into userEmail(email, userId)" + "values(?,?)";
			jdbcTemplate.update(s, userEmail.getEmail(), userEmail.getUser().getUserId());
		}
		return userEmail;
	}
	
	public UserEmail update(UserEmail userEmail) {
		User user = userEmail.getUser();
		String sql = "update userEmail set email=? where email = ?";
		jdbcTemplate.update(sql,userEmail.getEmail(), userEmail.getEmail());
		return	userEmail;
	}
	
	public void delete(String email) {
		String sql = "delete  from userEmail where email = ?";
		jdbcTemplate.update(sql, email);
		
	}
	public UserEmailDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
