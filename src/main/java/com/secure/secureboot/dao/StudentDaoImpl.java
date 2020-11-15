package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StudentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Student> getAllUsers() {
		String sql = "select * from student natural join user";
		List<Student> students = jdbcTemplate.query(sql,new StudentRowMapper());
		return students;
	}

	@Override
	public Student save(Student student) {
		String sql = "select * from student natural join user where userId = ?";
		List<Student> students = jdbcTemplate.query(sql, 
				new Object[] { student.getUser().getUserId() },
                new StudentRowMapper());
		Integer k = students.size();
		if(k.equals(0)) {
			String s = "insert into student(feesDue, userId)" + "values(?,?)";
			jdbcTemplate.update(s, 0, student.getUser().getUserId());
		}
		return student;
	}

	public Student update(Student student) {
		String sql = "select * from student natural join user where userId = ?";
		List<Student> students = jdbcTemplate.query(sql, 
				new Object[] { student.getUser().getUserId() },
                new StudentRowMapper());
		Integer k = students.size();
		if(k.equals(1)) {
			User user = student.getUser();
			String s = "update student set leavesTaken=?, feesDue=? where userId = ?";
			jdbcTemplate.update(s,student.getLeavesTaken(), student.getFeesDue(), user.getUserId());
		}
		return student;
	}
	/*@Override
	public Student update(Student student) {
		System.out.println("in student dao update");
		User user = student.getUser();
		System.out.println(user);
		String sql = "update user set firstName=?, middleName=?, lastName=?, houseNumber=?, city=?,"
				+ "streetName=?, pincode=?, adharNumber=?, category=?, bloodGroup=?, gender=?,"
				+ "leavesTaken=? where userId = ?";
		jdbcTemplate.update(sql,user.getFirstName(), user.getMiddleName(), user.getLastName(), 
				user.getHouseNumber(), user.getCity(), user.getStreetName(), user.getPincode(), 
				user.getAdharNumber(), user.getCategory(), user.getBloodGroup(), user.getGender(),
				 user.getLeavesTaken(), user.getUserId());
		sql = "update student set feesDue = ? where userId = ?";
		jdbcTemplate.update(sql, student.getFeesDue(), user.getUserId());
		return null;
	}*/

	@Override
	public Student get(Integer userId) {
		try {
            String sql = "SELECT * FROM student NATURAL JOIN user WHERE userId = ?";
            return (Student) jdbcTemplate.queryForObject(sql, new Object[] {
                    userId },
                    new StudentRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	@Override
	public Student getByStudentId(Integer studentId) {
		try {
            String sql = "SELECT * FROM student NATURAL JOIN user WHERE studentId = ?";
            return (Student) jdbcTemplate.queryForObject(sql, new Object[] {
                    studentId },
                    new StudentRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

}
