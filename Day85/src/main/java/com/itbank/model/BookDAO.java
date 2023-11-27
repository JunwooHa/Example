package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.dto.BookDTO;

public interface BookDAO {

	@Select("select * from book order by idx desc")
	List<BookDTO> selectAll();

	@Select("select * from book where idx = #{idx}")
	BookDTO selectOne(int idx);
	
	int insert(BookDTO input);

	int updateAll(BookDTO input);

	int updatePrice(BookDTO input);

	@Delete("delete from book where idx = #{idx}")
	int delete(int idx);
	
}
