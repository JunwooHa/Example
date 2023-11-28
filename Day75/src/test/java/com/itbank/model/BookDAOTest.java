package com.itbank.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.dto.BookDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BookDAOTest {
	
	@Autowired private BookDAO dao;	
	
	@Test
	@Ignore		// 테스트를 위해 작성했지만 후 테스트에서 제외하고 싶은 경우
	public void connectionTest() {
		System.out.println("dao = " + dao);
		System.out.println("banner = " + dao.test());
	}
	
	@Test
	public void booklist() {
		Map<String, Object> result = new HashMap<>();
		result.put("type", "title");
		result.put("search", "실록");
		
		List<BookDTO> list = dao.selectAll(result);
		
		assertNotNull(list);
		
		
		for (BookDTO row : list) {
			System.err.println(row);
		}
	}
	
	@Test
	@Ignore
	public void bookselect() {
		int idx = 1001;
		BookDTO list = dao.selectOne(idx);
		
		assertNotNull(list);
		
		System.err.println(list);
	}
	
	// 테스트에서 호출해서 사용하는 매서드로 작성가능
	// 테스트 실행시 @Test 어노테이션이 붙은 것만 프레임워크가 실행
	private BookDTO setField() {
		BookDTO input = new BookDTO();
		Date date = Date.valueOf("2023-10-01");
		
		input.setP_date(date);
		input.setPrice(10000);
		input.setPublisher("테스트");
		input.setTitle("시험용");
		input.setWriter("존슨");
		
		return input;
	}
		
	@Test
	@Ignore
	public void insert() {
		BookDTO input = setField();
		
		int row = dao.insert(input);
		
		assertNotEquals(0, row);
	}
	
	@Test
	@Ignore
	public void updateBook() {
		int idx = 1001;
		BookDTO input = dao.selectOne(idx);
		int row = dao.update(input);
		
		System.err.println(row);
	}
	
	
	@After
	public void end() {
		System.out.println();
	}
}
