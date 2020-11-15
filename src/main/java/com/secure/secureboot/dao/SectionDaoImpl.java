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

import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.util.PreparedStatementUtil;

@Repository
public class SectionDaoImpl {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	private PreparedStatementUtil preparedStatementUtil;
	
	public Section save(Section section) {
		String sql = "insert into section(sectionName)"
				+ "values(?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, new String[] { "sectionId" });
                preparedStatementUtil.setParameters
                (preparedStatement, section.getSectionName());
                return preparedStatement;
            }
        }, keyHolder);
        int sectionId = keyHolder.getKey().intValue();
        section.setSectionId(sectionId);
        return section;
		
	}

	public List<Section> getAll() {
		 String sql = "SELECT * FROM section";
	        List<Section> section = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Section.class));
	        return section;
	}
	public SectionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
