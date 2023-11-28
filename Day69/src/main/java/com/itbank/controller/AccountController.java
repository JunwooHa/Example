package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.DTO.AccountDTO;
import com.itbank.service.AccountService;

@Controller
@RequestMapping("/acc")
public class AccountController {
	
	@Autowired private AccountService as;	
	
	@GetMapping("/view")
	public void view(Model model, int idx) {
		model.addAttribute("acc", as.getAccount(idx));
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(AccountDTO input) {
		
		as.write(input);
		
		return "redirect:/";
		// viewName의 접두어로 redirect:를 기입하면 리다이렉트를 수행
	}

	@GetMapping("/update")
	public ModelAndView update(int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("acc", as.getAccount(idx));
		mav.setViewName("acc/write");
		
		return mav;
	}
	
	@PostMapping("/update")
	public String update(AccountDTO input) {
		
		as.update(input);
		
		return "redirect:/";
	}

	@GetMapping("/delete")
	public ModelAndView delete(int idx) {
		ModelAndView mav = new ModelAndView();
		
		as.delete(idx);
		mav.setViewName("redirect:/");
		
		return mav;
	}
}
