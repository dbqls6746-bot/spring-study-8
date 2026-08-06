package com.app.controller.study.quiz.quiz07;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.quiz.quiz07.Member;

@Controller
@RequestMapping("/quiz07")
public class Quiz07Controller {
	@RequestMapping("/listTest")
	public String listTest(@RequestParam("type") String type, Model model ) {
		
		
		if(type.equals("str") ) {
			model.addAttribute("model", "스트링 리스트입니다.");
		}
			
		if(type.equals("member")) {
			List<Member> memberList = new ArrayList<Member>();
			memberList.add(new Member("아이디1", "비번1", "이름1"));
			memberList.add(new Member("아이디2", "비번2", "이름2"));
			memberList.add(new Member("아이디3", "비번3", "이름3"));
			memberList.add(new Member("아이디4", "비번4", "이름4"));
			memberList.add(new Member("아이디5", "비번5", "이름5"));
			
			model.addAttribute("memberList", memberList);
		}
		
		return "quiz/quiz07/listTest";
	}
	
}
