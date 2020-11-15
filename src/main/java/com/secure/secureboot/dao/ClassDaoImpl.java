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
import com.secure.secureboot.entities.User;
import com.secure.secureboot.util.PreparedStatementUtil;


@Repository
public class ClassDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	private PreparedStatementUtil preparedStatementUtil;
	
	public Classes save(Classes classes) {
		String sql = "insert into class(className, classYear, noOfClassesHeld, fees)"
				+ "values(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, new String[] { "classId" });
                preparedStatementUtil.setParameters
                (preparedStatement, classes.getClassName(), classes.getClassYear(),0, classes.getFees());
                return preparedStatement;
            }
        }, keyHolder);
        int classId = keyHolder.getKey().intValue();
        classes.setClassId(classId);
        return classes;
		
	}

	
	public List<Classes> getAll() {
		 String sql = "SELECT * FROM class";
	        List<Classes> classes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Classes.class));
	        return classes;
	}
	
	public Classes get(Integer classId) {
		String sql = "SELECT * FROM class where classId = ?";
		Classes classes = jdbcTemplate.queryForObject(sql,
				new Object[] { classId }, new BeanPropertyRowMapper<>(Classes.class));
		return classes;
	}
	public ClassDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
