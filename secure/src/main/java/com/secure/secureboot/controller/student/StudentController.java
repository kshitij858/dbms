package com.secure.secureboot.controller.student;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.secureboot.dao.AchievementDaoImpl;
import com.secure.secureboot.dao.ClassDaoImpl;
import com.secure.secureboot.dao.ParticipationDaoImpl;
import com.secure.secureboot.dao.PositionOfResponsibilityDaoImpl;
import com.secure.secureboot.dao.SectionAndClassImpl;
import com.secure.secureboot.dao.SectionDaoImpl;
import com.secure.secureboot.dao.StudentDao;
import com.secure.secureboot.dao.StudentWithSectionDaoImpl;
import com.secure.secureboot.dao.TransactionDaoImpl;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.StudentWithSection;
import com.secure.secureboot.entities.User;

@Controller
@RequestMapping("/student/{username}")
public class StudentController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private AchievementDaoImpl achievementDaoImpl;
	@Autowired
	private ClassDaoImpl classDaoImpl;
	@Autowired
	private ParticipationDaoImpl participationDaoImpl;
	@Autowired
	private SectionDaoImpl sectionDaoImpl;
	
	@Autowired
	private SectionAndClassImpl sectionAndClassImpl;
	@Autowired
	private PositionOfResponsibilityDaoImpl positionOfResponsibilityDaoImpl;
	@Autowired
	private StudentWithSectionDaoImpl studentWithSectionDaoImpl;
	@Autowired
	private TransactionDaoImpl transactionDaoImpl;
	private Student curStudent;
	private String curUsername;
	@RequestMapping("")
	String adminHomePage(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		return "student/home";
	}
	
	//viewing information
		//general information
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
		model.addAttribute("student",studentDao.get(userDao.findByUsername(pathVars.get("username")).getUserId() ));
		model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
		return "student/userSpecInfo";
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
	//view classes
	@GetMapping("/viewClasses")
	String viewClasses (@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", curUsername);
		
		model.addAttribute("classesOfStudent",
				studentWithSectionDaoImpl.getByStudent(getCurStudent(pathVars.get("username")).getStudentId()));

		return "admin/classesOfStudent";
	}
	
	//view PositionOfResponsibility
		@GetMapping("/viewPositionOfResponsibility")
		String viewPositionOfResponsibility (@PathVariable Map<String, String> pathVars, Model model) {
			
			model.addAttribute("allResponsibilities", 
					positionOfResponsibilityDaoImpl.getByUserId(userDao.getUser(pathVars.get("username")).getUserId()));
			return "admin/user/positionOfResponsibility/viewResponsibility";
		}
	//viewAchievement
			@GetMapping("/viewAchievement")
			String viewAchievement (@PathVariable Map<String, String> pathVars, Model model) {
				model.addAttribute("allAchievements", 
						achievementDaoImpl.getByUserId(userDao.getUser(pathVars.get("username")).getUserId()));
				return "admin/user/achievement/viewAchievement";
			}
	//viewParticipation
	@GetMapping("/viewParticipation")
	String viewParticipation (@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("allParticipation", 
				participationDaoImpl.getByUserId(userDao.getUser(pathVars.get("username")).getUserId()));
		return "admin/user/participation/viewParticipation";
	}
	
	//viewTransactions
	@RequestMapping("/viewTransactions")
	String viewTransactions(@PathVariable Map<String, String> pathVars, Model model) {
		User user = userDao.getUser(pathVars.get("username"));
		Integer userId = user.getUserId();
		model.addAttribute("transactions", transactionDaoImpl.getByUserId(userId));
		model.addAttribute("totalFeesDue", studentDao.get(userId).getFeesDue());
		return "admin/viewTransaction";
	}
	public Student getCurStudent(String username) {
		return studentDao.get(userDao.getUser(username).getUserId());
	}
	public void StudentController() {
	}
	
	

}
