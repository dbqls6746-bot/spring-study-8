package com.app.dto.quiz.quiz08;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	String id;
	String pw;
	String name;
	String type;
}
