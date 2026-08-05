package com.app.dto.quiz.quiz06;

import lombok.Data;

@Data
public class BMI {
	String name;
	int height;
	int weight;
	double result;
	
	public double bmi_r(){
		result = weight/(((height/100.0)*(height/100.0)));
		
		return result;
	}
}
