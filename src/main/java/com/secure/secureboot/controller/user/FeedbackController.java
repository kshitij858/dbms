package com.secure.secureboot.controller.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.secureboot.dao.FeedbackDaoImpl;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.Feedback;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.services.UserService;

@Controller
@RequestMapping("/{currentUser}/{username}")
public class FeedbackController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private FeedbackDaoImpl feedbackDaoImpl;
	
	//give feedback
	@GetMapping("/giveFeedback")
	String giveFeedback(@PathVariable Map<String, String> pathVars, Model model) {
		return "user/Feedback/giveFeedback";
	}
	@PostMapping("/giveFeedback")
	String giveFeedback1(@PathVariable Map<String, String> pathVars, @ModelAttribute Feedback feedback,
			Model model) {
		User user = new User();
		user.setUserId(userService.findByUsername(pathVars.get("username")).getUserId());
		feedback.setUser(user);
		feedbackDaoImpl.save(feedback);
		return "redirect:/welcome";			
	}
	//view feedbacks
	@GetMapping("/viewFeedback")
	String viewFeedback(@PathVariable Map<String, String> pathVars, Model model) {
		int userId = userService.findByUsername(pathVars.get("username")).getUserId();
		if((pathVars.get("currentUser").equals("student") || 
				(pathVars.get("currentUser").equals("teacher") ||pathVars.get("currentUser").equals("staff")))
				||(pathVars.get("currentUser").equals("guardian"))) {
			model.addAttribute("allFeedbacks", feedbackDaoImpl.getByUserId(userId));
		}else
			model.addAttribute("allFeedbacks", feedbackDaoImpl.getAllFeedbacks());
		return "user/Feedback/viewFeedback";
	}
	public FeedbackController() {
		// TODO Auto-generated constructor stub
	}

}
