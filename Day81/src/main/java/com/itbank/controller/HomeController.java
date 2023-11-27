package com.itbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbank.service.LogService;


@Controller
public class HomeController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired private LogService ls;
	
	@GetMapping("/")
	public String home() {
		
		log.error("로그 : Error");
		log.warn("로그 : Warning");
		log.info("로그 : Information");
		log.debug("로그 : Debug");
		log.trace("로그 : Trace");
		
		
		return "home";
	}
	
	@GetMapping("/ex01")
	public void test(Model model) {
		model.addAttribute("ver", ls.getVersion());
		log.trace("실행완료");		
	}
}
