package com.itbank.model.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

/*
 	IDX         NOT NULL NUMBER        
	NAME        NOT NULL VARCHAR2(100) 
	PATH        NOT NULL VARCHAR2(900) 
	UPLOADER    NOT NULL VARCHAR2(150) 
	MEMO                 VARCHAR2(150) 
	UPLOAD_DATE          DATE
	
	upload		파일 처리를 위한 필드
*/
public class FileDTO {
	private int idx;
	private String name, path, uploader, memo;
	private Date date;
	
	private MultipartFile upload;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {		
		this.upload = upload;
	}	
}
