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

import com.secure.secureboot.dao.StaffDao;
import com.secure.secureboot.dao.UserDao;
import com.secure.secureboot.entities.Staff;
import com.secure.secureboot.entities.Teacher;
import com.secure.secureboot.entities.User;

@Controller
@RequestMapping("/admin/{username}/allStaffs")
public class AllStaffs {
	
	@Autowired
	private StaffDao staffDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(" ")
	String allTeachers(@PathVariable Map<String, String> pathVars, Model model) {
		List<Staff> allUsers = staffDao.getAllUsers();
		model.addAttribute("currentUrl", "allTeachers");
		model.addAttribute("username", pathVars.get("username"));
		model.addAttribute("allUsers",staffDao.getAllUsers());
		return "admin/view/allStaffs";
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

	// update user specific information
		@GetMapping("/{userId}/updateSpecInfo")
		String updateSpecInfo(@PathVariable Map<String, String> pathVars, Model model) {
			model.addAttribute("username", pathVars.get("username"));
			model.addAttribute("userId", pathVars.get("userId"));
			model.addAttribute("staff", staffDao.get(Integer.parseInt(pathVars.get("userId"))));
			return "admin/updateStaff";
		}

		@PostMapping("/{userId}/updateSpecInfo")
		String updateSpecInfo(@PathVariable Map<String, String> pathVars, Model model, 
				 @ModelAttribute Staff staff) {
			String s = pathVars.get("userId");
			int k = Integer.parseInt(s);
			User user = new User();
			user.setUserId(k);
			staff.setUser(user);
			staffDao.update(staff);
			return "redirect:/welcome";
		}
	
	public AllStaffs() {
		// TODO Auto-generated constructor stub
	}

}
