package com.itbank.model;

import java.util.List;

import com.itbank.components.Paging;
import com.itbank.model.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> selectAll(Paging p);

	void testInsert();

	int totalBoard();

	BoardDTO selectOne(int idx);

}
