package com.itbank.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")				// 4.3 이후 부터 사용 가능한 어노테이션
	public String home() {
		return "home";		// /WEB-INF/views/home.jsp
	}
	
	@GetMapping("/ex01")
	public void ex01() {}	// /WEB-INF/views/ex01.jsp
	
	// Controller 메서드의 반환형
	// 1. String : 반환하는 문자열이 View Name이 된다
	// 2. void : 요청한 uri가 View Name이 된다
	
	@PostMapping("/ex01")
	public String ex01(HttpServletRequest request){
//		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		String msg = name + "님은 "; 
		msg += age >= 19 ? "성인" : "미성년자";
		msg += "입니다~";
		
		request.setAttribute("msg", msg);
		
		return "ex01_result";
	}
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(Model model, String name, int age) {
		// 매개변수와 전송된 parameter의 이름이 같으면 자동으로 저장된다
		
		String msg = name + "님은";
		msg += age >= 19 ? "성인" : "미성년자";
		msg += "입니다~";
		
		model.addAttribute("msg",msg);
		// model은 request의 Attribute를 대체하는 객체
		
		return "ex01_result";
	}
}
