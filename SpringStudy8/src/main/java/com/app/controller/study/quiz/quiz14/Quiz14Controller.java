package com.app.controller.study.quiz.quiz14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/quiz14")


public class Quiz14Controller {
	
	@Autowired	
	PlateBean plateBean;
	
	@Autowired
	CupBean cupBean;
	
	@GetMapping("/fullOrder")
	public String fullOrder(Model model) {
		String coffee = cupBean.getCoffeeBean().getName();
		String dessert = plateBean.getDessertBean().getName();
		System.out.println("컵에 담긴 음료의 이름 - " + coffee);
		System.out.println("접시에 담긴 디저트의 이름 - " + dessert);
		return"quiz/quiz14/CoffeeList";
	}
	
	@GetMapping("/orderCoffee")
	@ResponseBody
	public String orderCoffee(Model model) {
		String coffee = cupBean.getCoffeeBean().getName();
		System.out.println("컵에 담긴 음료의 이름 - " + coffee);
		return coffee;
	}
	
	
	@GetMapping("/orderDessert")
	@ResponseBody
	public String orderDessert(Model model) {
		String dessert = plateBean.getDessertBean().getName();
		System.out.println("접시에 담긴 디저트의 이름 - " + dessert);
		return dessert;
	}
	
	
	

}
