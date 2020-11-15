package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.Teacher;
import com.secure.secureboot.entities.User;


@Repository
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Teacher save(Teacher teacher) {
		String sql = "select * from teacher natural join user where userId = ?";
		List<Teacher> teachers = jdbcTemplate.query(sql,new Object[] 
				{ teacher.getUser().getUserId() },new TeacherRowMapper());
		Integer k = teachers.size();
		if(k.equals(0)) {
			String s = "insert into teacher(salary, designation, numberOfLeavesAllowed, userId)" + 
					"values(?,?,?,?)";
			jdbcTemplate.update(s, 10000,"Physics teacher",20, teacher.getUser().getUserId());
		}
		return teacher;
	}
	
	public TeacherDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Teacher> getAllUsers() {
		String sql = "select * from teacher natural join user";
		List<Teacher> teachers = jdbcTemplate.query(sql,new TeacherRowMapper());
		return teachers;
	}

	@Override
	public Teacher update(Teacher teacher) {
		User user = teacher.getUser();
		String sql = "update teacher set leavesTaken=?, numberOfLeavesAllowed=?, salary=?, designation=? "
				+ "where userId = ?";
		jdbcTemplate.update(sql,teacher.getLeavesTaken(), teacher.getNumberOfLeavesAllowed(),
				 teacher.getSalary(), teacher.getDesignation()  , user.getUserId());
		return	teacher;
	}

	@Override
	public Teacher get(Integer userId) {
		try {
            String sql = "SELECT * FROM teacher NATURAL JOIN user WHERE userId = ?";
            return (Teacher) jdbcTemplate.queryForObject(sql, new Object[] {
                    userId },
                    new TeacherRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	@Override
	public Teacher getByTeacherId(Integer teacherId) {
		try {
            String sql = "SELECT * FROM teacher NATURAL JOIN user WHERE teacherId = ?";
            return (Teacher) jdbcTemplate.queryForObject(sql, new Object[] {
                    teacherId },
                    new TeacherRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

}
