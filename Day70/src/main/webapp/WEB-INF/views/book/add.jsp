<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<form method="POST">
		<p><input name="title" placeholder="제목" required value="${book.title }"></p>
		<p><input name="writer" placeholder="저자" required value="${book.writer }"></p>
		<p><input name="publisher" placeholder="출판사" required value="${book.publisher }"></p>
		<p><input name="p_date" type="date" required value="${book.p_date }"></p>
		<p><input name="price" placeholder="가격" required value="${book.price }"></p>
		
		<button>추가</button>
	</form>

</body>
</html>