package com.itbank.service;

public class Paging {
	private int reqPage, offset, totalPage;
	private int perPage = 10;
	private int perBoard = 10;
	private int totalBoard, section, begin, end;
	private boolean prev, next;	
	
	public Paging(int reqPage, int totalBoard) {
		this.reqPage = reqPage;
		this.totalBoard = totalBoard;
		
		offset = (reqPage - 1) * perPage;
		totalPage = totalBoard / perBoard;
		totalPage += (totalBoard % perBoard == 0) ? 0 : 1;
		
		section = (reqPage - 1) / perPage;
		begin = (section * 10) + 1;
		end = (section + 1) * 10;
		
		end = (end > totalPage) ? totalPage : end;
		
		prev = (section != 0);
		next = (end != totalPage);
	}

	public int getReqPage() {
		return reqPage;
	}

	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getPerBoard() {
		return perBoard;
	}

	public void setPerBoard(int perBoard) {
		this.perBoard = perBoard;
	}

	public int getTotalBoard() {
		return totalBoard;
	}

	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}	
}
