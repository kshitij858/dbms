package com.secure.secureboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.secureboot.entities.User;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String testPage() {
		
		return "home";
	}
	
	@PostMapping("/processReg")
	public String processReg(@ModelAttribute User user) {
		System.out.println(user);
		return "done";
	}
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}

}
