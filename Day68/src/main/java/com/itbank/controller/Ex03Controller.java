package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.Ex03Service;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	@Autowired						// 객체 타입과 동일한 이름의 Spring Beans를 찾아서 인스턴스를 생성하면
	private Ex03Service es;			// 이를 의존성 주입 (DI)이라고 한다 ( 예)A급 부하직원)
	
	@GetMapping()
	public void ex03() {}
	
	@PostMapping()
	public ModelAndView ex03(String name, int score) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("grade",es.getGrade(score));
		mav.setViewName("ex03_result");
		
		return mav;
	}
}
