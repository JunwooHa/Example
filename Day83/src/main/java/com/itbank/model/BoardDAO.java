package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.dto.BoardDTO;

public interface BoardDAO {

	@Select("select * from img_board order by idx desc")
	List<BoardDTO> selectAll();

	@Insert("insert into img_board(title, contents, writer) "
			+ "values(#{title}, #{contents}, #{writer})")
	int insert(BoardDTO input);

	@Select("select * from img_board where idx = #{idx}")
	BoardDTO selectOne(int idx);

	@Delete("delete from img_board where idx = #{idx}")
	int delete(int idx);

	@Update("update img_board "
			+ "set "
				+ "title = #{title}, "
				+ "contents = #{contents}, "
				+ "writer = #{writer} "
		  + "where idx = #{idx}")
	int update(BoardDTO input);

}
