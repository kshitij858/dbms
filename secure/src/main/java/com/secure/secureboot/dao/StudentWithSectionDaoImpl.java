package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.SectionAndClass;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.StudentWithSection;

@Repository
public class StudentWithSectionDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ClassDaoImpl classDaoImpl;
	@Autowired
	private SectionDaoImpl sectionDaoImpl;
	@Autowired
	private StudentDao studentDao;
	
	public StudentWithSection save(StudentWithSection studentWithSection) {
		
		String sql = "select * from studentWithClass natural join sectionAndClass where "
				+ "classId= ? and sectionId = ? and studentId = ? " ;
		List<StudentWithSection> studentWithSections = jdbcTemplate.query(sql, 
				new Object[] { studentWithSection.getClasses().getClassId(), 
						studentWithSection.getSection().getSectionId(),
						studentWithSection.getStudentId() },
                new StudentWithSectionRowMapper());
		Integer k = studentWithSections.size();
		if(k.equals(0)) {
			String s = "insert into studentWithClass(studentId, classId, sectionId)" +
						"values(?,?,?)";
			jdbcTemplate.update(s,studentWithSection.getStudentId(), 
					studentWithSection.getClasses().getClassId(), 
					studentWithSection.getSection().getSectionId());
			Student student = studentDao.getByStudentId(studentWithSection.getStudentId());
			Classes classes = classDaoImpl.get(studentWithSection.getClasses().getClassId());
			student.setFeesDue(student.getFeesDue() + classes.getFees());
			studentDao.update(student);
		}
		return studentWithSection;
	}

	
	public List<StudentWithSection> getByStudent(Integer studentId){
		String sql = "select * from studentWithClass natural join section natural join class where studentId = ?";
		List<StudentWithSection> studentWithSections = jdbcTemplate.query(sql, 
				new Object[] { studentId },
                new StudentWithSectionRowMapper());
		return studentWithSections ;
	}
	public List <Student> getByClassIdAndSectionId(Integer classId, Integer sectionId){
		String sql = "select * from studentWithClass natural join section natural join class"
				+ " natural join student natural join user where"
				+ " classId = ? and sectionId = ?";
		List<Student> students = jdbcTemplate.query(sql, new Object[] {classId, sectionId},
		new StudentRowMapper());
		return students;
	}

	public StudentWithSectionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
