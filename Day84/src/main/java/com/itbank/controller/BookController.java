package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.dto.BookDTO;
import com.itbank.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired private BookService bs;
	
	@GetMapping
	public List<BookDTO> getBooks() {
		
		return bs.getBooks();
	}
	
	@GetMapping("/{idx}")
	public BookDTO getBook(@PathVariable int idx) {
		
		return bs.getBook(idx);
	}
	
	@PostMapping
	public int addBook(BookDTO input) {
		return bs.addBook(input);
	}
}
