package com.app.controller.study.quiz.quiz10;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz10")
public class Quiz10Controller {
	@GetMapping("/A")
	public String A(HttpServletRequest request) {
		request.setAttribute("fromA", "FromA");
		request.setAttribute("OriginalA", "OriginalA");
		
		return "/quiz/quiz10/A";
	}
	
	@GetMapping("/B")
	public String B(HttpServletRequest request, HttpSession session) {
		session.setAttribute("fromB", "FromB");
		request.setAttribute("OriginalB", "OriginalB");
		
		return "/quiz/quiz10/B";
	}
}
