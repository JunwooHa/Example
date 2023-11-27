<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article class="board">
	<table class="boards">
		<tr>
			<th colspan="2">
				${row.idx }.[${row.title }]
			</th>
		</tr>
		<tr>
			<th>저자</th>
			<td>${row.writer }</td>					
		</tr>
		
		<tr>		
			<th>출판사</th>
			<td>${row.publisher }</td>
		</tr>
		
		<tr>
			<th>출판일</th>
			<td>${row.p_date }</td>
		</tr>
		
		<tr>
			<th>가격</th>
			<td>${row.price }</td>
		</tr>
	</table>
</article>
</body>
</html>