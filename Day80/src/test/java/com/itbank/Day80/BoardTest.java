package com.itbank.Day80;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.components.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring/root-context.xml"))
public class BoardTest {
	
	@Autowired private BoardDAO dao;
	@Autowired private ReplyService rs;
	
	@Test
	@Ignore
	public void daoTest() {
		Paging p = new Paging(1,dao.totalBoard());
		System.out.println(dao.selectAll(p));
	}
	
	@Test
	@Ignore
	public void selectTest() {
		System.err.println(dao.selectOne(2567));
	}
	
	@Test
	public void showReply() {
		System.err.println(rs.getReply(2548));
	}
}
