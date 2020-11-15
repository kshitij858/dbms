package com.secure.secureboot.controller.admin;

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
import com.secure.secureboot.dao.ClassAndDressDaoImpl;
import com.secure.secureboot.dao.ClassDaoImpl;
import com.secure.secureboot.dao.CourseDaoImpl;
import com.secure.secureboot.dao.DressDaoImpl;
import com.secure.secureboot.dao.SectionAndClassImpl;
import com.secure.secureboot.dao.SectionDaoImpl;
import com.secure.secureboot.dao.StudentWithSectionDaoImpl;
import com.secure.secureboot.dao.TeacherDao;
import com.secure.secureboot.dao.TeacherWithSectionDaoImpl;
import com.secure.secureboot.entities.ClassAndCourse;
import com.secure.secureboot.entities.ClassAndDress;
import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.Course;
import com.secure.secureboot.entities.Dress;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.SectionAndClass;
import com.secure.secureboot.entities.Teacher;

@Controller
@RequestMapping("/admin/{username}/classes")
public class ClassController {

	@Autowired
	private ClassDaoImpl classDaoImpl;
	@Autowired
	private SectionDaoImpl sectionDaoImpl;
	@Autowired
	private SectionAndClassImpl sectionAndClassImpl;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private CourseDaoImpl courseDaoImpl;
	@Autowired
	private ClassAndCourseDaoImpl classAndCourseDaoImpl;
	@Autowired
	private StudentWithSectionDaoImpl studentWithSectionDaoImpl;
	@Autowired
	private TeacherWithSectionDaoImpl teacherWithSectionDaoImpl;
	@Autowired
	private ClassAndDressDaoImpl classAndDressDaoImpl;
	@Autowired
	private DressDaoImpl dressDaoImpl;
	@RequestMapping("")
	String homePageOfClasses(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("allClasses", classDaoImpl.getAll());
		return "admin/class/home";
	}
	//in a particular class --> see sections associated with a class
	@GetMapping("/{classId}/section")
	String inClassForSection(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("currUrl", pathVars.get("classId"));
		model.addAttribute
		("sectionsAndClasses", sectionAndClassImpl.getByClassId(Integer.parseInt(pathVars.get("classId"))));
		return "admin/class/inClassForSection";
		
	}
	//in a particular class --> see uniforms associated with a class
	@GetMapping("/{classId}/dress")
	String classDress(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("options", dressDaoImpl.getAll());
		model.addAttribute("dresses", classAndDressDaoImpl.getByClassId(Integer.parseInt(pathVars.get("classId"))));
		return "admin/class/dress";
		
	}
	@GetMapping("/{classId}/addDress")
	String addDress(@PathVariable Map<String, String> pathVars, Model model, @ModelAttribute Dress dress) {
		ClassAndDress classAndDress = new ClassAndDress();
		System.out.println("dress = " + dress);
		classAndDress.setClassId(Integer.parseInt(pathVars.get("classId")));
		classAndDress.setDress(dress);
		classAndDressDaoImpl.save(classAndDress);
		return "redirect:/admin/{username}/classes/{classId}/dress";
		
	}
	//in a particular class --> see courses associated with a class
	@GetMapping("/{classId}/course")
	String inClassForCourses(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("currUrl", pathVars.get("classId"));
		model.addAttribute
		("classesAndCourses", classAndCourseDaoImpl.getByClassId(Integer.parseInt(pathVars.get("classId"))));
		
		return "admin/class/inClassForCourses";
	}
	
	// view a combination of class and section
	@GetMapping("/{classId}/{sectionId}/view")
	String view(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("currUrl", pathVars.get("classId"));
		Integer classId = Integer.parseInt(pathVars.get("classId"));
		Integer sectionId = Integer.parseInt(pathVars.get("sectionId"));
		model.addAttribute("oneClass", classDaoImpl.get(classId));
		model.addAttribute("classSection",sectionAndClassImpl.getUnique(classId, sectionId));
		model.addAttribute("students",studentWithSectionDaoImpl.
				getByClassIdAndSectionId(classId, sectionId));
		model.addAttribute("teacher", 
				teacherDao.getByTeacherId(sectionAndClassImpl.getUnique(classId, sectionId).getTeacherId()));
		model.addAttribute("currentUrl", "/admin/{username}/allStudents");
		model.addAttribute("teachers", teacherDao.getAllUsers());
		return "admin/class/view";
	}
	@PostMapping("/{classId}/{sectionId}/selectClassTeacher")
	String view1(@PathVariable Map<String, String> pathVars, Model model, @ModelAttribute Teacher teacher) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("currUrl", pathVars.get("classId"));
		Integer classId = Integer.parseInt(pathVars.get("classId"));
		Integer sectionId = Integer.parseInt(pathVars.get("sectionId"));
		SectionAndClass sectionAndClass = sectionAndClassImpl.getUnique(classId, sectionId);
		sectionAndClass.setTeacherId(teacher.getTeacherId());
		sectionAndClassImpl.update(sectionAndClass);
		return "redirect:/welcome";
	}
	@GetMapping("/{classId}/{sectionId}/viewStudents")
	String viewStudents(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("currUrl", pathVars.get("classId"));
		Integer classId = Integer.parseInt(pathVars.get("classId"));
		Integer sectionId = Integer.parseInt(pathVars.get("sectionId"));
		model.addAttribute("oneClass", classDaoImpl.get(classId));
		model.addAttribute("classSection",sectionAndClassImpl.getUnique(classId, sectionId));
		model.addAttribute("students",studentWithSectionDaoImpl.
				getByClassIdAndSectionId(classId, sectionId));
		model.addAttribute("teacher", 
				teacherDao.getByTeacherId(sectionAndClassImpl.getUnique(classId, sectionId).getTeacherId()));
		model.addAttribute("currentUrl", "/admin/{username}/allStudents");
		return "admin/class/ViewStudents";
	}
	@GetMapping("/{classId}/{sectionId}/viewTeachers")
	String viewTeachers(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("currUrl", pathVars.get("classId"));
		Integer classId = Integer.parseInt(pathVars.get("classId"));
		Integer sectionId = Integer.parseInt(pathVars.get("sectionId"));
		model.addAttribute("oneClass", classDaoImpl.get(classId));
		model.addAttribute("classSection",sectionAndClassImpl.getUnique(classId, sectionId));
		model.addAttribute("teacher", 
				teacherDao.getByTeacherId(sectionAndClassImpl.getUnique(classId, sectionId).getTeacherId()));
		model.addAttribute("currentUrl", "/admin/{username}/allTeachers");
		model.addAttribute("teachers", teacherWithSectionDaoImpl.getByClassIdAndSectionId(classId, sectionId));
		return "admin/class/viewTeachers";
	}
	//linking section to class
	@GetMapping("/{classId}/newSection")
	String newSection(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("allSections", sectionDaoImpl.getAll());
		return "admin/class/newSection";
	}
	@PostMapping("/{classId}/newSection")
	String newSection1(@PathVariable Map<String, String> pathVars, Model model,
			@ModelAttribute Section section) {
		model.addAttribute("username", pathVars.get("username"));
		SectionAndClass sectionAndClass = new SectionAndClass();
		sectionAndClass.setClassId(Integer.parseInt(pathVars.get("classId")));
		sectionAndClass.setSection(section);
		System.out.println(sectionAndClass);
		sectionAndClassImpl.save(sectionAndClass);
		return "redirect:/admin/pathVars.get(\"username\")/classes";
	}
	
	//linking course to class
		@GetMapping("/{classId}/newCourse")
		String newCourse(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			model.addAttribute("allCourses", courseDaoImpl.getAll());
			return "admin/class/newCourse";
		}
		@PostMapping("/{classId}/{courseId}")
		String newCourse1(@PathVariable Map<String, String> pathVars, Model model) {
			
			ClassAndCourse classAndCourse = new ClassAndCourse();
			Course course = new Course();
			course.setCourseId(Integer.parseInt(pathVars.get("courseId")));
			classAndCourse.setCourse(course);
			classAndCourse.setClassId(Integer.parseInt(pathVars.get("classId")));
			classAndCourseDaoImpl.save(classAndCourse);
			
			/*SectionAndClass sectionAndClass = new SectionAndClass();
			sectionAndClass.setClassId(Integer.parseInt(pathVars.get("classId")));
			sectionAndClass.setSection(section);
			sectionAndClassImpl.save(sectionAndClass);*/
			return "redirect:/welcome";
		}
	
	
	//create class
		@GetMapping("/createClass")
		String createClass(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			return "admin/class/createClass";
		}
		@PostMapping("/createClass")
		String createClass(@ModelAttribute Classes classes, Model model,
				@PathVariable Map<String, String> pathVars) {
			classDaoImpl.save(classes);
			model.addAttribute("username", pathVars.get("username"));
			return "redirect:/admin/pathVars.get(\"username\")/classes";
		}
		
		//create section
		@GetMapping("/createSection")
		String createSection(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			return "admin/class/createSection";
		}
		@PostMapping("/createSection")
		String createSection(@ModelAttribute Section section, Model model,
				@PathVariable Map<String, String> pathVars) {
			sectionDaoImpl.save(section);
			model.addAttribute("username", pathVars.get("username"));
			return "redirect:/admin/pathVars.get(\"username\")/classes";
		}

	public ClassController() {
		// TODO Auto-generated constructor stub
	}

}
