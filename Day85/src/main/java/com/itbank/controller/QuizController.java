package com.itbank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.dto.BoardDTO;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@GetMapping
	public List<BoardDTO> quiz() {
		return null;
	}
}
