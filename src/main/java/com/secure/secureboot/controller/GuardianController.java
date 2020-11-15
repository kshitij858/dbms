package com.secure.secureboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.User;

@Controller
@RequestMapping("/guardian/{username}")
public class GuardianController {

	@Autowired
	private UserDao userDao;
	@RequestMapping("")
	String adminHomePage(@PathVariable Map<String, String> pathVars, Model model) {
		model.addAttribute("username", pathVars.get("username"));
		return "guardian/home";
	}
	
	//viewing information
			//general information
		@GetMapping("/genInfo")
		String viewGenInfo(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			model.addAttribute("user",  userDao.findByUsername(pathVars.get("username")));
			return "generalInfo";
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
	public GuardianController() {
		// TODO Auto-generated constructor stub
	}

}
