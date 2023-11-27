package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.LogDAO;

@Service
public class LogService {

	@Autowired private LogDAO dao;
	
	public String getVersion() {
		return dao.getBanner();
	}

}
