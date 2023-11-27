package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.model.AccountDAO;
import com.itbank.model.dto.AccountDTO;

@Transactional // 클래스에 저장시 모든 메서드가 적용
@Service
public class AccountService {
	
	@Autowired private AccountDAO dao;

	@Transactional(readOnly = true)
	public AccountDTO login(AccountDTO input) {			
		return dao.selectOne(input);
	}

	public int addAccount(AccountDTO input) {		
		return dao.insert(input);
	}
	
	
}
