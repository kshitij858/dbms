package com.secure.secureboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.secure.secureboot.services.SecurityService;
import com.secure.secureboot.services.UserService;


@Controller
public class LoginController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
