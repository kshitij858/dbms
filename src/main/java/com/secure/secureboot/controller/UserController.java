package com.secure.secureboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.secureboot.dao.GuardianDaoImpl;
import com.secure.secureboot.dao.StaffDao;
import com.secure.secureboot.dao.StudentDao;
import com.secure.secureboot.dao.TeacherDao;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.Guardian;
import com.secure.secureboot.entities.Staff;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.Teacher;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.services.SecurityService;
import com.secure.secureboot.services.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private GuardianDaoImpl guardianDaoImpl;
	
	
	//redirect according to role of user
	@RequestMapping("/welcome")
	public String welcome() {
		String username = securityService.findLoggedInUsername();
		if(username == null) {
			return "redirect:/login";
		}
		User user = userService.findByUsername(username);
		String role = (String)user.getRole();
        if(role.equals("ROLE_ADMIN")) {
        	System.out.println("going in admin");
        	return "redirect:/admin/"+username;
        }
        if(role.equals("ROLE_STUDENT") ) {
        	Student student = new Student();
        	student.setUser(user);
        	studentDao.save(student);
        	return "redirect:/student/"+username;
        }
        if(role.equals("ROLE_TEACHER")) {
        	Teacher teacher = new Teacher();
        	teacher.setUser(user);
        	teacherDao.save(teacher);
        	return "redirect:/teacher/"+username;
        }
        if(role.equals("ROLE_STAFF") ) {
        	Staff staff = new Staff();
        	staff.setUser(user);
        	staffDao.save(staff);
        	return "redirect:/staff/"+username;
        }

        if(role.equals("ROLE_GUARDIAN") ) {
        	Guardian guardian = new Guardian();
        	guardian.setUser(user);
        	guardianDaoImpl.save(guardian);
        	return "redirect:/guardian/"+username;
        }
        return "redirect:/login";
	}
	public UserController() {
		// TODO Auto-generated constructor stub
	}

}
