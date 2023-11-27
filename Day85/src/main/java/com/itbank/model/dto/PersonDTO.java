package com.itbank.model.dto;

public class PersonDTO {
	private int idx, age;
	private String name;
	
	public PersonDTO(int idx, String name,int age) {
		this.name = name;
		this.age = age;
		this.idx = idx;
	}
	
	public PersonDTO() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}			
}
