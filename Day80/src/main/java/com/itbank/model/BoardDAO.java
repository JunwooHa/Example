package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.components.Paging;
import com.itbank.model.dto.BoardDTO;
import com.itbank.model.dto.ReplyDTO;

public interface BoardDAO {

	List<BoardDTO> selectAll(Paging p);

	void testInsert();

	int totalBoard();

	BoardDTO selectOne(int idx);

	int insert(BoardDTO input);

	int selectList();
	
	@Select("select * from reply where board_idx = #{idx} order by idx desc")
	List<ReplyDTO> selectReply(int idx);

}
