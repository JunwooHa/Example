package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ReplyDAO;
import com.itbank.model.dto.ReplyDTO;

@Service
public class ReplyService {

	@Autowired private ReplyDAO dao;
	
	public List<ReplyDTO> getReply(int board_idx) {
		return dao.selectReplyAll(board_idx);
	}

	public int insert(ReplyDTO input) {
		return dao.insertReply(input);
	}

	public int delete(int idx) {
		return dao.deleteReply(idx);
	}

}
