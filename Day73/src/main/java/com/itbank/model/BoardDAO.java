package com.itbank.model;

import java.util.List;

import com.itbank.model.dto.BoardDTO;
import com.itbank.service.Paging;

public interface BoardDAO {

	List<BoardDTO> selectAll(Paging p);
		
	BoardDTO selectOne(int idx);
		 		  		 
	int insert(BoardDTO input);
		
	int delete(int idx);
		
	int update(BoardDTO input);
	
	int countUp(int idx);

	int getTotalBoard(Paging p);

}
