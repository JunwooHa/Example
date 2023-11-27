package com.itbank.model.dto;

import java.sql.Date;

/*
 	IDX        NOT NULL NUMBER        
	TITLE      NOT NULL VARCHAR2(200) 
	CONTENT    NOT NULL CLOB          
	WRITER     NOT NULL VARCHAR2(100) 
	VIEW_COUNT          NUMBER        
	WRITE_DATE          DATE
*/
public class BoardDTO {
	private int idx, view_count;
	private String title, content, writer;
	private Date write_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}	
}
