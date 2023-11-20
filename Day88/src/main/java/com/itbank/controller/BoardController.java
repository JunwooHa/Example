package com.itbank.controller;

import java.util.List;
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

import com.itbank.model.vo.BoardVO;
import com.itbank.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired BoardService bs;
	
	@GetMapping
	public Map<String, Object> getBoards(int reqPage) {
		Map<String, Object> map = bs.getBoards(reqPage);
		
		return map;
	}
	
	@PostMapping
	public int addBoard(@RequestBody(required = false) BoardVO input) {
		return bs.addBoard(input);
	}
	
	@PutMapping
	public int updateBoard(@RequestBody BoardVO input) {
		return bs.updateBoard(input);
	}
	
	@PatchMapping
	public int updateTitle(@RequestBody BoardVO input) {
		return bs.updateTitle(input);
	}
	
	@DeleteMapping
	public int delBoard(@RequestBody BoardVO input) {
		return bs.deleteBoard(input.getIdx());
	}
	
	@GetMapping("/{idx}")
	public BoardVO getBoard(@PathVariable int idx) {
		return bs.getboard(idx);
	}
}
