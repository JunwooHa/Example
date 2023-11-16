package com.itbank.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itbank.component.SHA512;
import com.itbank.model.vo.AccountVO;

@Aspect
@Component
public class LoginAOP {
	
	@Autowired private SHA512 hash;
	
	@Around("execution(* com.itbank.service.AccountService.*(com.itbank.model.vo.AccountVO))")
	public Object hash(ProceedingJoinPoint jp) throws Throwable {
		// before
		AccountVO input = (AccountVO) jp.getArgs()[0];
//		System.out.println("해시 전 : " + input.getUserpw());
		
		input.setUserpw(hash.getHash(input.getUserpw()));				
		
		// 지정 매서드 실행
		Object result = jp.proceed(jp.getArgs());		
		
		// after
//		System.out.println("해시 후 : " + input.getUserpw());
		
		return result;
	}
}
