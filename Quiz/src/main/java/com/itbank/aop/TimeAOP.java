package com.itbank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAOP {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Around("execution(* com.itbank.service.*.*(..)) ")
	public Object runTime(ProceedingJoinPoint jp) throws Throwable {
		
		long start = System.currentTimeMillis();					
		Object result = jp.proceed(jp.getArgs());		
		long end = System.currentTimeMillis();
		
		double time = (end - start) / 1000.0;
		log.debug(jp.getSignature().getName() + "실행 시간 : " + time);
		
		System.out.println("총 실행시간 : " + time);		
		
		return result;
	}
}
