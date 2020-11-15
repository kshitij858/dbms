package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.entities.UserEmail;
import com.secure.secureboot.entities.UserPhoneNumber;

@Repository
public class UserPhoneNumberDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<UserPhoneNumber> getAllNumbers() {
		String sql = "select * from userPhoneNumber natural join user";
		List<UserPhoneNumber> userPhoneNumbers = jdbcTemplate.query(sql,new UserPhoneNumberRowMapper());
		return userPhoneNumbers;
	}
	public List<UserPhoneNumber> getByUserId(Integer userId) {
		String sql = "select * from userPhoneNumber natural join user where userId = ?";
		List<UserPhoneNumber> userPhoneNumbers = jdbcTemplate.query(sql, new Object[] {
                userId },new UserPhoneNumberRowMapper() );
		return userPhoneNumbers;
	}
	
	public UserPhoneNumber save(UserPhoneNumber userPhoneNumber) {
		String sql = "select * from userPhoneNumber where phoneNumber = ?";
		List<UserPhoneNumber> userPhoneNumbers = jdbcTemplate.query(sql, 
				new Object[] { userPhoneNumber.getPhoneNumber() },
                new UserPhoneNumberRowMapper());
		Integer k = userPhoneNumbers.size();
		if(k.equals(0)) {
			String s = "insert into userPhoneNumber(phoneNumber, userId)" + "values(?,?)";
			jdbcTemplate.update(s, userPhoneNumber.getPhoneNumber(), userPhoneNumber.getUser().getUserId());
		}
		return userPhoneNumber;
	}
	public UserPhoneNumber update(UserPhoneNumber userPhoneNumber) {
		User user = userPhoneNumber.getUser();
		String sql = "update userPhoneNumber set phoneNumber=? where phoneNumber = ?";
		jdbcTemplate.update(sql, userPhoneNumber.getPhoneNumber(), userPhoneNumber.getPhoneNumber() );
		return	userPhoneNumber;
	}
	public void delete(String phoneNumber) {
		String sql = "delete  from userPhoneNumber where phoneNumber = ?";
		jdbcTemplate.update(sql, phoneNumber);
		
	}
	public UserPhoneNumberDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
