<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<table class="board">
	<tr>
		<th colspan="6">${row.idx }.${row.title }</th>
	</tr>

	<tr>
		<th>작성자</th>
		<td>${row.writer }</td>
		<th>조회수</th>
		<td>${row.view_count }</td>
		<th>작성일</th>
		<td>${row.write_date }</td>
	</tr>
	<tr>
		<td colspan="6"><pre>${row.content }</pre></td>
	</tr>
</table>

</body>
</html>