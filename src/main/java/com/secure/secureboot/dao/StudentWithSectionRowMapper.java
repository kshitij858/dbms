package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.SectionAndClass;
import com.secure.secureboot.entities.StudentWithSection;

public class StudentWithSectionRowMapper implements RowMapper<StudentWithSection> {

	public StudentWithSectionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public StudentWithSection mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentWithSection studentWithSection = (new BeanPropertyRowMapper<>(StudentWithSection.class)).mapRow(rs, rowNum);
		Section section = (new BeanPropertyRowMapper<>(Section.class)).mapRow(rs, rowNum);
		Classes classes= (new BeanPropertyRowMapper<>(Classes.class)).mapRow(rs, rowNum);
		studentWithSection.setClasses(classes);
		studentWithSection.setSection(section);
        return studentWithSection;
	}

}
