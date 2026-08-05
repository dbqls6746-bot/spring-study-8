package com.app.controller.study.quiz.quiz05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz05")
public class Quiz05Controller {
//	@GetMapping("/pathA")
//	public String pathA(Model model) {
//		
//		model.addAttribute("product","A");
//		return "quiz/quiz05/path";
//	}
//	
//	@GetMapping("/pathB")
//	public String pathB(Model model) {
//		
//		model.addAttribute("product","B");
//		return "quiz/quiz05/path";
//	}
//	
//	@GetMapping("/pathCommon/A")
//	public String pathCommonA(Model model) {
//		
//		model.addAttribute("product","A");
//		return "quiz/quiz05/pathCommon/path";
//	}
//	
//	@GetMapping("/pathCommon/B")
//	public String pathCommonB(Model model) {
//		
//		model.addAttribute("product","B");
//		return "quiz/quiz05/pathCommon/path";
//	}
//	
	
	//____________________________________________________
	
	@GetMapping("/path{pk}")
	public String pathA(Model model, @PathVariable String pk) {
		
		model.addAttribute("product",pk);
		return "quiz/quiz05/path";
	}
	
	
	@GetMapping("/pathCommon/{pk}")
	public String pathCommonA(Model model, @PathVariable String pk) {
		
		model.addAttribute("product",pk);
		return "quiz/quiz05/pathCommon/path";
	}
	
}
