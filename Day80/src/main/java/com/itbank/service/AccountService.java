package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.AccountDAO;
import com.itbank.model.dto.AccountDTO;

@Service
public class AccountService {
	
	@Autowired private AccountDAO dao;

	public AccountDTO login(AccountDTO input) {	
		System.out.println("login : ");
		return dao.selectOne(input);
	}
	
	
}
