package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ReplyDao;
import com.itbank.model.vo.ReplyVO;

@Service
public class ReplyService {
	@Autowired private ReplyDao dao;

	public List<ReplyVO> getReplys(int idx) {
		return dao.selectAll(idx);
	}

	public int replyWrite(ReplyVO input) {
		input.setBoard_idx(input.getIdx());
		input.setIdx(0);
		
		return dao.insert(input);
	}
	
	
}
