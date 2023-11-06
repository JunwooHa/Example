package com.itbank.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.component.SHA512;
import com.itbank.model.AccountDAO;
import com.itbank.model.dto.AccountDTO;
import com.itbank.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AccountDAOTest {
	
	@Autowired private AccountService as;
	@Autowired private AccountDAO dao;
	@Autowired private SHA512 hash;
	
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
	@Ignore
	public void testLogin() throws Exception {
		AccountDTO user;
		
		user = as.login(testAcc);
		assertNotNull(user);
	}
	
	@Test	// delete/insert 테스트
	@Ignore
	public void testSignup() throws Exception {
		testAcc.setUserid("testCase123123");
		testAcc.setNick("테스트시 삭제 후 진행");
		
		AccountDTO delAcc = dao.selectTest(testAcc);
		
		// 1. 계정이 있으면 제거 후
		if (testAcc != null) {
			int row = as.deleteAccount(delAcc.getIdx());
			assertNotEquals(0, row);
		}
		
		// 2. insert를 수행
		int row = as.addAccount(testAcc);
		assertNotEquals("이미 있는 계정", 0, row);
		
	}

	@Test
	@Ignore
	public void update() throws NoSuchAlgorithmException {
		testAcc.setUserpw("12345");
		testAcc.setEmail("tt@aa.ab");
		
		int row = as.updateAccount(testAcc);
		assertNotEquals(0, row);
	}

	@Test	
	@Ignore
	public void testGethash() throws NoSuchAlgorithmException {
		System.out.println(hash);
		assertNotNull(hash.getHash("1"));
	}

	@Test
	@Ignore
	public void testFindId() {
		String result = as.findAccount("tt@cc.cc");
		assertNotNull(result);
		
		System.err.println(result);
	}

	@Test
	public void testFindPw() throws NoSuchAlgorithmException {
		String msg = as.findAccount(testAcc);
		
		System.err.println(msg);
	}
}
