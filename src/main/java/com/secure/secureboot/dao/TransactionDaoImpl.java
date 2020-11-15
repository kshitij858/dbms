package com.secure.secureboot.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Feedback;
import com.secure.secureboot.entities.Transaction;
import com.secure.secureboot.util.DateTimeUtil;

@Repository
public class TransactionDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DateTimeUtil dateTimeUtil;

	public List<Transaction> getAllTransactions() {
		String sql = "select * from transaction natural join student natural join user";
		List<Transaction> transaction = jdbcTemplate.query(sql,new TransactionRowMapper());
		return transaction;
	}
	
	public List<Transaction> getByUserId(Integer userId) {
		String sql = "select * from transaction natural join student natural join user "
				+ "where userId = ?";
		List<Transaction> transactions = jdbcTemplate.query(sql, new Object[] {
                userId },new TransactionRowMapper() );
		return transactions;
	}
	
	public List<Transaction> getByStudentId(Integer studentId) {
		String sql = "select * from transaction natural join student natural join user "
				+ "where studentId = ?";
		List<Transaction> transactions = jdbcTemplate.query(sql, new Object[] {
				studentId },new TransactionRowMapper() );
		return transactions;
	}
	
	public Transaction save(Transaction transaction) {
		String s = "insert into transaction(amount,dateOfTransaction ,"
				+ "studentId)" + "values(?,?,?)";
		jdbcTemplate.update(s, transaction.getAmount(), transaction.getDateOfTransaction(),
				transaction.getStudent().getStudentId());
		return transaction;
	}
	
	public Integer totalFeesDue() {
		String sql = "select sum(feesDue) as feesDue from student";
		Integer ans = jdbcTemplate.queryForObject(sql, Integer.class);
		return ans;
	}
	public Integer sumRangeTransaction(Date fromDate, Date tillDate) {
		String sql = "select sum(amount) from transaction where dateOfTransaction between ? and ?";
		Integer ans = jdbcTemplate.queryForObject(sql, new Object[] {fromDate, tillDate}, Integer.class);
		return ans;
	}
	public List<Transaction> rangeTransaction(Date fromDate, Date tillDate){
		String sql = "select * from transaction natural join student natural join user where dateOfTransaction between ? and ?";
		List<Transaction> transaction = jdbcTemplate.query(sql, new Object[] {fromDate, tillDate}, new TransactionRowMapper());
		return transaction;
	}
	public TransactionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
