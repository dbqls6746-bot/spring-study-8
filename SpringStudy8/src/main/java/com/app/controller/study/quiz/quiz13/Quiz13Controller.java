package com.app.controller.study.quiz.quiz13;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Quiz13Controller {
	@GetMapping("/quiz13/hideAd")
	public String hideAd(HttpServletRequest request) {
		
		String close = MyCookieUtil.getCookieValue(request, "close");
		
		if(close != null) {
			request.setAttribute("close", close);
		}
		
		return "quiz/quiz13/hideAd";
	}
	
	@PostMapping("/quiz13/hideAd")
	public String hideAd1(HttpServletRequest request, HttpServletResponse response) {
		String close = request.getParameter("close");
		
		if(close == null) {
			Cookie ck = MyCookieUtil.createCookieForRemove("close");
			response.addCookie(ck);
		} else {
			Cookie ck = MyCookieUtil.createCookie("close", "true", 60*60*24);
			response.addCookie(ck);
		}
		return "redirect:/quiz13/hideAd";
	}
}
