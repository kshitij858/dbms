package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.SectionAndClass;

public class SectionAndClassRowMapper implements RowMapper<SectionAndClass> {

	public SectionAndClassRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SectionAndClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		SectionAndClass sectionAndClass = (new BeanPropertyRowMapper<>(SectionAndClass.class)).mapRow(rs, rowNum);
        Section section = (new BeanPropertyRowMapper<>(Section.class)).mapRow(rs, rowNum);
        sectionAndClass.setSection(section);
        return sectionAndClass;
	}

}
