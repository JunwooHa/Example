package com.itbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.dto.PersonDTO;

@RestController
@RequestMapping("/person")
public class Ex01Controller {

	@GetMapping("/test")	
	public String ex01() {
		return "Hello Spring~";
	}
	
	@GetMapping
	public PersonDTO[] ex02() {
		PersonDTO[] list = new PersonDTO[] {
				new PersonDTO(1, "홍길동", 30),
				new PersonDTO(2, "김민지", 25)
		};
		
		return list;
	}
	
	@GetMapping("/{idx}")
	public PersonDTO ex03(@PathVariable int idx) {
		return new PersonDTO(idx, "홍길동", 30);
	}
}
