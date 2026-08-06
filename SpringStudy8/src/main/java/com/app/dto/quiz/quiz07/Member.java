package com.app.dto.quiz.quiz07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor	//노 메소드
@AllArgsConstructor //풀 메소드
@Data
public class Member {
	String id;
	String pw;
	String name;
	
}
