package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.model.dto.ReplyDTO;

public interface ReplyDAO {

	@Select("select * from reply where board_idx = #{idx} order by idx desc")
	List<ReplyDTO> selectAll(int idx);

}
