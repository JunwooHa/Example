<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
	<h4>책 추가~~</h4>
	
	<form method="POST">
		<p><input name="title" placeholder="제목" required value="${book.title }"></p>
		<p><input name="writer" placeholder="저자" required value="${book.writer }"></p>
		<p><input name="publisher" placeholder="출판사" required value="${book.publisher }"></p>
		<p><input name="p_date" type="date" placeholder="출판일" required value="${book.p_date }"></p>
		<p><input name="price" type="number" placeholder="가격" required value="${book.price }"></p>
		
		<button>전송</button>
	</form>
	
</body>
</html>