package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbank.service.BoardService;
import com.itbank.service.Paging;

@Controller
public class HomeController {
	
	@Autowired private BoardService bs;
	
	@GetMapping("/")
	public String home(Model model, String page, String type, String search, String order) {		
		int page1 = (page == null) ? 1 : Integer.parseInt(page);
		String type1 = (type == null || type == "") ? "title" : type;
		String search1 = (search == null) ? "" : search;
		String order1 = (order == null || order == "") ? "idx" : order;

		Paging ex = new Paging();	
		ex.setType(type1);
		ex.setSearch(search1);
		ex.setOrder(order1);
		
		Paging p = new Paging(page1, bs.getTotalBoard(ex), type1, search1, order1);
						
		model.addAttribute("list", bs.getBoard(p));				
		
		model.addAttribute("p", p);	
		
		model.addAttribute("ex", ex);
				
		return "/board/home";
	}
}
