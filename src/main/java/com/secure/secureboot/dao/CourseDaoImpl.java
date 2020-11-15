package com.secure.secureboot.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Course;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.util.PreparedStatementUtil;

@Repository
public class CourseDaoImpl {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PreparedStatementUtil preparedStatementUtil;
	
	public Course save(Course course) {
		String sql = "insert into course(courseName, courseYear, forClass)"
				+ "values(?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, new String[] { "courseId" });
                preparedStatementUtil.setParameters
                (preparedStatement,course.getCourseName(), course.getCourseYear(), course.getForClass());
                return preparedStatement;
            }
        }, keyHolder);
        int courseId = keyHolder.getKey().intValue();
        course.setCourseId(courseId);
        return course;
		
	}

	public List<Course> getAll() {
		 String sql = "SELECT * FROM course";
	        List<Course> course = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
	        return course;
	}

	public CourseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
