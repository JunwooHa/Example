package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.dto.BoardDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired private BoardService bs;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", bs.getBoards());	
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("board/view");
		
		mav.addObject("row", bs.getBoard(idx));
		
		return mav;
	}

	@GetMapping("/write")
	public void write() {}

	@PostMapping("/write")
	public ModelAndView write(BoardDTO input) {
		ModelAndView mav = new ModelAndView("msg");				
		
		mav.addObject("row", bs.addBoard(input));
		mav.addObject("message", "글 작성");
		mav.addObject("loc", "board/list");
		
		return mav;
	}
}
