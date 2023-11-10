package com.itbank.model;

import org.apache.ibatis.annotations.Insert;

import com.itbank.model.dto.FileDTO;

public interface FileDAO {

	@Insert("insert into "
			+ "upload(name, path, uploader, memo) "
			+ "values(#{name}, #{path}, #{uploader}, #{memo})")
	void insert(FileDTO input);

}
