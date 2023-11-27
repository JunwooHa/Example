package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.DTO.BookDTO;
import com.itbank.model.BookDAO;

@Service
public class BookService {
	
	@Autowired
	private BookDAO dao;
	
	public List<BookDTO> getBook() {		
		return dao.selectAll();
	}

	public BookDTO getBook(int idx) {		
		return dao.selectOne(idx);
	}

	public int addBook(BookDTO input) {
		return dao.insert(input);
	}

	public int update(BookDTO input) {
		return dao.update(input);
	}

	public int delete(int idx) {		
		return dao.delete(idx);
	}

}
