package com.secure.secureboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.secure.secureboot.entities.User;
import com.secure.secureboot.services.SecurityService;
import com.secure.secureboot.services.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/register")
	public String register() {
		long millis=System.currentTimeMillis();  
		java.sql.Date dates=new java.sql.Date(millis);  
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user){
		
		String originalPassword = user.getPassword();
		if(userService.findByUsername(user.getUsername()) == null) {
			userService.save(user);
		}else {
			return "redirect:/register";
		}
        securityService.autoLogin(user.getUsername(), originalPassword);
        return "redirect:/welcome";
	}

	public RegisterController() {
		// TODO Auto-generated constructor stub
	}

}
