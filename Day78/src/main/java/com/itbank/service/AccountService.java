package com.itbank.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
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

	public String findAccount(String email) {
		List<String> ids = dao.selectEmail(email);
		String result = "";
		
		for (String id : ids) {
			result += id + "\\n";
		}
		
		return result;
	}

	public String findAccount(AccountDTO input) throws NoSuchAlgorithmException {
		input = dao.selectAcc(input);
		String msg = "존재하지 않는 계정 정보";
		
		if (input != null) {
			msg = RandomStringUtils.randomAlphanumeric(8);
						
			input.setUserpw(hash.getHash(msg));
			dao.update(input);
		}
		
		return msg;
	}

}
