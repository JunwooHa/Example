package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.DTO.BookDTO;
import com.itbank.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bs;
	
	@GetMapping("/list")
	public void book(Model model) {
		model.addAttribute("list", bs.getBook());
	}
	
	@GetMapping("/view")
	public void book(Model model,int idx) {
		model.addAttribute("book", bs.getBook(idx));
	}
	
	@GetMapping("/add")
	public void write() {}
	
	@PostMapping("/add")
	public String write(BookDTO input) {
		
		bs.addBook(input);
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/update")
	public ModelAndView update(int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("book", bs.getBook(idx));
		mav.setViewName("book/write");
		
		return mav;
	}
	
	@PostMapping("/update")
	public String update(BookDTO input) {
		
		bs.update(input);
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(int idx) {
		ModelAndView mav = new ModelAndView();
		
		bs.delete(idx);
		mav.setViewName("redirect:/book/list");
		
		return mav;
	}
}
