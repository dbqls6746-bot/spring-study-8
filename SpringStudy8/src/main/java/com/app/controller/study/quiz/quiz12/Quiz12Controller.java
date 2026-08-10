package com.app.controller.study.quiz.quiz12;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz12")
public class Quiz12Controller {
	@GetMapping("/login")
	public String login1() {
		return "quiz/quiz12/login";
	}
	
	@PostMapping("/login")
	public String login2(HttpSession session, String id, String password) {
		
		session.setAttribute("ID", id);
		session.setAttribute("PassWord", password);
		
		return "redirect:/quiz12/count";
	}
	

	@GetMapping("/count")
	public String count(Model model, HttpSession session) {
		String loginId = (String) session.getAttribute("ID");
		
		if(loginId != null) {
			Integer loginCount = (Integer) session.getAttribute("count");
			if (loginCount == null) {
	            loginCount = 0;
	        }
			 loginCount++;
			 
			 session.setAttribute("count", loginCount);
		        
		     model.addAttribute("loginId", loginId);
		     model.addAttribute("count", loginCount);
		} else {
			model.addAttribute("count", 0);
		}
		return "quiz/quiz12/count";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		
		return "redirect:/quiz12/count";
	}
}
