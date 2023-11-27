package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.service.Ex04Service;

/*
	프레임워크 : 공장 (맞춰진 환경)
	라이브러리 : 도구 (프레임워크에 필요한 도구들을 클라이언트에게 제공하는 역할)

	servlet-context = 요청과 관련된 것만 등록
	root-context = 요청을 제외한 것들만 등록
*/

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	
	@Autowired
	private Ex04Service es;
	
	@GetMapping
	public void ex04(Model model) {
		
		model.addAttribute("ver", es.test());
		model.addAttribute("list", es.getPersons());
	}
}
