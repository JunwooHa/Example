package com.itbank.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.SHA512;
import com.itbank.model.AccountDAO;
import com.itbank.model.dto.AccountDTO;

@Service
public class AccountService {
	
	@Autowired private AccountDAO dao;
	@Autowired private SHA512 hash; 

	public String test() {		
		return dao.test();
	}

	public List<AccountDTO> getAcoount() {		
		return dao.selectAll();
	}

	public AccountDTO login(AccountDTO input) throws Exception {
		input.setUserpw(hash.getHash(input.getUserpw()));
		return dao.selectOne(input);
	}

	public int addAccount(AccountDTO input) throws NoSuchAlgorithmException {
		input.setUserpw(hash.getHash(input.getUserpw()));
		return dao.insert(input);
	}

	public int deleteAccount(int idx) {
		return dao.delete(idx);
	}

	public int updateAccount(AccountDTO input) throws NoSuchAlgorithmException {		
		input.setUserpw(hash.getHash(input.getUserpw()));
		return dao.update(input);
	}

}
