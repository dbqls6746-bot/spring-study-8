package com.app.controller.study.quiz.quiz09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quiz09")
public class Quiz09Controller {
	
	@GetMapping("/listTest")
	public String listTest(@RequestParam String type) {
		
		if(type.equals("member") ) {
			return "forward:/quiz07/listTest/member";
		} else if (type.equals("str")) {
			return "redirect:/quiz07/listTest/str";
		}
		
		return "/quiz07/listTest";
	}
}
