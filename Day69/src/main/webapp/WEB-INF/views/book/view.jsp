<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<ul>
	<li>번호 : ${book.idx }</li>
	<li>제목 : ${book.title }</li>
	<li>저자 : ${book.writer }</li>
	<li>출판사 : ${book.publisher }</li>
	<li>출판일 : ${book.p_date }</li>
	<li>가격 : ${book.price }</li>	
</ul>

</body>
</html>