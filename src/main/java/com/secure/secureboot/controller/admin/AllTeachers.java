package com.secure.secureboot.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.secureboot.dao.ClassAndCourseDaoImpl;
import com.secure.secureboot.dao.ClassDaoImpl;
import com.secure.secureboot.dao.PositionOfResponsibilityDaoImpl;
import com.secure.secureboot.dao.SectionAndClassImpl;
import com.secure.secureboot.dao.SectionDaoImpl;
import com.secure.secureboot.dao.StudentDao;
import com.secure.secureboot.dao.TeacherDao;
import com.secure.secureboot.dao.TeacherWithSectionDaoImpl;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.Course;
import com.secure.secureboot.entities.PositionOfResponsibility;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.StudentWithSection;
import com.secure.secureboot.entities.Teacher;
import com.secure.secureboot.entities.TeacherWithSection;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.services.SecurityService;
import com.secure.secureboot.services.UserService;

@Controller
@RequestMapping("/admin/{username}/allTeachers")
public class AllTeachers {
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private ClassDaoImpl classDaoImpl;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SectionAndClassImpl sectionAndClassImpl;
	@Autowired
	private ClassAndCourseDaoImpl classAndCourseDaoImpl;
	@Autowired
	private TeacherWithSectionDaoImpl teacherWithSectionDaoImpl;
	@Autowired
	private PositionOfResponsibilityDaoImpl positionOfResponsibilityDaoImpl;

	
	@RequestMapping(" ")
	String allTeachers(@PathVariable Map<String, String> pathVars, Model model) {
		List<Teacher> allUsers = teacherDao.getAllUsers();
		model.addAttribute("currentUrl", "allTeachers");
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("allUsers",teacherDao.getAllUsers());
		return "admin/view/allTeachers";
	}

	//position Of responsibility
		@GetMapping("/{userId}/positionOfResponsibility")
		String positionOfResposibility(@PathVariable Map<String, String> pathVars, Model model) {
			return "admin/user/positionOfResponsibility/home";
		}
		@GetMapping("/{userId}/addResponsibility")
		String addResponsibility(@PathVariable Map<String, String> pathVars, Model model) {
			return "admin/user/positionOfResponsibility/addResponsibility";
		}
		@PostMapping("/{userId}/addResponsibility")
		String addResponsibility1(@PathVariable Map<String, String> pathVars,@ModelAttribute PositionOfResponsibility 
				positionOfResponsibility) {
			User tempUser = new User();
			tempUser.setUserId(Integer.parseInt(pathVars.get("userId")));
			positionOfResponsibility.setUser(tempUser);
			positionOfResponsibilityDaoImpl.save(positionOfResponsibility);
			return "redirect:/welcome";
		}
		@GetMapping("/{userId}/viewResponsibility")
		String viewResposibility(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("allResponsibilities", 
					positionOfResponsibilityDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
			System.out.println(positionOfResponsibilityDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
			return "admin/user/positionOfResponsibility/viewResponsibility";
		}
	
	//update general information
	@GetMapping("/{userId}/updateGenInfo")
	String updateGenInfo(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("userId", pathVars.get("userId"));
		model.addAttribute("user", userDao.findByUserId(Integer.parseInt(pathVars.get("userId"))));
		return "admin/updateUser";
	}

	@PostMapping("/{userId}/updateGenInfo")
	String updateGeneralInformation(@PathVariable Map<String, String> pathVars, Model model, 
			 @ModelAttribute User user) {
		String s = pathVars.get("userId");
		int k = Integer.parseInt(s);
		user.setUserId(k);
		userDao.update(user);
		return "redirect:/welcome";
	}
	
	// update user specific information
	@GetMapping("/{userId}/updateSpecInfo")
	String updateSpecInfo(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("userId", pathVars.get("userId"));
		model.addAttribute("teacher", teacherDao.get(Integer.parseInt(pathVars.get("userId"))));
		return "admin/updateTeacher";
	}

	@PostMapping("/{userId}/updateSpecInfo")
	String updateSpecInfo(@PathVariable Map<String, String> pathVars, Model model, 
			 @ModelAttribute Teacher teacher) {
		String s = pathVars.get("userId");
		int k = Integer.parseInt(s);
		User user = new User();
		user.setUserId(k);
		teacher.setUser(user);
		teacherDao.update(teacher);
		return "redirect:/welcome";
	}
	
	
	@GetMapping("/{userId}/classesOfTeacher")
	String classesOfTeacher(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("teacherWithSection",
				teacherWithSectionDaoImpl.getByTeacher(getCurTeacher(pathVars.get("userId")).getTeacherId()));
		return "admin/view/classesOfTeacher";
	}
	//add teacher to a class
		@GetMapping("/{userId}/addToClass")
		String addToClass(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
			
			model.addAttribute("allClasses",classDaoImpl.getAll());
			return "admin/addToClass/selectClass";
		}
		@GetMapping("/{userId}/addToClass/{classId}")
		String addToClass1(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
			model.addAttribute
			("sectionsAndClasses", sectionAndClassImpl.getByClassId(Integer.parseInt(pathVars.get("classId"))));
			return "admin/addToClass/seclectSection";
		}
		
		@PostMapping("/{userId}/addToClass/{classId}/{sectionId}")
		String addToThisClassAndSection(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute
			("classesAndCourses", classAndCourseDaoImpl.getByClassId(Integer.parseInt(pathVars.get("classId"))));
			model.addAttribute("sectionId", Integer.parseInt(pathVars.get("sectionId")));
			/*StudentWithSection studentWithSection = new StudentWithSection();
			Classes classes = new Classes();
			classes.setClassId(Integer.parseInt(pathVars.get("classId")));
			studentWithSection.setClasses(classes);
			Section section = new Section();
			section.setSectionId(Integer.parseInt(pathVars.get("sectionId")));
			studentWithSection.setSection(section);
			studentWithSection.setStudentId(getCurStudent(pathVars.get("userId")).getStudentId());
			//studentWithSection.setStudentId(studentDao.get(userDao.findByUsername(pathVars.get("username")).getUserId()).getStudentId());
			studentWithSectionDaoImpl.save(studentWithSection);*/
			return "admin/addToClass/selectCourse";
		}
		@PostMapping("/{userId}/addToClass/{classId}/{sectionId}/{courseId}")
		String addToThisClassAndSectionAndCourse(@PathVariable Map<String, String> pathVars) {
			System.out.println("in final step of assigning teacher");
			TeacherWithSection teacherWithSection = new TeacherWithSection();
			Section section = new Section();
			section.setSectionId(Integer.parseInt(pathVars.get("sectionId")));
			teacherWithSection.setSection(section);
			Course course = new Course();
			course.setCourseId(Integer.parseInt(pathVars.get("courseId")));
			teacherWithSection.setCourse(course);
			Classes classes = new Classes();
			classes.setClassId(Integer.parseInt(pathVars.get("classId")));
			teacherWithSection.setClasses(classes);
			
			teacherWithSection.setTeacherId(getCurTeacher(pathVars.get("userId")).getTeacherId());
			System.out.println(teacherWithSection);
			teacherWithSectionDaoImpl.save(teacherWithSection);
			return "redirect:/welcome";
			
		}
	public Teacher getCurTeacher(String userId) {
		return teacherDao.get(Integer.parseInt(userId));
	}
	
	public AllTeachers() {
		// TODO Auto-generated constructor stub
	}

}
