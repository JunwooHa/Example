package com.itbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.model.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired private BoardDAO dao;
	
	public Map<String, Object> getBoards(int reqPage) {		
		Paging p = new Paging(reqPage, dao.getTotalBoard());
		
		List<BoardDTO> list = dao.selectAll(p);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("list", list);
		result.put("p", p);
		
		return result;
	}

	public BoardDTO getBoard(int idx) {		
		return dao.selectOne(idx);
	}

	public int addBoard(BoardDTO input) {
		return dao.insert(input);
	}

	public int updateBoard(BoardDTO input) {		
		return dao.updateAll(input);
	}

	public int updateContent(BoardDTO input) {		
		return dao.updateContent(input);
	}

	public int deleteBoard(BoardDTO input) {		
		return dao.delete(input);
	}

}
