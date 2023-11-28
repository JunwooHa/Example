package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDAO;
import com.itbank.model.dto.BoardDTO;

@Service
public class BoardService {

	 @Autowired BoardDAO dao;
	
	public List<BoardDTO> getBoard() {		 
		return dao.selectAll();
	}

	public BoardDTO getBoard(int idx) {
		return dao.selectOne(idx);
	}

	public int addBoard(BoardDTO input) {
		return dao.insert(input);
	}

	public int deleteBoard(int idx) {
		return dao.delete(idx);
	}

	public int updateBoard(BoardDTO input) {
		return dao.update(input);
	}

	public int CountupBoard(int idx) {
		return dao.countUp(idx);
	}
	
}
