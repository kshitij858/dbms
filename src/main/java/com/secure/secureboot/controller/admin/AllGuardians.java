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

import com.secure.secureboot.dao.GuardianDaoImpl;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.Guardian;
import com.secure.secureboot.entities.Student;
import com.secure.secureboot.entities.User;

@Controller
@RequestMapping("/admin/{username}/allGuardians")
public class AllGuardians {

	@Autowired
	private GuardianDaoImpl guardianDaoImpl;
	@Autowired
	private UserDao userDao;
	//seeing all students
		@RequestMapping(" ")
		String allStudents(@PathVariable Map<String, String> pathVars, Model model) {
			List<Guardian> allUsers = guardianDaoImpl.getAllUsers();
			model.addAttribute("currentUrl", "allGuardians");
			model.addAttribute("username", pathVars.get("username"));
			model.addAttribute("allUsers",guardianDaoImpl.getAllUsers());
			System.out.println("for seeing all guardians");
			System.out.println(guardianDaoImpl.getAllUsers());
			return "admin/view/allGuardians";
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
	public AllGuardians() {
		// TODO Auto-generated constructor stub
	}

}
