package com.itbank.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 	AOP : Aspect Object Programming
 	- 관점 지향 프로그래밍
 	- 문제를 바라보는 관점을 기준으로 프로그래밍 하는 기법을 의미
 	- 쉽게는 공통적인 관심사를 묶어서 처리
 	- 주로 service 위치에서 활용한다 	
*/

@Component
@Aspect
public class TestAOP {
	
	// 지정한 매서드가 실행되기 전에 먼저 수행
	@Before("execution(* com.itbank.service.*.*(..))")
	public void start() {
		System.out.println("Before 실행~");
	}
}
