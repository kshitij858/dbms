package com.secure.secureboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.Transaction;
import com.secure.secureboot.entities.User;

public class TransactionRowMapper implements RowMapper<Transaction> {

	public TransactionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction transaction = (new BeanPropertyRowMapper<>(Transaction.class)).mapRow(rs, rowNum);
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs, rowNum);
        Student student= (new BeanPropertyRowMapper<>(Student.class)).mapRow(rs, rowNum);
        student.setUser(user);
        transaction.setStudent(student);
        return transaction;
	}

}
