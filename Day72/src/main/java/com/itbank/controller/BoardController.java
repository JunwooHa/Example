package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.model.dto.BoardDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired private BoardService bs;
	
	@GetMapping("/view")
	public void view(Model model, int idx) {
		model.addAttribute("row", bs.getBoard(idx));
		bs.CountupBoard(idx);
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO input) {
		
		bs.addBoard(input);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(int idx) {
		
		bs.deleteBoard(idx);
		
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String update(Model model,int idx) {
		
		model.addAttribute("row", bs.getBoard(idx));
		
		return "/board/write";
	}
	
	@PostMapping("/update")
	public String update(BoardDTO input) {
		
		bs.updateBoard(input);
		
		return "redirect:/";
	}
}
