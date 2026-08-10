package com.app.controller.study.quiz.quiz11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz11")
public class Quiz11Controller {
	@GetMapping("/first")
	public String first(Model model) {
		model.addAttribute("accessUrl", "/first");
		
		return "quiz/quiz11/targetPage";
	}
	
	
	@GetMapping("/firsthide1")
	public String firsthide1(Model model) {
		model.addAttribute("accessUrl", "/firsthide1");
		
		return "quiz/quiz11/targetPage";
	}
	
	@GetMapping("/firsthide2")
	public String firsthide2() {
		return "redirect:/quiz11/first";
	}
}
