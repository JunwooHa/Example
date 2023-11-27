package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.model.dto.AccountDTO;

public interface AccountDAO {
	
	@Select("select * from account where idx = #{idx}")
	AccountDTO test1(int idx);
	
	@Select("select banner from v$version")
	String test();
	
	@Select("select * from account order by idx desc")
	List<AccountDTO> selectAll();

	@Select("select * from account "
			+ "where userid = #{userid} and userpw = #{userpw}")
	AccountDTO selectOne(AccountDTO input);

}
