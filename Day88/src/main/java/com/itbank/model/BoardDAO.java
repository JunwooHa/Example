package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.itbank.components.Paging;
import com.itbank.model.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectAll(Paging p);

	int insert(BoardVO input);

	int update(BoardVO input);

	int updateTitle(BoardVO input);

	@Delete("delete from board where idx = #{idx}")
	int delete(int idx);

	@Select("select * from board where idx = #{idx}")
	BoardVO selectOne(int idx);

	@Select("select count(*) from board")
	int totalBoard();

}
