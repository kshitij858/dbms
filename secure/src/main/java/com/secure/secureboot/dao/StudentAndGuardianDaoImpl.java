package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Guardian;
import com.secure.secureboot.entities.SectionAndClass;
import com.secure.secureboot.entities.StudentAndGuardian;
import com.secure.secureboot.util.PreparedStatementUtil;

@Repository
public class StudentAndGuardianDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PreparedStatementUtil preparedStatementUtil;
	
	public StudentAndGuardian save(StudentAndGuardian studentAndGuardian) {
		String sql = "select * from studentAndGuardian where studentId = ? and guardianId = ?";
		List<StudentAndGuardian> studentAndGuardians = jdbcTemplate.query(sql, 
				new Object[] { studentAndGuardian.getStudentId(), studentAndGuardian.getGuardian().getGuardianId() },
                new StudentAndGuardianRowMapper());
		Integer k = studentAndGuardians.size();
		System.out.println(k);
		if(k.equals(0)) {
			String s = "insert into studentAndGuardian(studentId, guardianId, relationship)" + 
		"values(?,?,?)";
			jdbcTemplate.update(s, studentAndGuardian.getStudentId(), 
					studentAndGuardian.getGuardian().getGuardianId(),
					studentAndGuardian.getRelationship());
		}
		return studentAndGuardian;
	}
	
	public List<Guardian> getByStudentId(Integer studentId) {
		try {
			String sql = "select * from studentAndGuardian natural join guardian natural join user "
					+ "where studentId = ?";
			List<Guardian> studentAndGuardians = jdbcTemplate.query(sql, 
					new Object[] { studentId },
	                new GuardianRowMapper());
			return studentAndGuardians;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	
	public StudentAndGuardian getUnique(Integer studentId, Integer guardianId) {
		try {
			String sql = "select * from studentAndGuardian natural join guardian where studentId = ? "
					+ "and guardianId = ?";
			StudentAndGuardian studentAndGuardian = jdbcTemplate.queryForObject(sql, 
					new Object[] { studentId, guardianId },
	                new StudentAndGuardianRowMapper());
			return studentAndGuardian;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	public void update(StudentAndGuardian studentAndGuardian) {
		String sql = "update studentAndGuardian set relationship = ? where studentId = ? and guardianId = ?";
		jdbcTemplate.update(sql, studentAndGuardian.getRelationship(),studentAndGuardian.getStudentId(), 
				studentAndGuardian.getGuardian().getGuardianId());
	}
	public StudentAndGuardianDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
