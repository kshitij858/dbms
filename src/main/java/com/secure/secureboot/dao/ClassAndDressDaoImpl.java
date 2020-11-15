package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.secure.secureboot.entities.ClassAndDress;
import com.secure.secureboot.entities.Dress;
import com.secure.secureboot.entities.User;

@Repository
public class ClassAndDressDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ClassAndDress save(ClassAndDress classAndDress) {
		String sql = "select * from classAndDress where classId = ? and dressId = ?";
		List<ClassAndDress> classAndDresses = jdbcTemplate.query(sql, 
				new Object[] { classAndDress.getClassId(), classAndDress.getDress().getDressId()},
                new ClassAndDressRowMapper() );
		Integer k = classAndDresses.size();
		if(k.equals(0)) {
			String s = "insert into classAndDress(classId, dressId)" + "values(?,?)";
			jdbcTemplate.update(s,classAndDress.getClassId(), classAndDress.getDress().getDressId());
		}
		return classAndDress;
	}
	
	public List<Dress> getByClassId(Integer classId) {
		try {
			String sql = "select * from classAndDress natural join dress where classId = ?";
			List<Dress> classAndDresses = jdbcTemplate.query(sql, 
					new Object[] { classId },
					new BeanPropertyRowMapper<>(Dress.class)  );
			return classAndDresses;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	
	public ClassAndDress getUnique(Integer classId, Integer dressId) {
		try {
			String sql = "select * from classAndDress natural join dress where classId = ? and dressId = ?";
			ClassAndDress classAndDress = jdbcTemplate.queryForObject(sql, 
					new Object[] { classId, dressId },
	                new ClassAndDressRowMapper() );
			return classAndDress;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	

	public ClassAndDressDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
