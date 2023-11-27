package com.itbank.model;

import org.apache.ibatis.annotations.Select;

public interface LogDAO {

	@Select("select banner from v$version")
	String getBanner();

}
