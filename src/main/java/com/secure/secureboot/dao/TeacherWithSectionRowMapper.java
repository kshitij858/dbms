package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.Course;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.StudentWithSection;
import com.secure.secureboot.entities.TeacherWithSection;

public class TeacherWithSectionRowMapper implements RowMapper<TeacherWithSection> {

	public TeacherWithSectionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TeacherWithSection mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeacherWithSection teacherWithSection = (new BeanPropertyRowMapper<>(TeacherWithSection.class)).mapRow(rs, rowNum);
		Section section = (new BeanPropertyRowMapper<>(Section.class)).mapRow(rs, rowNum);
		Classes classes= (new BeanPropertyRowMapper<>(Classes.class)).mapRow(rs, rowNum);
		Course course= (new BeanPropertyRowMapper<>(Course.class)).mapRow(rs, rowNum);
		
		teacherWithSection.setClasses(classes);
		teacherWithSection.setSection(section);
		teacherWithSection.setCourse(course);
        return teacherWithSection;
	}

}
