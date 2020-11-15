package com.secure.secureboot.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Guardian;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.util.PreparedStatementUtil;

@Repository
public class GuardianDaoImpl {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private PreparedStatementUtil preparedStatementUtil;
	
	public List<Guardian> getAllUsers() {
		String sql = "select * from guardian natural join user";
		List<Guardian> guardians = jdbcTemplate.query(sql,new GuardianRowMapper());
		return guardians;
	}
	
	public Guardian save(Guardian guardian) {
		String sql = "select * from guardian natural join user where userId = ?";
		List<Guardian> guardians = jdbcTemplate.query(sql, 
				new Object[] { guardian.getUser().getUserId() },
                new GuardianRowMapper());
		Integer k = guardians.size();
		if(k.equals(0)) {
			String s = "insert into guardian(userId, isActive)" + "values(?,?)";
			jdbcTemplate.update(s, guardian.getUser().getUserId(), guardian.getIsActive());
		}
		return guardian;
	}
	
	public Guardian getByuserId(Integer userId) {
		try {
            String sql = "SELECT * FROM guardian NATURAL JOIN user WHERE userId = ?";
            return (Guardian) jdbcTemplate.queryForObject(sql, new Object[] {
                    userId },
                    new GuardianRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	
	public Guardian update(Guardian guardian) {
		User user = guardian.getUser();
		String sql = "update student set isActive=? where userId = ?";
		jdbcTemplate.update(sql,guardian.getIsActive(), user.getUserId() );
		return	guardian;
	}
	public GuardianDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
