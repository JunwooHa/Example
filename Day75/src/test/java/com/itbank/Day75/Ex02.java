package com.itbank.Day75;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Ex02 {
	
	private int num;
	private static int share;
	
	@BeforeClass	// Test 실행시 최초 한번 수행
	public static void setShare() {
		share = 10;
	}
	
	@Before			// Test 마다 앞에 수행
	public void setNum() {
		num = 10;
	}
	
	@Test
	public void run1() {
		System.out.println("\nrun1 실행");
		
		num -= 2;
		share -= 2;
	}
	
	@Test
	public void run2() {
		System.out.println("\nrun2 실행");
		
		num -= 6;
		share -= 6;
	}
	
	@Test
	public void run3() {
		System.out.println("\nrun3 실행");
		
		num -= 1;
		share -= 1;
	}
	
	@After
	public void result() {
		System.out.println("num = " + num);
	}
	
	@After
	public void resultShare() {
		System.out.println("share = " + share);
	}
}
