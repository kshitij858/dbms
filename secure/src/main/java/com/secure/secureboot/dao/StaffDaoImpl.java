package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Staff;
import com.secure.secureboot.entities.Teacher;
import com.secure.secureboot.entities.User;

@Repository
public class StaffDaoImpl implements StaffDao {

	public StaffDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Staff save(Staff staff) {
		String sql = "select * from staff natural join user where userId = ?";
		List<Staff> staffs = jdbcTemplate.query(sql,new Object[] 
				{ staff.getUser().getUserId() },new StaffRowMapper());
		Integer k = staffs.size();
		if(k.equals(0)) {

			System.out.println("in save method of staff Dao");
			String s = "insert into staff(salary, designation, numberOfLeavesAllowed, userId)" + 
					"values(?,?,?,?)";
			jdbcTemplate.update(s, 5000,"Worker",20, staff.getUser().getUserId());
		}
		return staff;
	}

	@Override
	public List<Staff> getAllUsers() {
		String sql = "select * from staff natural join user";
		List<Staff> staff = jdbcTemplate.query(sql,new StaffRowMapper());
		return staff;
	}

	@Override
	public Staff update(Staff staff) {
		User user = staff.getUser();
		String sql = "update staff set leavesTaken=?, numberOfLeavesAllowed=?, salary=?, designation=? "
				+ "where userId = ?";
		jdbcTemplate.update(sql,staff.getLeavesTaken(), staff.getNumberOfLeavesAllowed(),
				staff.getSalary(), staff.getDesignation()  , user.getUserId());
		return	staff;
	}

	@Override
	public Staff get(Integer userId) {
		try {
            String sql = "SELECT * FROM staff NATURAL JOIN user WHERE userId = ?";
            return (Staff) jdbcTemplate.queryForObject(sql, new Object[] {
                    userId },
                    new StaffRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

}
