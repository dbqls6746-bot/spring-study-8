package com.app.controller.study.quiz.quiz06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.quiz.quiz06.BMI;


@Controller
@RequestMapping("/quiz06")
public class Quiz06Controller {
	
	@GetMapping("/ask-bmi")
	public String ask() {
		
		return "quiz/quiz06/bmi";
	}
	
	@PostMapping("/result-bmi")
	public String result(@ModelAttribute BMI bmi, Model model) {
		System.out.println(bmi.toString());
		
		model.addAttribute("name", bmi.getName());
		model.addAttribute("weight", bmi.getWeight());
		model.addAttribute("height", bmi.getHeight());
		model.addAttribute("result", bmi.bmi_r());
		return "quiz/quiz06/bmi-result";
	}
}
