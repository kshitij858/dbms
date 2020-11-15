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

import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.SectionAndClass;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.util.PreparedStatementUtil;

@Repository
public class SectionAndClassImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	private PreparedStatementUtil preparedStatementUtil;
	
	public SectionAndClass save(SectionAndClass sectionAndClass) {
		String sql = "select * from sectionAndClass where sectionId = ? and classId = ?";
		List<SectionAndClass> sectionAndClasses = jdbcTemplate.query(sql, 
				new Object[] { sectionAndClass.getSection().getSectionId(), sectionAndClass.getClassId() },
                new SectionAndClassRowMapper());
		Integer k = sectionAndClasses.size();
		System.out.println(k);
		if(k.equals(0)) {
			String s = "insert into sectionAndClass(sectionId, classId)" + "values(?,?)";
			jdbcTemplate.update(s, sectionAndClass.getSection().getSectionId(),sectionAndClass.getClassId());
		}
		return sectionAndClass;
	}
	
	public List<SectionAndClass> getByClassId(Integer classId) {
		try {
			String sql = "select * from sectionAndClass natural join section where classId = ?";
			List<SectionAndClass> sectionAndClasses = jdbcTemplate.query(sql, 
					new Object[] { classId },
	                new SectionAndClassRowMapper());
			return sectionAndClasses;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	
	public SectionAndClass getUnique(Integer classId, Integer sectionId) {
		try {
			String sql = "select * from sectionAndClass natural join section where classId = ? and sectionId = ?";
			SectionAndClass sectionAndClasse = jdbcTemplate.queryForObject(sql, 
					new Object[] { classId, sectionId },
	                new SectionAndClassRowMapper());
			return sectionAndClasse;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	public void update(SectionAndClass sectionAndClass) {
		String sql = "update sectionAndClass set teacherId = ? where classId = ? and sectionId = ?";
		jdbcTemplate.update(sql, sectionAndClass.getTeacherId(), sectionAndClass.getClassId(), 
				sectionAndClass.getSection().getSectionId());
	}
	public SectionAndClassImpl() {
		// TODO Auto-generated constructor stub
	}

}
