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

import com.secure.secureboot.dao.CourseDaoImpl;
import com.secure.secureboot.entities.Course;

@Controller
@RequestMapping("/admin/{username}/courses")
public class CourseController {
	
	@Autowired
	private CourseDaoImpl courseDaoImpl;
	
	@RequestMapping("")
	String adminHomePage(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		return "admin/course/home";
	}
	// view all courses
	@RequestMapping("/allCourses")
	String allCourses(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("allCourses", courseDaoImpl.getAll());
		return "admin/course/allCourses";
	}
	//create course
	@GetMapping("/createCourse")
	String createCourse(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		return "admin/course/createCourse";
	}
	@PostMapping("/createCourse")
	String createCourse1(@PathVariable Map<String, String> pathVars, @ModelAttribute Course course) {
		courseDaoImpl.save(course);
		return "redirect:/welcome";
	}
	
	public CourseController() {
		// TODO Auto-generated constructor stub
	}

}
