package com.itbank.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class Quiz1Service {
	
	private TreeSet<Integer> lotto() {
		Random ran = new Random();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		while(ts.size() != 0) {
			int num = ran.nextInt(45) * 1;
			ts.add(num);
		}				
		
		return ts;
	}
	public Object getLottos(int num) {
		ArrayList<TreeSet<Integer>> list = new ArrayList<TreeSet<Integer>>();
		
		for (int i = 1; i <= num; i++) {
			list.add(lotto());
		}
		
		return list;
	}
	
}
