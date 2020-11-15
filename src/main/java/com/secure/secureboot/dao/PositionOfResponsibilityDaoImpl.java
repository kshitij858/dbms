package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.PositionOfResponsibility;
import com.secure.secureboot.entities.User;

@Repository
public class PositionOfResponsibilityDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<PositionOfResponsibility> getAllPositionOfResponsibility() {
		String sql = "select * from positionOfResponsibility natural join user";
		List<PositionOfResponsibility> positionOfResponsibilitys = jdbcTemplate.query(sql,new PositionOfResponsibilityRowMapper());
		return positionOfResponsibilitys;
	}
	
	public List<PositionOfResponsibility> getByUserId(Integer userId) {
		String sql = "select * from positionOfResponsibility natural join user where userId = ?";
		List<PositionOfResponsibility> positionOfResponsibilitys = jdbcTemplate.query(sql, new Object[] {
                userId },new PositionOfResponsibilityRowMapper());
		return positionOfResponsibilitys;
	}
	
	public PositionOfResponsibility save(PositionOfResponsibility positionOfResponsibility) {
		Integer k = 0;
		if(k.equals(0)) {
			String s = "insert into positionOfResponsibility(till,dateOfPositionOfResponsibility,"
					+ "title,  userId)" + "values(?,?,?,?)";
			jdbcTemplate.update(s, positionOfResponsibility.getTill(), 
					positionOfResponsibility.getDateOfPositionOfResponsibility(), 
					positionOfResponsibility.getTitle(), positionOfResponsibility.getUser().getUserId());
		}
		return positionOfResponsibility;
	}

	public PositionOfResponsibility update(PositionOfResponsibility positionOfResponsibility) {
		User user = positionOfResponsibility.getUser();
		String sql = "update positionOfResponsibility set title=?, till=?, "
				+ "dateOfPositionOfResponsibility = ?, userId = ? where positionOfResponsibilityId = ?";
		jdbcTemplate.update(sql,positionOfResponsibility.getTitle(), positionOfResponsibility.getTill(),
				positionOfResponsibility.getDateOfPositionOfResponsibility(), 
				positionOfResponsibility.getUser().getUserId(),
				positionOfResponsibility.getPositionOfResponsibilityId());
		return	positionOfResponsibility;
	}
	
	public PositionOfResponsibility get(Integer userId) {
		try {
            String sql = "SELECT * FROM positionOfResponsibility NATURAL JOIN user WHERE userId = ?";
            return (PositionOfResponsibility) jdbcTemplate.queryForObject(sql, new Object[] {
                    userId },
                    new PositionOfResponsibilityRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	
	public PositionOfResponsibilityDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
