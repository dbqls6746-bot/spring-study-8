package com.app.controller.study.quiz.quiz04;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.quiz.quiz04.Cartoon;
import com.app.dto.quiz.quiz04.transferItem;

@Controller
@RequestMapping("/quiz04")
public class Quiz04Controller {
	@GetMapping("/request1-1")
	public String request1(HttpServletRequest request) {
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));

		return "quiz/quiz04/viewData1";
	}
	
	@GetMapping("/request1-2")
	public String request2(@RequestParam("category") String category, @RequestParam("product") String product, Model model) {
		System.out.println(category);
		System.out.println(product);
		
		return "quiz/quiz04/viewData1";
	}
	
	@GetMapping("/request1-3")
	public String request3(Model model, Cartoon cartoon) {
		System.out.println(cartoon);

		model.addAttribute("cartoon",cartoon);
		
		return "quiz/quiz04/viewData1";
		}
	
	@GetMapping("/request1-4")
	public String request4(@RequestParam Map<String,String> paramMap,Model model) {
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));
		
		for(String key  : paramMap.keySet()) {
			System.out.println(key + " : " + paramMap.get(key));
		}
		
		model.addAttribute("category", paramMap.get("category"));
		model.addAttribute("product", paramMap.get("product"));
		
		return "quiz/quiz04/viewData1";
	}
	
	@GetMapping("/viewData1-1")
	public String viewData1(HttpServletRequest request) {
		
		request.setAttribute("category", 100);
		request.setAttribute("product", 4000);
		
		return "quiz/quiz04/viewData2";
	}
	
	@GetMapping("/viewData1-2")
	public String viewData2(Model model) {

		model.addAttribute("category", 100);
		model.addAttribute("product", 4000);
	
		return "quiz/quiz04/viewData2";
	}
	
	@GetMapping("/viewData1-3")
	public ModelAndView viewData3() {	
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("quiz/quiz04/viewData2");
		mav.addObject("category", 100);
		mav.addObject("product", 4000);
		
		return mav;
	}
	
	@GetMapping("/viewData1-4")
	public String viewData4(Model model) {
		
		model.addAttribute("value001", "숫자1");
		model.addAttribute("value099", "숫자2");
		
		transferItem t = new transferItem();
		t.setValue001("이상해씨");
		t.setValue099("킹크랩");
		model.addAttribute("transferItem", t);
		
		return "quiz/quiz04/viewData2";
	}
}
