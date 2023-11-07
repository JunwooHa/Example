package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.model.dto.BoardDTO;

public interface BoardDAO {

	@Select("select * from board "
				+ "order by idx desc "
				+ "offset 0 rows "
				+ "fetch first 20 rows only")
	List<BoardDTO> selectAll();

}
