package com.itbank.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.AccountDAO;
import com.itbank.model.dto.AccountDTO;
import com.itbank.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AccountDAOTest {
	
	@Autowired private AccountService as;
	@Autowired private AccountDAO dao;
	private AccountDTO testAcc;
	
	@Before
	public void setUp() {
		testAcc = dao.test1(1001);
	}
	
	@Test
	@Ignore
	public void list() {
		List<AccountDTO> list = dao.selectAll();
		assertNotNull(list);
	}
	
	@Test
	public void testLogin() {
		AccountDTO user;
		
		user = as.login(testAcc);
		assertNotNull(user);
	}
}
