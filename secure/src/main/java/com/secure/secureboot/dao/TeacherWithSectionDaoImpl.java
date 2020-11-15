package com.secure.secureboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.StudentWithSection;
import com.secure.secureboot.entities.Teacher;
import com.secure.secureboot.entities.TeacherWithSection;

@Repository
public class TeacherWithSectionDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public TeacherWithSection save(TeacherWithSection teacherWithSection) {
		String sql = "select * from teacherWithSection  where "
				+ "teacherId= ? and sectionId = ? and classId = ? and courseId = ? " ;
		List<TeacherWithSection> teacherWithSections = jdbcTemplate.query(sql, 
				new Object[] { teacherWithSection.getTeacherId() , 
						teacherWithSection.getSection().getSectionId()  , 
						teacherWithSection.getClasses().getClassId(),
						teacherWithSection.getCourse().getCourseId()  },
                new TeacherWithSectionRowMapper());
		Integer k = teacherWithSections.size();
		if(k.equals(0)) {
			String s = "insert into teacherWithSection(teacherId, classId, sectionId, courseId)" +
						"values(?,?,?,?)";
			jdbcTemplate.update(s,teacherWithSection.getTeacherId(), 
					teacherWithSection.getClasses().getClassId(), 
					teacherWithSection.getSection().getSectionId(),
					teacherWithSection.getCourse().getCourseId());
		}
		return teacherWithSection;
	}
	public List<TeacherWithSection> getByTeacher(Integer teacherId){
		String sql = "select * from teacherWithSection natural join section natural join class "
				+ "natural join course where teacherId = ?";
		List<TeacherWithSection> teacherWithSections = jdbcTemplate.query(sql, 
				new Object[] { teacherId },
                new TeacherWithSectionRowMapper());
		return teacherWithSections ;
	}
	public List <Teacher> getByClassIdAndSectionId(Integer classId, Integer sectionId){
		String sql = "select * from teacherWithSection natural join section natural join class"
				+ " natural join teacher natural join user where"
				+ " classId = ? and sectionId = ?";
		List<Teacher> teachers = jdbcTemplate.query(sql, new Object[] {classId, sectionId},
		new TeacherRowMapper());
		return teachers;
	}
	public TeacherWithSectionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
