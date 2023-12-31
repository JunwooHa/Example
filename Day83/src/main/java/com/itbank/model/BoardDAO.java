package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.dto.BoardDTO;

public interface BoardDAO {

	@Select("select * from img_board order by idx desc")
	List<BoardDTO> selectAll();
	
	int insert(BoardDTO input);

	@Select("select * from img_board where idx = #{idx}")
	BoardDTO selectOne(int idx);

	@Delete("delete from img_board where idx = #{idx}")
	int delete(int idx);
	
	int update(BoardDTO input);

	String selectIdx();

}
