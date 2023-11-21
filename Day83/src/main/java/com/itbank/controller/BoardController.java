package com.itbank.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public ModelAndView write(BoardDTO input) throws IOException {
		ModelAndView mav = new ModelAndView("redirect:/");
		
		bs.addBoard(input);
		
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("board/view");
		
		mav.addObject("row", bs.getBoard(idx));
		
		return mav;
	}

	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable int idx) throws Exception {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", bs.deleteBoard(idx));
		mav.addObject("message", "삭제 완료");
		
		return mav;
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("board/write");
		
		mav.addObject("row", bs.getBoard(idx));
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(BoardDTO input) throws IOException {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", bs.updateBoard(input));
		mav.addObject("message", "수정 완료");
		mav.addObject("location", "board/view/" + input.getIdx());
		
		return mav;
	}
}
