package com.itbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.components.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.model.dto.BoardDTO;

/*
	Transection
	- 단일 작업으로 동작해야 되는 논리적인 작업의 호출 단위
	- 물리적으로 여러개의 Query문이 마치 하나의 Query문 처럼 동작하도록 한다
	
	ACID
	1. 원자성 (Atomicity)		: 분리할 수 없는 하나의 단위, 해당 작업은 모두 실행 혹은 모두 실패 해야한다
	2. 일관성 (Consistency)	: 실행 전과 후의 DB는 일관된 상태를 유지해야 한다
	3. 격리성 (isolation)		: 서로 다른 트랜잭션끼리 간섭 불가
	4. 영속성 (Durability)		: 정상 종료 시 데이터는 영구적으로 보관되어야 한다
*/
@Service
public class BoardService {

	@Autowired private BoardDAO dao;
	
	@Transactional(readOnly = true)							// select문과 같은 조회문에 readOnly를 지정하면
	public Map<String, Object> getBoards(Integer idx) {		// 불필요한 직업을 줄여 성능 향상 및 최적화가 된다
		idx = (idx == null) ? 1 : idx;
		
		Paging p = new Paging(idx, dao.totalBoard());
		List<BoardDTO> list = dao.selectAll(p);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("list", list);
		result.put("p", p);
		
		return result;
	}
	
	// 구문이 없을 땐 구문 하나하나가 트랜잭션이라서 3개는 되고 2개는 예외가 터져 안 들어가짐
	// 이 구문 전체를 트랜잭션으로 만들어서 하나만 예외 터지면 전부 안들어감
	@Transactional
	public void txTestRun() {
		dao.testInsert();
		dao.testInsert();
		dao.testInsert();
		
//		if (1 == 1) {
//			throw new NullPointerException();
//		}
		
		dao.testInsert();
		dao.testInsert();
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getBoard(int idx) {
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("row", dao.selectOne(idx));
		result.put("rps", dao.selectReply(idx));
		
		return result;
	}

	@Transactional
	public String writeBoard(BoardDTO input) {
		int row = dao.insert(input);
		String path = "";
		
		if (row != 0) {
			int idx = dao.selectList();
			System.out.println("idx = " + idx);
			
			path += "view/" + idx;
		}
		return path;
	}

}
