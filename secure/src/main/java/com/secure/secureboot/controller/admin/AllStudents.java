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

import com.secure.secureboot.dao.AchievementDaoImpl;
import com.secure.secureboot.dao.ClassDaoImpl;
import com.secure.secureboot.dao.GuardianDaoImpl;
import com.secure.secureboot.dao.ParticipationDaoImpl;
import com.secure.secureboot.dao.PositionOfResponsibilityDaoImpl;
import com.secure.secureboot.dao.SectionAndClassImpl;
import com.secure.secureboot.dao.SectionDaoImpl;
import com.secure.secureboot.dao.StudentAndGuardianDaoImpl;
import com.secure.secureboot.dao.StudentDao;
import com.secure.secureboot.dao.StudentWithSectionDaoImpl;
import com.secure.secureboot.dao.TeacherDao;
import com.secure.secureboot.dao.TransactionDaoImpl;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.dao.UserEmailDaoImpl;
import com.secure.secureboot.dao.UserPhoneNumberDaoImpl;
import com.secure.secureboot.entities.Achievement;
import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.Guardian;
import com.secure.secureboot.entities.Participation;
import com.secure.secureboot.entities.PositionOfResponsibility;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.StudentAndGuardian;
import com.secure.secureboot.entities.StudentWithSection;
import com.secure.secureboot.entities.Transaction;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.entities.UserEmail;
import com.secure.secureboot.entities.UserPhoneNumber;
import com.secure.secureboot.services.SecurityService;
import com.secure.secureboot.services.UserService;
import com.secure.secureboot.util.DateTimeUtil;

@Controller
@RequestMapping("/admin/{username}/allStudents")
public class AllStudents {
	
	@Autowired
	private SecurityService securityService;
	@Autowired
	private UserService userService;
	@Autowired
	private ClassDaoImpl classDaoImpl;
	@Autowired
	private SectionDaoImpl sectionDaoImpl;
	@Autowired
	private SectionAndClassImpl sectionAndClassImpl;
	@Autowired
	private StudentWithSectionDaoImpl studentWithSectionDaoImpl;
	@Autowired
	private UserDao userDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private PositionOfResponsibilityDaoImpl positionOfResponsibilityDaoImpl;
	@Autowired
	private AchievementDaoImpl achievementDaoImpl;
	@Autowired
	private ParticipationDaoImpl participationDaoImpl;
	@Autowired
	private GuardianDaoImpl guardianDaoImpl;
	@Autowired
	private StudentAndGuardianDaoImpl studentAndGuardianDaoImpl;
	@Autowired
	private UserEmailDaoImpl userEmailDaoImpl;
	@Autowired
	private UserPhoneNumberDaoImpl userPhoneNumberDaoImpl;
	@Autowired 
	private TransactionDaoImpl transactionDaoImpl;
	private Student curStudent;
	private String curUsername;
	@Autowired
	private DateTimeUtil dateTimeUtil;
	//seeing all students
	@RequestMapping(" ")
	String allStudents(@PathVariable Map<String, String> pathVars, Model model) {
		List<Student> allUsers = studentDao.getAllUsers();
		model.addAttribute("currentUrl", "allStudents");
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("allUsers",studentDao.getAllUsers());
		return "admin/view/allStudents";
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
		return "redirect:/admin/{username}/allStudents";
	}
	
	@GetMapping("/{userId}/viewResponsibility")
	String viewResposibility(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("allResponsibilities", 
				positionOfResponsibilityDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
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
		
		return "redirect:/admin/{username}/allStudents";
	}
	
	// update user specific information
	@GetMapping("/{userId}/updateSpecInfo")
	String updateSpecInfo(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("userId", pathVars.get("userId"));
		model.addAttribute("student", studentDao.get(Integer.parseInt(pathVars.get("userId"))));
		//student.setUser(userDao.findByUserId(Integer.parseInt(pathVars.get("userId"))));
		return "admin/updateStudent";
	}
	@PostMapping("/{userId}/updateSpecInfo")
	String updateSpecInfo(@PathVariable Map<String, String> pathVars, Model model, 
			 @ModelAttribute Student student) {
		String s = pathVars.get("userId");
		int k = Integer.parseInt(s);
		User user = new User();
		user.setUserId(k);
		student.setUser(user);
		studentDao.update(student);
		return "redirect:/admin/{username}/allStudents";
	}
	
	//seeing classes of a particular student
	@GetMapping("/{userId}/classesOfStudent")
	String classesOfStudent(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
		model.addAttribute("classesOfStudent",studentWithSectionDaoImpl.getByStudent
				(getCurStudent(pathVars.get("userId")).getStudentId()));

		return "admin/classesOfStudent";
	}
	
	//add student to a class
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
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
		model.addAttribute("studentId",getCurStudent(pathVars.get("userId")).getStudentId() );
		model.addAttribute
		("sectionsAndClasses", sectionAndClassImpl.getByClassId(Integer.parseInt(pathVars.get("classId"))));
		StudentWithSection studentWithSection = new StudentWithSection();
		Classes classes = classDaoImpl.get(Integer.parseInt(pathVars.get("classId")));
		studentWithSection.setClasses(classes);
		Section section = new Section();
		section.setSectionId(Integer.parseInt(pathVars.get("sectionId")));
		studentWithSection.setSection(section);
		studentWithSection.setStudentId(getCurStudent(pathVars.get("userId")).getStudentId());
		studentWithSectionDaoImpl.save(studentWithSection);
		return "redirect:/admin/{username}/allStudents";
	}
	//Achievement
	@GetMapping("/{userId}/viewAchievement")
	String viewAchievement(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("allAchievements", 
				achievementDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
		return "admin/user/achievement/viewAchievement";
	}
	@PostMapping("/{userId}/giveAchievement")
	String giveAchievement(@PathVariable Map<String, String> pathVars, @ModelAttribute Achievement achievement) {
		Student student = studentDao.get(Integer.parseInt(pathVars.get("userId")));
		achievement.setStudent(student);
		achievementDaoImpl.save(achievement);
		
		return "redirect:/admin/{username}/allStudents";
	}
	@GetMapping("/{userId}/giveAchievement")
	String giveAchievement(@PathVariable Map<String, String> pathVars, Model model) {
		return "admin/user/achievement/giveAchievement";
	}
	//Participation
		@GetMapping("/{userId}/viewParticipation")
		String viewParticipation(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("allParticipation", 
					participationDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
			return "admin/user/participation/viewParticipation";
		}
		@PostMapping("/{userId}/giveParticipation")
		String giveParticipation(@PathVariable Map<String, String> pathVars, @ModelAttribute Participation participation) {
			Student student = studentDao.get(Integer.parseInt(pathVars.get("userId")));
			participation.setStudent(student);
			participationDaoImpl.save(participation);	
			return "redirect:/admin/{username}/allStudents";
		}
		@GetMapping("/{userId}/giveParticipation")
		String giveParticipation(@PathVariable Map<String, String> pathVars, Model model) {
			return "admin/user/participation/giveParticipation";
		}
	//Guardians
		@GetMapping("/{userId}/addGuardian")
		String addGuardian(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
			
			model.addAttribute("allGuardians", guardianDaoImpl.getAllUsers());
			return "admin/selectGuardian";
		}
		@PostMapping("/{userId}/addGuardian/{guardianId}")
		String addGuardian2(@PathVariable Map<String, String> pathVars, 
				@ModelAttribute StudentAndGuardian studentAndGuardian) {
			studentAndGuardian.setStudentId(getCurStudent(pathVars.get("userId")).getStudentId());
			Guardian guardian = new Guardian();
			guardian.setGuardianId((Integer.parseInt(pathVars.get("guardianId"))));
			guardian.setIsActive("Active");
			studentAndGuardian.setGuardian(guardian);
			studentAndGuardianDaoImpl.save(studentAndGuardian);
			return "redirect:/admin/{username}/allStudents";
		}
		@GetMapping("/{userId}/guardiansOfStudent")
		String guardiansOfStudent(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			model.addAttribute("allUsers", 
					studentAndGuardianDaoImpl.getByStudentId(getCurStudent(pathVars.get("userId")).getStudentId()));
			return "admin/view/allGuardians";
		}
	
		
	//phone number and emails
		@GetMapping("/{userId}/viewPhoneNumbers")
		String viewPhoneNumbers(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("allPhonenumbers", 
					userPhoneNumberDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
			return "user/viewPhoneNumbers";
		}
		@GetMapping("/{userId}/viewEmails")
		String viewEmails(@PathVariable Map<String, String> pathVars, 
				@ModelAttribute Participation participation,
				Model model) {
			model.addAttribute("allEmails", 
					userEmailDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
			return "user/viewEmails";
		}
		@PostMapping("/{userId}/addPhoneNumber")
		String addPhoneNumber(@PathVariable Map<String, String> pathVars, @ModelAttribute UserPhoneNumber userPhoneNumber) {
			User user = new User();
			user.setUserId(Integer.parseInt(pathVars.get("userId")));
			userPhoneNumber.setUser(user);
			userPhoneNumberDaoImpl.save(userPhoneNumber);
			return "redirect:/admin/{username}/allStudents";
		}
		@PostMapping("/{userId}/addEmail")
		String addEmail(@PathVariable Map<String, String> pathVars, @ModelAttribute UserEmail userEmail) {
			User user = new User();
			user.setUserId(Integer.parseInt(pathVars.get("userId")));
			userEmail.setUser(user);
			userEmailDaoImpl.save(userEmail);
			return "redirect:/admin/{username}/allStudents";
		}
	
	//transactions
	@GetMapping("/{userId}/seeTransaction")
	String viewTransaction(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("transactions", transactionDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
		model.addAttribute("totalFeesDue", transactionDaoImpl.totalFeesDue());
		return "admin/viewTransaction";
	}
	@GetMapping("/{userId}/addTransaction")
	String addTransaction(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("today", dateTimeUtil.getCurrentDateTime("yyyy-MM-dd"));
		
		return "admin/addTransaction";
	}
	@PostMapping("/{userId}/addTransaction")
	String addTransaction1(@PathVariable Map<String, String> pathVars, @ModelAttribute Transaction transaction) {
		Student student = studentDao.get(Integer.parseInt(pathVars.get("userId")));
		student.setFeesDue(student.getFeesDue() - transaction.getAmount());
		studentDao.update(student);
		transaction.setStudent(student);
		transactionDaoImpl.save(transaction);
		return "redirect:/admin/{username}/allStudents";
	}
	public Student getCurStudent(String userId) {
		return studentDao.get(Integer.parseInt(userId));
	}
	public AllStudents(@PathVariable Map<String, String> pathVars) {
		curUsername = pathVars.get("username");
	}

}
