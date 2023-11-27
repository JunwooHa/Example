package com.itbank.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class LottoService {
	private TreeSet<Integer> lotto() {
		Random ran = new Random();					// 로또를 받기 위해선 랜덤함수 선언
		TreeSet<Integer> ts = new TreeSet<>();		// list 형태로 받을거니 treeset이고 숫자니 Integer로 받음
		
		while(ts.size() != 6) {						// 리스트 갯수가 6개가 될 때까지 45개의 숫자 중에서 출력
			int num = ran.nextInt(45) + 1;
			ts.add(num);							// 그런 후 리스트에 저장
		}
		
		return ts;
	}

	public Object getLottos(int num) {
		ArrayList<TreeSet<Integer>> list = new ArrayList<>();
		
		for (int i = 1; i <= num; i++) {
			list.add(lotto());		// 앞서 한 함수를 입력한 숫자 만큼 돌림
		}
		
		return list;
	}
}
