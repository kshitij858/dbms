package com.secure.secureboot.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.User;
import com.secure.secureboot.util.PreparedStatementUtil;
import com.sun.jdi.connect.spi.Connection;

@Repository
public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PreparedStatementUtil preparedStatementUtil;
	
	@Override
    public User save(User user) {
		long millis=System.currentTimeMillis();  
		java.sql.Date dates=new java.sql.Date(millis);  
        String sql = "insert into user (username, password,role, registrationDate) "+ "values (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, new String[] { "userId" });
                preparedStatementUtil.setParameters(preparedStatement, user.getUsername(), user.getPassword(),"ROLE_"+user.getRole(), dates);
                return preparedStatement;
            }
        }, keyHolder);
        int userId = keyHolder.getKey().intValue();
        user.setUserId(userId);
        return user;
    }
	

	@Override
	public User getUser(String username) {
		String sql = "select * from user where username = ?";
		try {
            return (User) jdbcTemplate.queryForObject(sql, new Object[] { username },
                    new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	@Override
	public User findByUsername(String username) {
		try {
            String sql = "SELECT * FROM user WHERE username = ?";
            return (User) jdbcTemplate.queryForObject(sql, new Object[] { username },
                    new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	@Override
	public List<User> getAllUsers() {
		 String sql = "SELECT * FROM user";
	        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	        return users;
	}

	@Override
	public void delete(String username) {
		
	}


	@Override
	public void update(User user) {
		String sql = "UPDATE user SET  firstName = ?, middleName = ?, lastName = ?,  houseNumber= ?,"
				+ "streetName = ?, city = ?, pincode= ?, "
				+ "adharNumber= ?, category= ?,bloodGroup= ?,gender= ?  where userId = ? " ;
        jdbcTemplate.update(sql, user.getFirstName(), user.getMiddleName(), 
        		user.getLastName(), user.getHouseNumber(),user.getStreetName(), user.getCity(), 
        		user.getPincode(), user.getAdharNumber(),user.getCategory(), user.getBloodGroup(), 
        		user.getGender(), user.getUserId());
		
	}


	@Override
	public User findByUserId(Integer userId) {
		try {
            String sql = "SELECT * FROM user WHERE userId = ?";
            return (User) jdbcTemplate.queryForObject(sql, new Object[] { userId },
                    new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}


}
