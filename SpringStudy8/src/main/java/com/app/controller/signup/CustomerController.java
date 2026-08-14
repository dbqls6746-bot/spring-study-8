package com.app.controller.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.user.User;
import com.app.service.user.UserService;



@Controller("customerController")
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/customer/signup")
	public String signup() {
		return "quiz/quiz16/signup";
	}
	
	@PostMapping("/customer/signup")
	public String addUserAction(User user) {
		System.out.println(user);

		user.setUserType("CUS");
	 	int result = userService.saveCustomerUser(user);
		
	 	if(result > 0) {
			return "redirect:/main";
		} else {
			return "quiz/quiz16/signup";
		}
		
		
	}
}
