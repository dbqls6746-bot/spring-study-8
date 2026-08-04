package com.app.controller.study.quiz.quiz03;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.quiz.quiz03.Cafe;
import com.app.dto.quiz.quiz03.DrinkItem;

@Controller
@RequestMapping("/quiz03")
public class Quiz03Controller {
	
	@GetMapping("/request1-1")
	public String request1(HttpServletRequest request) {
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));
		
		request.setAttribute("item", "americano");
		request.setAttribute("type", "coffee");
		
		return "quiz/quiz03/viewData1";
	}
	
	@GetMapping("/request1-2")
	public String request2(@RequestParam("item") String item, @RequestParam("type") String type, Model model) {
		System.out.println(item);
		System.out.println(type);
		
		model.addAttribute("item", item);
		model.addAttribute("type", type);
	
		return "quiz/quiz03/viewData1";
	}
	
	@GetMapping("/request1-3")
	public String request3(@RequestParam Map<String,String> paramMap,Model model) {
		System.out.println(paramMap.get("item"));
		System.out.println(paramMap.get("type"));
		
		for(String key  : paramMap.keySet()) {
			System.out.println(key + " : " + paramMap.get(key));
		}
		
		model.addAttribute("item", paramMap.get("item"));
		model.addAttribute("type", paramMap.get("type"));
		
		return "quiz/quiz03/viewData1";
	}
	
	@GetMapping("/request1-4")
	public String request4(Model model, Cafe cafe) {
		System.out.println(cafe);

		model.addAttribute("cafe",cafe);
		
		return "quiz/quiz03/viewData1";
		}
	
	@GetMapping("/viewData1-1")
	public String viewData1(HttpServletRequest request) {
		
		request.setAttribute("name", "americano");
		request.setAttribute("type", "coffee");
		
		return "quiz/quiz03/viewData2";
	}
	
	
	@GetMapping("/viewData1-2")
	public String viewData2(Model model) {

		model.addAttribute("name", "americano");
		model.addAttribute("type", "coffee");
	
		return "quiz/quiz03/viewData2";
	}
	
	@GetMapping("/viewData1-3")
	public ModelAndView viewData3() {	
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("quiz/quiz03/viewData1");
		mav.addObject("name", "americano");
		mav.addObject("type", "coffee");
		
		return mav;
	}
	
	@GetMapping("/viewData1-4")
	public String viewData4(Model model) {
		
		model.addAttribute("name", "americano");
		model.addAttribute("type", "coffee");
		
		DrinkItem drinkItem = new DrinkItem();
		drinkItem.setName("생수");
		drinkItem.setName("물");
		model.addAttribute("drinkItem",drinkItem);
		
		return "quiz/quiz03/viewData2";
	}
}
