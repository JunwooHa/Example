package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.BookSerivce;
import com.itbank.service.LottoService;

@Controller
public class HomeController {
	
	@Autowired private LottoService ls;
	@Autowired private BookSerivce bs;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");

		mav.addObject("lottos", ls.getLottos(10));	
		mav.addObject("test", bs.test());
		
		return mav;
	}
}
