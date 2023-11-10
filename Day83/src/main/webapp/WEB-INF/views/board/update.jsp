<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<form method="POST">
	<section class="board">
		<table>
			<tr>
				<th>제목</th>
				<td><input name="title" value="${row.title }" required></td>				
			</tr>
			<tr>
				<th>작성자</th>
				<td>${row.writer }</td>
			</tr>								
			<tr>
				<td colspan="2"><textarea name="contents">${row.contents }</textarea></td>
			</tr>
		</table>
		
		<br>		
		
		<button>작성</button>
	</section>
</form>
</body>
</html>