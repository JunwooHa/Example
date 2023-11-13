<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<section class="board">
	<c:forEach var="row" items="${list }">
		<div>
			<img src="${cpath }/img/${row.img}" width="170px" height="150px">
			<hr>
			${row.idx }<br> ${row.title } (${row.writer })
			<hr>
			👍${row.view_count } ${row.write_date }
		</div>
	</c:forEach>
</section>
</body>
</html>