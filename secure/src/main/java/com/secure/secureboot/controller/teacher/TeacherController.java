package com.secure.secureboot.controller.teacher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.secureboot.dao.PositionOfResponsibilityDaoImpl;
import com.secure.secureboot.dao.TeacherDao;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.User;

@Controller
@RequestMapping("/teacher/{username}")
public class TeacherController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private PositionOfResponsibilityDaoImpl positionOfResponsibilityDaoImpl;
	@RequestMapping("")
	String adminHomePage(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		return "teacher/home";
	}
	
	//viewing information
	@GetMapping("/genInfo")
	String viewGenInfo(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
		return "generalInfo";
	}
		//user specific information
	@GetMapping("/userSpecInfo")
	String userSpecInfo(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("teacher",teacherDao.get(userDao.findByUsername(pathVars.get("username")).getUserId() ));
		model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
		return "teacher/userSpecInfo";
	}
	
	//update general information
	@GetMapping("/updateGenInfo")
	String updateGenInfo(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
		return "admin/updateUser";
	}

	@PostMapping("/updateGenInfo")
	String updateGeneralInformation(@PathVariable Map<String, String> pathVars, Model model, 
			 @ModelAttribute User user) {
		user.setUserId(userDao.findByUsername(pathVars.get("username")).getUserId());
		userDao.update(user);
		return "redirect:/welcome";
	}
	//view PositionOfResponsibility
			@GetMapping("/viewPositionOfResponsibility")
			String viewPositionOfResponsibility (@PathVariable Map<String, String> pathVars, Model model) {
				
				model.addAttribute("allResponsibilities", 
						positionOfResponsibilityDaoImpl.getByUserId(userDao.getUser(pathVars.get("username")).getUserId()));
				return "admin/user/positionOfResponsibility/viewResponsibility";
			}
	public TeacherController() {
		// TODO Auto-generated constructor stub
	}

}
