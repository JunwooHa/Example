package com.itbank.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.service.FileService;

@Controller
public class HomeController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired private FileService fs;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String home(MultipartFile upload) {
		log.trace("타입 : " + upload.getContentType());
		log.trace("이름1 : " + upload.getName());
		log.trace("이름2 : " + upload.getOriginalFilename());
		log.trace("크기 : " + upload.getSize());
		
		return "home";
	}
	
	@GetMapping("/ex01")
	public void ex01(Model model) throws IOException {
		model.addAttribute("dir", fs.getDir());
	}
	
	@PostMapping("/ex01")
	public String ex01(MultipartFile upload) throws IOException {
		fs.fileUpload(upload);
		
		return "redirect:/ex01";
	}
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(MultipartFile upload, String name) {
		System.out.println(upload.getName());
		System.out.println(name);
		
		return "redirect:/ex01";
	}
}
