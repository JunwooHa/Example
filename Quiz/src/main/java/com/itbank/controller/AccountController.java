package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.AccountVO;
import com.itbank.service.AccountService;

@Controller
@RequestMapping("/acc")
public class AccountController {
	
	@Autowired private AccountService as;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public ModelAndView login(AccountVO input, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		input = as.login(input);
		
		if (input != null) {
			session.setAttribute("user", input);
			mav.setViewName("redirect:/");
		}
		
		return mav;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/";
	}

	@GetMapping("/signUp")
	public void signUp() {}
	
	@PostMapping("/signUp")
	public ModelAndView signUp(AccountVO input) {
		ModelAndView mav = new ModelAndView("redirect:/");
		
		as.addAccount(input);
		
		return mav;
	}

	@GetMapping("/myPage")
	public void myPage() {}
	
	@PostMapping("/update")
	public ModelAndView myPage(AccountVO input,String userpw, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/acc/logout");				
		
		input = (AccountVO) session.getAttribute("user");
		
		input.setUserpw(userpw);			
		
		as.updateAccount(input);
		
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable int idx) {
		
		as.deleteAccount(idx);				
		
		return "redirect:/acc/logout";
	}
}
