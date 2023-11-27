package com.itbank.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.dto.BookDTO;

public interface BookDAO {
	
	@Select("select banner from v$version")
	String test();
		
	List<BookDTO> selectAll(Map<String, Object> result);
	
	@Select("select * from book where idx = #{idx}")
	BookDTO selectOne(int idx);
	
	@Insert("insert into book "
			+ "values(default, #{title}, #{writer}, "
			+ "#{publisher}, #{p_date}, #{price})")
	int insert(BookDTO input);
	
	@Delete("delete from book where idx = #{idx}")
	int delete(int idx);

	@Update("update book "
			+ "set "
				+ "title = #{title}, "
				+ "writer = #{writer}, "
				+ "publisher = #{publisher}, "
				+ "p_date = #{p_date}, "
				+ "price = #{price} "
			+ "where idx = #{idx}")
	int update(BookDTO input);

}
