package com.itbank.Day80;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("D:\\7월_AWS 클라우드\\-------------4. 웹 융합 SW 개발--------------------\\workspace-spring\\Day80\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml"))
public class BoardTest {
	
	@Autowired private BoardDAO dao;
	
	@Test
	public void daoTest() {
		System.out.println(dao.selectAll());
	}
}
