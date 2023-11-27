package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.dto.AccountDTO;
import com.itbank.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired private AccountService as;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public ModelAndView login(AccountDTO input, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		
		input = as.login(input);
		
		if (input != null) {
			session.setAttribute("user", input);
		}
		
		return mav;
	}

	@GetMapping("/signUp")
	public void signUp() {}
	
	@PostMapping("/signUp")
	public ModelAndView signUp(AccountDTO input) {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", as.addAccount(input));
		mav.addObject("message", "가입 완료");
		mav.addObject("location", "");
		
		return mav;
	}
}
