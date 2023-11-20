package com.itbank.component;

public class Paging {

	private int reqPage, totalBoard;
	private int perCount = 10;
	private int offset, totalPage;
	private int section, begin, end;
	private boolean prev, next;
	
	public Paging(int reqPage, int totalBoard) {
		this.reqPage = reqPage;
		this.totalBoard = totalBoard;
		
		offset = (reqPage - 1) * perCount;
		totalPage = totalBoard / perCount;
		totalPage += (totalBoard % perCount == 0) ? 0 : 1;
		
		section = (reqPage - 1) / perCount;
		begin = section * perCount + 1;	
		end = (section + 1) * perCount;
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

	public int getTotalBoard() {
		return totalBoard;
	}

	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}

	public int getPerCount() {
		return perCount;
	}

	public void setPerCount(int perCount) {
		this.perCount = perCount;
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
