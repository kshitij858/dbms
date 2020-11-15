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
import com.secure.secureboot.entities.Dress;
import com.secure.secureboot.util.PreparedStatementUtil;

@Repository
public class DressDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	private PreparedStatementUtil preparedStatementUtil;
	
	public Dress save(Dress dress) {
		String sql = "insert into dress(dressDescription)"
				+ "values(?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, new String[] { "dressId" });
                preparedStatementUtil.setParameters
                (preparedStatement, dress.getDressDescription());
                return preparedStatement;
            }
        }, keyHolder);
        int dressId = keyHolder.getKey().intValue();
        dress.setDressId(dressId);
        return dress;
		
	}

	
	public List<Dress> getAll() {
		 String sql = "SELECT * FROM dress";
	        List<Dress> dresses = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dress.class));
	        return dresses;
	}
	
	public Dress get(Integer dressId) {
		String sql = "SELECT * FROM dress where dressId = ?";
		Dress dresses = jdbcTemplate.queryForObject(sql,
				new Object[] { dressId }, new BeanPropertyRowMapper<>(Dress.class));
		return dresses;
	}
	public DressDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
