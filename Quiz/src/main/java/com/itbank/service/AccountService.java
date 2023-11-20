package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.model.AccountDAO;
import com.itbank.model.vo.AccountVO;

@Service
public class AccountService {

	@Autowired private AccountDAO dao;
	
	public List<AccountVO> getAccounts() {		
		return dao.selectAll();
	}

	public AccountVO login(AccountVO input) {		
		return dao.selectOne(input);
	}

	@Transactional
	public int addAccount(AccountVO input) {
		return dao.insert(input);		
	}

	public int deleteAccount(int idx) {
		return dao.delete(idx);
	}

	public int updateAccount(AccountVO input) {		
		return dao.update(input);
	}
	
}
