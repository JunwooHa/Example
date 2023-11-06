package com.itbank.aop;

import java.security.NoSuchAlgorithmException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itbank.component.SHA512;
import com.itbank.model.dto.AccountDTO;

@Component
@Aspect
public class AccountAOP {
	
	@Autowired private SHA512 hash;
	
	@Before("execution(* com.itbank.service.AccountService.*"
			+ "(com.itbank.model.dto.AccountDTO))")
	public void hash(JoinPoint jp) throws NoSuchAlgorithmException {
		AccountDTO input = (AccountDTO) jp.getArgs()[0];		
		
		if (input.getUserpw() == null) {
			input.setUserpw("0");
		}
		
		input.setUserpw(hash.getHash(input.getUserpw()));			
	}
}
