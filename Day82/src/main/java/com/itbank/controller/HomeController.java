package com.itbank.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.dto.FileDTO;
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
	public void ex02(Model model) throws IOException {
		model.addAttribute("dir", fs.getDir());
	}
	
	@PostMapping("/ex02")
	public String ex02(MultipartFile upload, String name) throws IOException {
		fs.fileUpload(upload, name);
		
		return "redirect:/ex01";
	}
	
	@GetMapping("/ex03")
	public void ex03(Model model) {
		model.addAttribute("dir", fs.getFiles());
	}
	
	@PostMapping("/ex03")
	public String ex03(FileDTO input) throws IOException {		
		fs.fileUpload(input);
		
		
		return "redirect:/ex03";
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(FileDTO input) throws IOException {
		ModelAndView mav = new ModelAndView();
		
		fs.deleteFile(input);
		mav.setViewName("redirect:/ex03");
		
		return mav;
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();			
		
		mav.addObject("row", fs.getFile(idx));
		mav.setViewName("ex03_update");
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public String update(FileDTO input) throws IOException {
		fs.updateFile(input);
		
		
		return "redirect:/ex03";
	}
}
