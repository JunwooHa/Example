package com.itbank.model;

import java.util.List;

import com.itbank.model.vo.ReplyVO;

public interface ReplyDao {

	List<ReplyVO> selectAll(int idx);

	int insert(ReplyVO input);

}
