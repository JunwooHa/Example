package com.itbank.model;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itbank.DTO.BookDTO;

@Repository
public class BookDAO {

	@Autowired
	private JdbcTemplate jt;
	
	RowMapper<BookDTO> rowMapper = (ResultSet rs, int rowNum) -> {
		BookDTO row = new BookDTO();
		
		row.setIdx(rs.getInt("idx"));
		row.setP_date(rs.getDate("p_date"));
		row.setPrice(rs.getInt("price"));
		row.setPublisher(rs.getString("publisher"));
		row.setTitle(rs.getString("title"));
		row.setWriter(rs.getString("writer"));
		
		return row;
	};
	
	public List<BookDTO> selectAll() {		 
		String sql = "select * from book";
		return jt.query(sql, rowMapper);
	}

	public BookDTO selectOne(int idx) {
		String sql = "select * from book where idx = ?";
				
		return jt.queryForObject(sql, rowMapper, idx);
	}

	public int insert(BookDTO input) {
		String sql = "insert into "
						+ "book(title, writer, publisher, p_date, price) "
					+ "values (?, ?, ?, ? ,?)";
		return jt.update(sql, 
				input.getTitle(), input.getWriter(), 
				input.getPublisher(), input.getP_date(), input.getPrice());
	}

	public int update(BookDTO input) {
		String sql = "update book "
						+ "set "
							+ "title = ?, "
							+ "writer = ?, "
							+ "publisher = ?, "
							+ "p_date = ?, "
							+ "price = ? "
					+ "where idx = ?";
		return jt.update(sql, 
				input.getTitle(), input.getWriter(), 
				input.getPublisher(), input.getP_date(), 
				input.getPrice(), input.getIdx());
	}

	public int delete(int idx) {
		String sql = "delete from book where idx = ?";
		return jt.update(sql, idx);
	}

}
