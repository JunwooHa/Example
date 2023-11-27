package com.itbank.components;

/*
 	reqPage		사용자가 요청한 페이지
	offset		가져올 페이지 시작점
	perBoard	한 페이지에 출력한 게시글 수 (= 10)
	totalBoard	총 게시글 수 (= 1792)
	totalPage	총 페이지 수
	perPage		한 페이지에 출력할 페이지 번호 수 (= 10)
	section		페이지 범위를 구분할 index 번호
	begin		section의 첫 페이지 번호
	end			section의 마지막 페이지 번호
 */
public class Paging {
	private int reqPage, offset, perBoard = 10;
	private int totalBoard, totalPage, perPage = 10;
	private int section, begin, end;
	private boolean prev, next;
	
	public Paging(int reqPage, int totalBoard) {
		this.reqPage = reqPage;
		this.totalBoard = totalBoard;
		
		offset = (reqPage - 1) * perBoard;
		totalPage = totalBoard / perBoard;
		totalPage += (totalBoard % perBoard == 0) ? 0 : 1;
		
		section = (reqPage - 1) / perPage;
		begin = (section * perPage) + 1;
		end = (section + 1) * perPage;
		
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
