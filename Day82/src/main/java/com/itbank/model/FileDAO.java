package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.dto.FileDTO;

public interface FileDAO {

	@Insert("insert into "
			+ "upload(name, path, uploader, memo) "
			+ "values(#{name}, #{path}, #{uploader}, #{memo})")
	void insert(FileDTO input);

	@Select("select * from upload order by idx desc")
	List<FileDTO> selectAll();

	@Delete("delete from upload where name = #{name}")
	int delete(FileDTO input);

	@Select("select * from upload where idx = #{idx}")
	FileDTO selectOne(int idx);

	@Update("update upload "
			+ "set "
				+ "uploader = #{uploader}, "
				+ "memo = #{memo}, "
				+ "name = #{name} "
		  + "where idx = #{idx}")
	int update(FileDTO input);

}
