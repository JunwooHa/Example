package com.itbank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired private BoardService bs;
	
	@GetMapping(value = {"/", "/{idx}"})
	public ModelAndView home(@PathVariable(required = false) Integer idx) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = bs.getBoards(idx);
		
		mav.addObject("list", result.get("list"));
		mav.addObject("p", result.get("p"));
		mav.setViewName("home");
		
		return mav;
	}
	
	@GetMapping("/txTest")
	public String txTest() {
		bs.txTestRun();
		
		return "redirect:/";
	}
}
