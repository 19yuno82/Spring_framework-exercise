package com.smhrd.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/main")
	public String goMain(Model model) {
		
		//이름이 담진 ArrayList를 가지고 main으로 이동해야 한다
		ArrayList<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("이순신");
		names.add("임꺽정");
		names.add("장길산");
		names.add("왕건");
		names.add("세종");
		
		//객체바인딩(Model, Session)
		model.addAttribute("names",names);
		
		// 만약 thymeleaf를 넣었다면 ViewResolver 설정이 바뀜
		//prefix : /tmeplates/
		// suffix : .html
		return "main";
	}
	
}
