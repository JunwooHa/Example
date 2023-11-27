package com.itbank.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.dto.BookDTO;
import com.itbank.service.BookSerivce;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired private BookSerivce bs;
	
	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam Map<String, Object> result) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", bs.getBook(result));
		
		return mav;
	}
	
	@GetMapping("/view")
	public void view(Model model, int idx) {
		
		model.addAttribute("row", bs.getBook(idx));
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public ModelAndView add(BookDTO input) {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", bs.addBook(input));
		mav.addObject("message", "추가 성공");
				
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", bs.deleteBook(idx));
		mav.addObject("message", "삭제 성공");
		
		return mav;
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("book/add");
		
		mav.addObject("row", bs.getBook(idx));
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(BookDTO input) {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", bs.updateBook(input));
		mav.addObject("message", "수정 성공");
		
		return mav;
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ModelAndView ex() {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", 0);
		mav.addObject("message", "실패");		
		
		return mav;
	}
}
