package com.itbank.model;

import java.util.List;

import com.itbank.component.Paging;
import com.itbank.model.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> selectAll(Paging p);

	BoardDTO selectOne(int idx);

	int insert(BoardDTO input);

	int updateAll(BoardDTO input);

	int updateContent(BoardDTO input);

	int delete(BoardDTO input);

	int getTotalBoard();

}
