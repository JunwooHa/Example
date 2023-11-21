package com.itbank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.dto.BoardDTO;
import com.itbank.service.BoardService;

@RestController
@RequestMapping("/board")
public class QuizController {

	@Autowired private BoardService bs;
		
	@GetMapping
	public Map<String, Object> getBoards(Model model, int reqPage) {				
		Map<String, Object> map = bs.getBoards(reqPage);
				
		return map;
	}
	
	@GetMapping("/{idx}")
	public BoardDTO getBoard(@PathVariable int idx) {				
		return bs.getBoard(idx);
	}
	
	@PostMapping
	public int addBoard(@RequestBody BoardDTO input) {
		return bs.addBoard(input);
	}
	
	@PutMapping
	public int updateBoard(@RequestBody BoardDTO input) {
		return bs.updateBoard(input);
	}
	
	@PatchMapping
	public int updateContent(@RequestBody BoardDTO input) {
		return bs.updateContent(input);
	}
	
	@DeleteMapping
	public int deleteBoard(@RequestBody BoardDTO input) {
		return bs.deleteBoard(input);
	}
}
