package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/list")
	public void home(Model model) {		
		model.addAttribute("list", as.getAcoount());
		model.addAttribute("ver", as.test());		
	}
	
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
}
