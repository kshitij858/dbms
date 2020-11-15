package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.ClassAndCourse;
import com.secure.secureboot.entities.SectionAndClass;

@Repository
public class ClassAndCourseDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ClassAndCourse save(ClassAndCourse classAndCourse) {
		String sql = "select * from classAndCourse where courseId = ? and classId = ?";
		List<ClassAndCourse> classAndCourses = jdbcTemplate.query(sql, 
				new Object[] { classAndCourse.getCourse().getCourseId() ,classAndCourse.getClassId() },
                new ClassAndCourseRowMapper() );
		Integer k = classAndCourses.size();
		System.out.println(k);
		if(k.equals(0)) {
			String s = "insert into classAndCourse(courseId, classId)" + "values(?,?)";
			jdbcTemplate.update(s, classAndCourse.getCourse().getCourseId() ,classAndCourse.getClassId());
		}
		return classAndCourse;
	}
	
	public List<ClassAndCourse> getByClassId(Integer classId) {
		try {
			String sql = "select * from classAndCourse natural join course where classId = ?";
			List<ClassAndCourse> classAndCourses = jdbcTemplate.query(sql, 
					new Object[] { classId },
	                new ClassAndCourseRowMapper() );
			return classAndCourses;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	
	public ClassAndCourse getUnique(Integer classId, Integer courseId) {
		try {
			String sql = "select * from classAndCourse natural join course where classId = ? and courseId = ?";
			ClassAndCourse classAndCourse = jdbcTemplate.queryForObject(sql, 
					new Object[] { classId, courseId },
	                new ClassAndCourseRowMapper() );
			return classAndCourse;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	public ClassAndCourseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
