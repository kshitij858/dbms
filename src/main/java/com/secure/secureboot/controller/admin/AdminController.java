package com.secure.secureboot.controller.admin;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.secure.secureboot.dao.ClassDaoImpl;
import com.secure.secureboot.dao.DressDaoImpl;
import com.secure.secureboot.dao.PositionOfResponsibilityDaoImpl;
import com.secure.secureboot.dao.SectionAndClassImpl;
import com.secure.secureboot.dao.SectionDaoImpl;
import com.secure.secureboot.dao.StudentDao;
import com.secure.secureboot.dao.TeacherDao;
import com.secure.secureboot.dao.TransactionDaoImpl;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.dao.UserEmailDaoImpl;
import com.secure.secureboot.dao.UserPhoneNumberDaoImpl;
import com.secure.secureboot.entities.Classes;
import com.secure.secureboot.entities.Dress;
import com.secure.secureboot.entities.Participation;
import com.secure.secureboot.entities.Section;
import com.secure.secureboot.entities.SectionAndClass;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.Teacher;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.entities.UserEmail;
import com.secure.secureboot.entities.UserPhoneNumber;
import com.secure.secureboot.services.SecurityService;
import com.secure.secureboot.services.UserService;
import com.secure.secureboot.util.DateTimeUtil;


@Controller
@RequestMapping("/admin/{username}")
public class AdminController {
	
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
	private UserDao userDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private PositionOfResponsibilityDaoImpl positionOfResponsibilityDaoImpl;
	@Autowired
	private UserPhoneNumberDaoImpl userPhoneNumberDaoImpl;
	@Autowired
	private UserEmailDaoImpl userEmailDaoImpl;
	@Autowired
	private TransactionDaoImpl transactionDaoImpl;
	@Autowired
	private DateTimeUtil dateTimeUtil;
	@Autowired
	private DressDaoImpl dressDaoImpl;
	//home page of admin
	@RequestMapping("")
	String adminHomePage(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		return "admin/home";
	}
	
	// view all position Of responsibilities
	@GetMapping("/positionOfResponsibilities")
	String positionOfResponsibilities(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("allResponsibilities", 
				positionOfResponsibilityDaoImpl.getAllPositionOfResponsibility());
		return "admin/user/positionOfResponsibility/viewResponsibility";
	}
	
	//create class
	@GetMapping("/createClass")
	String createClass(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		return "admin/createClass";
	}
	@PostMapping("/createClass")
	String createClass(@ModelAttribute Classes classes, Model model,
			@PathVariable Map<String, String> pathVars) {
		classDaoImpl.save(classes);
		model.addAttribute("username", pathVars.get("username"));
		return "redirect:/welcome";
	}
	
	//create Section
		@GetMapping("/createSection")
		String createSection(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			return "admin/createSection";
		}
		@PostMapping("/createSection")
		String createSection(@ModelAttribute Section section, Model model,
				@PathVariable Map<String, String> pathVars) {
			sectionDaoImpl.save(section);
			model.addAttribute("username", pathVars.get("username"));
			return "redirect:/welcome";
		}
		
	//link class and section
	@GetMapping("/classAndSection")
	String linkClassAndSection(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		List<Section> allSections = sectionDaoImpl.getAll();
		List<Classes> allClasses = classDaoImpl.getAll();
		model.addAttribute("allSections", allSections);
		model.addAttribute("allClasses", allClasses);
		return "admin/classAndSection";
	}
	@PostMapping("/classAndSection")
	String linkClassAndSection(@ModelAttribute SectionAndClass sectionAndClass, Model model,
			@PathVariable Map<String, String> pathVars) {
		//sectionDaoImpl.save(section);
		model.addAttribute("username", pathVars.get("username"));
		sectionAndClassImpl.save(sectionAndClass);
		return "welcome";
	}
	//update 
	@GetMapping("/update")
	String updateInformation(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("user", userDao.findByUsername(pathVars.get("username")));
		return "admin/updateUser";
	}
	
	@PostMapping("/updateGenInfo")
	String updateInformation1(@PathVariable Map<String, String> pathVars,
														@ModelAttribute User user){
		userService.update(user, pathVars.get("username"));
		return "redirect:/welcome";
	}
	
	//phone number and emails
			@GetMapping("/{allUsers}/{userId}/viewPhoneNumbers")
			String viewPhoneNumbers(@PathVariable Map<String, String> pathVars, Model model) {
				model.addAttribute("allPhonenumbers", 
						userPhoneNumberDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
				return "user/viewPhoneNumbers";
			}
			@GetMapping("/{allUsers}/{userId}/viewEmails")
			String viewEmails(@PathVariable Map<String, String> pathVars, 
					@ModelAttribute Participation participation,
					Model model) {
				model.addAttribute("allEmails", 
						userEmailDaoImpl.getByUserId(Integer.parseInt(pathVars.get("userId"))));
				return "user/viewEmails";
			}
			@PostMapping("/{allUsers}/{userId}/addPhoneNumber")
			String addPhoneNumber(@PathVariable Map<String, String> pathVars, @ModelAttribute UserPhoneNumber userPhoneNumber) {
				User user = new User();
				user.setUserId(Integer.parseInt(pathVars.get("userId")));
				userPhoneNumber.setUser(user);
				userPhoneNumberDaoImpl.save(userPhoneNumber);
				return "redirect:/welcome";
			}
			@PostMapping("/{allUsers}/{userId}/addEmail")
			String addEmail(@PathVariable Map<String, String> pathVars, @ModelAttribute UserEmail userEmail) {
				User user = new User();
				user.setUserId(Integer.parseInt(pathVars.get("userId")));
				userEmail.setUser(user);
				userEmailDaoImpl.save(userEmail);
				return "redirect:/welcome";
			}
	
	//delete phone number and email
	@GetMapping("/{allUsers}/{userId}/deletePhoneNumber/{phoneNumber}")
	String deletePhoneNumber(@PathVariable Map<String, String> pathVars) {
		userPhoneNumberDaoImpl.delete(pathVars.get("phoneNumber"));
		return "redirect:/admin/{username}/{allUsers}/{userId}/viewPhoneNumbers";
	}
	@GetMapping("/{allUsers}/{userId}/deleteEmail/{email}")
	String deleteEmail(@PathVariable Map<String, String> pathVars) {
		userEmailDaoImpl.delete(pathVars.get("email"));
		return "redirect:/admin/{username}/{allUsers}/{userId}/viewEmails";
	}
	
	//Transactions
	@RequestMapping("/transactions")
	String transactions(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("totalFeesDue", transactionDaoImpl.totalFeesDue());
		model.addAttribute("transactions", transactionDaoImpl.getAllTransactions());
		Date starting = new Date(2000, 01, 01);
		Date today = new Date(Integer.parseInt(dateTimeUtil.getCurrentDateTime("yyyy")), 
				Integer.parseInt(dateTimeUtil.getCurrentDateTime("MM")), 
				Integer.parseInt(dateTimeUtil.getCurrentDateTime("dd")));
		model.addAttribute("starting",starting);
		model.addAttribute("today",today);
		model.addAttribute("rangeTransactions", 
				transactionDaoImpl.rangeTransaction(starting, today));
		return "admin/viewTransaction";
	}
	@RequestMapping("/rangeTransactions")
	String RangeTransactions(@PathVariable Map<String, String> pathVars, @RequestParam("fromDate") Date fromDate, 
			@RequestParam Date tillDate, Model model) {
		model.addAttribute("rangeTransaction", transactionDaoImpl.sumRangeTransaction(fromDate, tillDate));
		model.addAttribute("totalFeesDue", transactionDaoImpl.totalFeesDue());
		model.addAttribute("transactions", transactionDaoImpl.rangeTransaction(fromDate, tillDate));
		Date starting = new Date(2000, 01, 01);
		Date today = new Date(Integer.parseInt(dateTimeUtil.getCurrentDateTime("yyyy")), 
				Integer.parseInt(dateTimeUtil.getCurrentDateTime("MM")), 
				Integer.parseInt(dateTimeUtil.getCurrentDateTime("dd")));
		model.addAttribute("starting",starting);
		model.addAttribute("today",today);
		return "admin/rangeTransaction";
	}
	
	//Dress
	@RequestMapping("/dress")
	String dress(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("dresses", dressDaoImpl.getAll());
		return "admin/dress/dressHome";
	}
	@RequestMapping("/addDress")
	String addDress(@PathVariable Map<String, String> pathVars, @ModelAttribute Dress dress) {
		dressDaoImpl.save(dress);
		return "redirect:/admin/{username}/dress";
	}
	public AdminController() {
		// TODO Auto-generated constructor stub
	}

}