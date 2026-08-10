package com.app.controller.study.quiz.quiz11;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz11")
public class Quiz11Controller {
	@GetMapping("/first")
	public String first(Model model,HttpSession session) {
		
		
		//session 에 hide3에 들렸다가 왔다? -> /firsthide3 출력
		// 안갔다왔다? -> /first
		
		if(session.getAttribute("accessUrl") == null) {
			//안들렸다가 왔구나	그냥 바로 /first로 접속했구나
			model.addAttribute("accessUrl", "/first");
		} else {
			//firsthide3 들렸다가 왔구나
			//model.addAttribute("accessUrl", "firsthide3");
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
			
			//session 영역 인식하는데 사용 완료 -> 삭제
			session.removeAttribute("accessUrl");
		}
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
	
	@GetMapping("/firsthide3")
	public String firsthide3(HttpSession session) {
		session.setAttribute("accessUrl", "/firsthide3");

		
		return "redirect:/quiz11/first";
	}
}
