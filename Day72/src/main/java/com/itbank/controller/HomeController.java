package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.service.BoardService;
import com.itbank.service.Paging;

@Controller
public class HomeController {
	
	@Autowired private BoardService bs;
	
	@GetMapping("/")
	public String home(Model model, String page, String order) {		
		int page1 = (page == null) ? 1 : Integer.parseInt(page);

		Paging ex = new Paging();	
		ex.setType("title");
		ex.setSearch("");
		
		Paging p = new Paging(page1, bs.getTotalBoard(ex), "title", "", null);
						
		model.addAttribute("list", bs.getBoard(p));				
		
		model.addAttribute("p", p);	
				
		return "/board/home";
	}
	
	@PostMapping("/")
	public String home(Model model, String page, String type, String search) {
		int page1 = (page == null) ? 1 : Integer.parseInt(page);
		String type1 = (type == null) ? "title" : type;
		String search1 = (search == null) ? "" : search;
		
		Paging ex = new Paging();
		ex.setType(type1);
		ex.setSearch(search1);
		
		Paging p = new Paging(page1, bs.getTotalBoard(ex), type1, search1, null);
						
		model.addAttribute("list", bs.getBoard(p));				
		
		model.addAttribute("p", p);	
		
		return "/board/home";
	}
}
