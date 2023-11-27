package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;
import com.itbank.model.dto.BookDTO;

@Service
public class BookService {
	
	@Autowired private BookDAO dao;

	public List<BookDTO> getBooks() {		
		return dao.selectAll();
	}

	public BookDTO getBook(int idx) {		
		return dao.selectOne(idx);
	}

	public int addBook(BookDTO input) {	
		return dao.insert(input);
	}
	
	
}
