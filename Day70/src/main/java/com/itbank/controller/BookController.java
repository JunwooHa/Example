package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.model.dto.BookDTO;
import com.itbank.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired private BookService bs;
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(BookDTO input) {
		bs.addBook(input);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(int idx) {
		bs.deleteBook(idx);
		
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String update(Model model, int idx) {
		
		model.addAttribute("book", bs.getBooks(idx));
		
		return "book/add";
	}
	
	@PostMapping("/update")
	public String update(BookDTO input) {
		
		bs.updateBook(input);
		
		return "redirect:/";
	}
}
