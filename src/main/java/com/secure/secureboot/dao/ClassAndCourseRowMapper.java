package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.ClassAndCourse;
import com.secure.secureboot.entities.Course;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.SectionAndClass;

public class ClassAndCourseRowMapper implements RowMapper<ClassAndCourse> {

	public ClassAndCourseRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ClassAndCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClassAndCourse classAndCourse = (new BeanPropertyRowMapper<>(ClassAndCourse.class)).mapRow(rs, rowNum);
        Course course = (new BeanPropertyRowMapper<>(Course.class)).mapRow(rs, rowNum);
        classAndCourse.setCourse(course);
        return classAndCourse;
	}

}
