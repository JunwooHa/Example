package com.itbank.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.BoardDAO;
import com.itbank.model.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	
	@Autowired private BoardDAO dao;
	
	@Test
	@Ignore
	public void testlist() {
		List<BoardDTO> list = dao.selectAll();
		assertNotNull(list);
	}
	
	@Test
	@Ignore
	public void listOne() {
		BoardDTO list = dao.selectOne(2554);
		assertNotNull(list);
	}
	
	@Test
	public void insertBoard() {
		BoardDTO list = dao.selectOne(2554);
		
		int row = dao.insert(list);
	}
}
