package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDAO;
import com.itbank.model.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired private BoardDAO dao;
	
	public List<BoardDTO> getBoards(int reqPage) {		
		// 페이징 코드
		
		return dao.selectAll();
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
