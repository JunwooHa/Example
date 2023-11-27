package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public int addBook(@RequestBody BookDTO input) {			
		return bs.addBook(input);		
	}
	
	// put은 데이터 전부를 바꿀 떄 쓰고, patch는 하나만 바꿀 때
	@PutMapping
	public int updateBook(BookDTO input) {
		return bs.updateBook(input);
	}
	
	@PatchMapping
	public int updateBookPrice(BookDTO input) {
		return bs.updatePrice(input);
	}
	
	@DeleteMapping
	public int deleteBook(int idx) {				
		return bs.deleteBook(idx);
	}
}
