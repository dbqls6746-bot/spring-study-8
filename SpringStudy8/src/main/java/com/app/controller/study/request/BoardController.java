package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
@RequestMapping("/board")
public class BoardController {
	
	//@GetMapping("/board/notice")
	@GetMapping("/notice")
	public String notice() {
		return "board/notice";
	}
	
	//@GetMapping("/board/faq")
	@GetMapping("/faq")
	public String faq() {
		return "board/faq";
	}
	
}
