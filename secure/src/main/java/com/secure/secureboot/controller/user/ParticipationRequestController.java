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

import com.secure.secureboot.dao.ParticipationRequestDaoImpl;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.Feedback;
import com.secure.secureboot.entities.ParticipationRequest;
import com.secure.secureboot.entities.User;
import com.secure.secureboot.services.UserService;

@Controller
@RequestMapping("/{currentUser}/{username}")
public class ParticipationRequestController {

	
	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ParticipationRequestDaoImpl participationRequestDaoImpl;
	
	//give participationRequest
		@GetMapping("/giveParticipationRequest")
		String giveParticipationRequest(@PathVariable Map<String, String> pathVars, Model model) {
			return "user/participationRequest/giveParticipationRequest";
		}
		@PostMapping("/giveParticipationRequest")
		String giveParticipationRequest1(@PathVariable Map<String, String> pathVars, 
				@ModelAttribute ParticipationRequest participationRequest){
			User user = new User();
			user.setUserId(userService.findByUsername(pathVars.get("username")).getUserId());
			participationRequest.setUser(user);
			participationRequestDaoImpl.save(participationRequest);
			return "redirect:/welcome";			
		}
		
		//view ParticipationRequest
		@GetMapping("/viewParticipationRequest")
		String viewFeedback(@PathVariable Map<String, String> pathVars, Model model) {
			int userId = userService.findByUsername(pathVars.get("username")).getUserId();
			if(pathVars.get("currentUser").equals("student") || 
					(pathVars.get("currentUser").equals("teacher") ||pathVars.get("currentUser").equals("staff"))) {
				model.addAttribute("allParticipationRequests", participationRequestDaoImpl.getByUserId(userId));
			}else
				model.addAttribute("allParticipationRequests", participationRequestDaoImpl.getAllParticipationRequests());
			return "user/participationRequest/viewParticipationRequest";
		}
		//delete
		@PostMapping("/delete/{participationRequestId}")
		String delete(@PathVariable Map<String, String> pathVars) {
			participationRequestDaoImpl.delete(Integer.parseInt(pathVars.get("participationRequestId")));
			return "redirect:/welcome";
		}
	public ParticipationRequestController() {
		// TODO Auto-generated constructor stub
	}

}
