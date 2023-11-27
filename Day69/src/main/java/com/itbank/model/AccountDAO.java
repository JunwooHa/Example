package com.itbank.model;

import java.sql.ResultSet;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itbank.DTO.AccountDTO;

@Repository
public class AccountDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	private RowMapper<AccountDTO> rowMapper = (ResultSet rs,int rowNum) -> {
		AccountDTO row = new AccountDTO();
		
		row.setEmail(rs.getString("email"));
		row.setIdx(rs.getInt("idx"));
		row.setJoin_date(rs.getDate("join_date"));
		row.setNick(rs.getString("nick"));
		row.setUserid(rs.getString("userid"));
		row.setUserpw(rs.getString("userpw"));
		
		return row;
	};
	
	public String banner() {
		String sql = "select banner from v$version";
						
		return jt.queryForObject(sql, String.class);
	}

	public List<AccountDTO> selectAll() {
		String sql = "select * from account order by idx desc";
		
		return jt.query(sql, rowMapper);
		// - query() : 복수 행 조회
	}

	public AccountDTO selectOne(int idx) {
		String sql = "select * from account where idx = ?";
				
		return jt.queryForObject(sql, rowMapper, idx);
		// - queryForObject() : 단건 행 조회
	}

	public int insert(AccountDTO input) {
		String sql = "insert into "
				+ "account(userid, userpw, nick, email) "
				+ "values(?, ?, ?, ?)";		
		return jt.update(sql,
						 input.getUserid(), input.getUserpw(),
						 input.getNick(), input.getEmail());
		// - update() : 테이블의 행 삽입/수정/삭제를 구현
	}

	
	public int update(AccountDTO input) {
		String sql = "update account "
						+ "set "
							+ "userid = ?, "
							+ "userpw = ?, "
							+ "nick = ?, "
							+ "email = ? "
					+ "where idx = ?";
		return jt.update(sql, 
							input.getUserid(), input.getUserpw(), 
							input.getNick(), input.getEmail(), 
							input.getIdx());
	}

	public int delete(int idx) {
		String sql = "delete from account where idx = ?";		
		return jt.update(sql, idx);
	}
}
