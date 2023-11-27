package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.itbank.conponents.Paging;
import com.itbank.model.vo.BoardVO;

public interface BoardDAO {
	@Select("select count(*) from board")
	int totalBoard();
	
	List<BoardVO> selectAll(Paging p);

	BoardVO selectOne(int idx);

	int insertBoard(BoardVO input);

	int updateBoard(BoardVO input);

	@Delete("delete from board where idx = #{idx}")
	int deleteBoard(int idx);

	void viewUpdate(int idx);

}
