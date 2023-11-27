package com.itbank.model.dto;

import java.sql.Date;

/*
  	NAME      VARCHAR2(20) 
	HEIGHT    NUMBER       
	BIRTH     DATE 
*/
public class PersonDTO {
	private String name;
	private Double height;
	private Date birth;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
