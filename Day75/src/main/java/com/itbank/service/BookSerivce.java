package com.itbank.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;
import com.itbank.model.dto.BookDTO;

@Service
public class BookSerivce {

	@Autowired private BookDAO dao;
	
	public String test() {		
		return dao.test();
	}

	public List<BookDTO> getBook(Map<String, Object> result) {				
		return dao.selectAll(result);
	}

	public BookDTO getBook(int idx) {		
		return dao.selectOne(idx);
	}

	public int addBook(BookDTO input) {
		return dao.insert(input);
	}

	public int deleteBook(int idx) {
		return dao.delete(idx);
	}

	public int updateBook(BookDTO input) {
		return dao.update(input);
	}
	
}
