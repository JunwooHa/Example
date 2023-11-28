<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<form method="POST">
	<p><input name="title" placeholder="책 제목" value="${row.title }" required></p>
	<p><input name="writer" placeholder="책 저자" value="${row.writer }" required></p>
	<p><input name="publisher" placeholder="출판사" value="${row.publisher }" required></p>
	<p><input name="p_date" type="date" value="${row.p_date }" required></p>
	<p><input name="price" type="number" value="${row.price }" required></p>
	
	<button>전송</button>
</form>
</body>
</html>