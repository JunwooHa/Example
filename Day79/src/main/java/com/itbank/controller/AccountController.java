package com.itbank.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.dto.AccountDTO;
import com.itbank.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService as;

	private ModelAndView setMessage(int row, String msg, String location) {
		ModelAndView mav = new ModelAndView("msg");

		mav.addObject("row", row);
		mav.addObject("message", msg);
		mav.addObject("loc", location);

		return mav;
	}

	@GetMapping("/list")
	public void home(Model model) {
		model.addAttribute("list", as.getAcoount());
		model.addAttribute("ver", as.test());
	}

	@GetMapping("/login")
	public void login() {
	}

	@PostMapping("/login")
	public ModelAndView login(AccountDTO input, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");

		input = as.login(input);

		if (input != null) {
			session.setAttribute("user", input);
		}

		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");

		session.removeAttribute("user");

		return mav;
	}

	@GetMapping("/signUp")
	public void signUp() {
	}

	@PostMapping("/signUp")
	public ModelAndView signUp(AccountDTO input) {
		ModelAndView mav = new ModelAndView("msg");

		mav.addObject("row", as.addAccount(input));
		mav.addObject("message", "가입 ");
		mav.addObject("loc", "account/login");

		return mav;
	}

	@GetMapping("/myPage/{idx}")
	public ModelAndView myPage(AccountDTO input) {
		ModelAndView mav = new ModelAndView("account/myPage");

		return mav;
	}

	@PostMapping("/myPage/{idx}")
	public ModelAndView update(AccountDTO input, @PathVariable int idx) {
		ModelAndView mav = new ModelAndView("msg");

		input.setIdx(idx);

		mav.addObject("row", as.updateAccount(input));
		mav.addObject("message", "갱신 ");
		mav.addObject("loc", "account/list");

		return mav;
	}

	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable int idx, HttpSession session) {
		ModelAndView mav = new ModelAndView("msg");

		mav.addObject("row", as.deleteAccount(idx));
		mav.addObject("message", "탈퇴 ");

		session.removeAttribute("user");

		return mav;
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ModelAndView ex() {
		ModelAndView mav = new ModelAndView("msg");

		mav.addObject("row", 0);
		mav.addObject("message", "");

		return mav;
	}

	@GetMapping("/find")
	public void find() {
	}

	@PostMapping("/findID")
	public ModelAndView findID(String email) {
		String msg = as.findAccount(email);				

		return setMessage(1, msg, "account/login");
	}
	
	@PostMapping("/findPW")
	public ModelAndView findPW(AccountDTO input) 
			throws NoSuchAlgorithmException {
		String msg = as.findAccount(input);
		
		return setMessage(1, msg, "account/login");
	}

	// pk, uk 중복시 예외 발생
	@ExceptionHandler(DuplicateKeyException.class)
	public ModelAndView dke(DuplicateKeyException e) {
		return setMessage(0, "잘못된 접근 방식입니다", null);
	}
}
